package com.hospitalmanagementsytem.qa.modules.doctor;

import com.hospitalmanagementsytem.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientPage extends TestBase {
    @FindBy(xpath = "//button[contains(text(),'Add Patient')]")
    private WebElement AddPatient;
    @FindBy(name="name")
    private WebElement patientName;
    @FindBy(name="email")
    private WebElement patientEmail;
    @FindBy(name="password")
    private WebElement patientPassword;
    @FindBy(name="phone")
    private WebElement patientPhoneNumber;
    @FindBy(name="address")
    private WebElement patientAddress;
    @FindBy(name="sex")
    private WebElement patientSex;
    @FindBy(name="birth_date")
    private WebElement patientBirthDate;
    @FindBy(name="blood_group")
    private WebElement patientBloodGroup;
    @FindBy(name="image")
    private WebElement patientImage;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//button[text()='Close']")
    private WebElement closeButton;
    @FindBy(xpath = "//button[text()='×']/following-sibling::h4[text()='Hospital Management System']")
    private WebElement closeIcon;
    public PatientPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
