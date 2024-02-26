package com.hospitalmanagementsytem.qa.modules.nurse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NurseLoginPage {
    private final WebDriver driver;
    @FindBy(id="email")
    @CacheLookup
    private WebElement email;
    @FindBy(id="password")
    @CacheLookup
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    private WebElement loginButton;
    public NurseLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
