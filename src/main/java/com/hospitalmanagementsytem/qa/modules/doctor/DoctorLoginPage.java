package com.hospitalmanagementsytem.qa.modules.doctor;

import com.hospitalmanagementsytem.qa.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DoctorLoginPage extends TestBase {
    @FindBy(id = "email")
    @CacheLookup
    private WebElement email;
    @FindBy(id = "password")
    @CacheLookup
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    private WebElement loginButton;
    @FindBy(xpath = "//a[@class='logo']")
    private WebElement logo;
    private WebDriverWait wait;

    public DoctorLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void emailTextfield(String doctorEmail) {
        email.sendKeys(doctorEmail);
    }

    public void passwordTextField(String doctorPassword) {
        password.sendKeys(doctorPassword);
    }

    public String pageTitle() {
        return driver.getTitle();
    }

    public void loginPageLogo() throws IOException {
        File temp = logo.getScreenshotAs(OutputType.FILE);
        File src = new File("./errorShots/HMS.jpg");
        FileHandler.copy(temp, src);
    }

    public DoctorDashBoardPage loginButton() {
        loginButton.click();
        return new DoctorDashBoardPage(driver);
    }

    public DoctorDashBoardPage login(String doctorEmail, String doctorPassword) throws InterruptedException {
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            try {
                wait.until(ExpectedConditions.visibilityOf(email));
                email.sendKeys(doctorEmail);
                wait.until(ExpectedConditions.visibilityOf(password));
                password.sendKeys(doctorPassword);
                wait.until(ExpectedConditions.elementToBeClickable(loginButton));
                loginButton.click();
                isLoggedIn = true;
            } catch (StaleElementReferenceException e) {
                driver.navigate().refresh();
                wait.until(ExpectedConditions.visibilityOf(email));
            }
        }
        return new DoctorDashBoardPage(driver);
    }

}

