package com.hospitalmanagementsytem.qa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hospitalmanagementsytem.qa.util.TestUtil;
import com.hospitalmanagementsytem.qa.util.WebEventListner;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class TestBase {
    public static  WebDriver driver;
    public WebDriverWait wait;
    public Actions action;
    public TakesScreenshot takesScreenshot;
    public JavascriptExecutor javascriptExecutor;
    public SoftAssert softAssert;
    public Properties prop;
    public EventFiringWebDriver eventFiringWebDriver;
    public WebEventListner webEventListner;
    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;
    FileInputStream fileInputStream;
    private Logger log;
    public TestBase(){
        try{
            prop=new Properties();
            fileInputStream=new FileInputStream("C:\\Users\\cheta\\IdeaProjects\\HospitalManagementSystem\\src\\main\\java\\com\\hospitalmanagementsytem\\qa\\configure\\Property.properties");
            try{
                prop.load(fileInputStream);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @BeforeSuite
    public void onStart(ITestContext testContext) {
        String timeStamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        String repName="TestReport-"+timeStamp+".html";

        extentSparkReporter=new ExtentSparkReporter("./TestOutput/"+repName);
        try {
            extentSparkReporter.loadXMLConfig("C:\\Users\\cheta\\IdeaProjects\\HospitalManagementSystem\\target\\classes\\extent-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Host Name","LocalHost");
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("user","Chethan");

        extentSparkReporter.config().setDocumentTitle("ShoppersStack Test Project");
        extentSparkReporter.config().setReportName("End-End Testing");
        extentSparkReporter.config().setTheme(Theme.DARK);
    }

    @Parameters("browserName")
    @BeforeClass
    public void setUp(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            log.info("Browser is not matching...");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGELOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICITLY_WAIT));
        driver.get(prop.getProperty("URL"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
        takesScreenshot = (TakesScreenshot) driver;
        javascriptExecutor = (JavascriptExecutor) driver;
        softAssert = new SoftAssert();

        eventFiringWebDriver = new EventFiringWebDriver(driver);
        webEventListner = new WebEventListner();
        eventFiringWebDriver.register(webEventListner);
        driver = eventFiringWebDriver;
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
            driver.quit();
    }

    @AfterSuite
    public void onFinish(ITestContext testContext) {
        extentReports.flush();
    }
}
