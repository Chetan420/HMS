package com.hospitalmanagementsytem.qa.modules.doctor;

import com.hospitalmanagementsytem.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestedAppointments extends TestBase {
    @FindBy(partialLinkText = "Approve")
    private WebElement approveLink;
    @FindBy(partialLinkText = "Delete")
    private WebElement deleteButton;
    @FindBy(css = "input[value='Approve']")
    private WebElement approveButton;
    public RequestedAppointments(WebDriver driver) {
    }
}
