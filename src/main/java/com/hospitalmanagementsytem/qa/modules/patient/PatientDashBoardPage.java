package com.hospitalmanagementsytem.qa.modules.patient;

import com.hospitalmanagementsytem.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PatientDashBoardPage extends TestBase {
    public PatientDashBoardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
