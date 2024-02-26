package com.hospitalmanagementsytem.qa.modules.doctor;

import com.hospitalmanagementsytem.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends TestBase {
    @FindBy(name = "name")
    private WebElement name;
    @FindBy(name="email")
    private WebElement email;
    @FindBy(name="address")
    private WebElement address;
    @FindBy(name="phone")
    private WebElement phoneNumber;
    @FindBy(xpath = "//input[@value='Update']")
    private WebElement update;
    @FindBy(name="old_password")
    private WebElement oldPassword;
    @FindBy(name="new_password")
    private WebElement newPassword;
    @FindBy(name="confirm_new_password")
    private WebElement confirmNewPassword;

    public ProfilePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
