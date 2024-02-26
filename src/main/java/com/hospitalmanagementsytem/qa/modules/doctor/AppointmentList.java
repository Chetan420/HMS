package com.hospitalmanagementsytem.qa.modules.doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentList {
    @FindBy(xpath = "//button[contains(text(),'Add Appointment')]")
    private WebElement addAppointmentButton;
    @FindBy(name="date_timestamp")
    private WebElement calander;
    @FindBy(xpath = "//td[normalize-space()='15']")
    private WebElement date;
    @FindBy(xpath = "//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']")
    private WebElement next;
    @FindBy(xpath = "//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")
    private  WebElement previous;
    @FindBy(id="s2id_autogen1")
    private WebElement patientName;
    @FindBy(css = "input[class='select2-input']")
    private WebElement nameFiled;
    @FindBy(id="notify")
    private WebElement notifyChexkBox;
    @FindBy(css = "input[value='Submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//button[text()='Close']")
    private WebElement closeButton;
    @FindBy(partialLinkText = "Delete")
    private WebElement deleteButton;
    @FindBy(partialLinkText = "Edit")
    private WebElement editButton;
    @FindBy(css = "input[value='Update']")
    private WebElement updateButton;
    public AppointmentList(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

}
