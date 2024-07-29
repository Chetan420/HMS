package com.hospitalmanagementsytem.qa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hospitalmanagementsytem.qa.util.TestUtil;
import com.hospitalmanagementsytem.qa.util.WebEventListner;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

public class TestBase {
    public DesiredCapabilities desiredCapabilities;
    public static WebDriver driver;
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

    public TestBase() {
        try {
            prop = new Properties();
            fileInputStream = new FileInputStream("C:\\Users\\cheta\\IdeaProjects\\HospitalManagementSystem\\src\\main\\java\\com\\hospitalmanagementsytem\\qa\\configure\\Property.properties");
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        String repName = "TestReport-" + timeStamp + ".html";

        extentSparkReporter = new ExtentSparkReporter("./TestOutput/" + repName);
        try {
            extentSparkReporter.loadXMLConfig("C:\\Users\\cheta\\IdeaProjects\\HospitalManagementSystem\\target\\classes\\extent-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Host Name", "LocalHost");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("user", "Chethan");

        extentSparkReporter.config().setDocumentTitle("ShoppersStack Test Project");
        extentSparkReporter.config().setReportName("End-End Testing");
        extentSparkReporter.config().setTheme(Theme.DARK);
    }

    @Parameters({"browserName","osVersion","browserVersion","build","test"})
    @BeforeClass
    public void setUp(@Optional("chrome") String browserName,String osVersion,String browserVersion,String build,String test) {
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", prop.getProperty("lamdaTestUsername"));
        ltOptions.put("accessKey", prop.getProperty("lamdaTestAccessKey"));
        ltOptions.put("video", true);
        ltOptions.put("build", build);
        ltOptions.put("project", "HospitalManagementSystem");
        ltOptions.put("name", test);
        ltOptions.put("selenium_version", "4.22.0");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");

        String HUB_URL = String.format("https://%s:%s@hub.lambdatest.com/wd/hub",
                prop.getProperty("lamdaTestUsername"),
                prop.getProperty("lamdaTestAccessKey"));
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName(osVersion);
                browserOptions.setBrowserVersion(browserVersion);
                browserOptions.setCapability("LT:Options", ltOptions);
                try {
                    driver = new RemoteWebDriver(new URL(HUB_URL), browserOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

            }
            else if (browserName.equalsIgnoreCase("edge")) {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setPlatformName(osVersion);
                browserOptions.setBrowserVersion(browserVersion);
                browserOptions.setCapability("LT:Options", ltOptions);
                try {
                    driver = new RemoteWebDriver(new URL(HUB_URL), browserOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (browserName.equalsIgnoreCase("firefox")) {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName(osVersion);
                browserOptions.setBrowserVersion(browserVersion);
                browserOptions.setCapability("LT:Options", ltOptions);
                try {
                    driver = new RemoteWebDriver(new URL(HUB_URL), browserOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (browserName.equalsIgnoreCase("safari")) {
                SafariOptions browserOptions = new SafariOptions();
                browserOptions.setPlatformName(osVersion);
                browserOptions.setBrowserVersion(browserVersion);
                browserOptions.setCapability("LT:Options", ltOptions);
                try {
                    driver = new RemoteWebDriver(new URL(HUB_URL), browserOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                Reporter.log("Browser mismatch....");
                throw new IllegalArgumentException("Browser not supported: " + browserName);
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
        catch (SessionNotCreatedException e) {
            throw new RuntimeException("Could not create session. Please check the Selenium Grid configuration and response.", e);
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void onFinish(ITestContext testContext) {
        extentReports.flush();
    }
}
