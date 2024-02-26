package com.hospitalmanagementsytem.qa.modules.patient;

import com.hospitalmanagementsytem.qa.base.TestBase;
import com.hospitalmanagementsytem.qa.modules.doctor.DoctorDashBoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 class PatientLoginPage extends TestBase {
    @FindBy(id="email")
    @CacheLookup
    private WebElement email;
    @FindBy(id="password")
    @CacheLookup
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(xpath = "//span[text()='Appointment']")
    private WebElement appointment;
    @FindBy(xpath = "//span[text()='Appointment List']")
    private WebElement appointmentList;
    @FindBy(xpath = "//span[text()='Pending Appointments']")
    private WebElement pendingAppointment;

    public PatientLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void emailTextField(String patientEmail) {
        email.sendKeys(patientEmail);
    }
    public void passwordTextField(String patientPassword){
        password.sendKeys(patientPassword);
    }
    public PatientDashBoardPage loginButton(){
        loginButton.click();
        return new PatientDashBoardPage(driver);
    }
}
