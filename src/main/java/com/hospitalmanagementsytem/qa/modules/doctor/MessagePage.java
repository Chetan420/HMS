package com.hospitalmanagementsytem.qa.modules.doctor;

import com.hospitalmanagementsytem.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MessagePage extends TestBase {
    public MessagePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
