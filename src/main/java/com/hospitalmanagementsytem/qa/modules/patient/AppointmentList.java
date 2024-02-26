package com.hospitalmanagementsytem.qa.modules.patient;

import com.google.j2objc.annotations.Weak;
import com.hospitalmanagementsytem.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentList extends TestBase {
    @FindBy(xpath = "//button[contains(text(),'Apply For Appointment')]")
    private WebElement applyAppointmentButton;
    @FindBy(name="date_timestamp")
    private WebElement date;
    @FindBy(name="time_timestamp")
    private WebElement time;
    @FindBy(id="select2-drop-mask")
    private WebElement selectDoctor;
    @FindBy(css = "input[fdprocessedid='jss1rl']")
    private WebElement searchDoctor;
    public AppointmentList(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
