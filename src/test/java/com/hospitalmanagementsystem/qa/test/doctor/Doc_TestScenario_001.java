package com.hospitalmanagementsystem.qa.test.doctor;

import com.hospitalmanagementsytem.qa.base.TestBase;

import com.hospitalmanagementsytem.qa.modules.doctor.DoctorDashBoardPage;
import com.hospitalmanagementsytem.qa.modules.doctor.DoctorLoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
@Listeners(com.hospitalmanagementsytem.qa.util.ExtentReport.class)
public class Doc_TestScenario_001 extends TestBase {
    DoctorLoginPage doctorLoginPage;
    DoctorDashBoardPage doctorDashBoardPage;
    private Logger log;
    public Doc_TestScenario_001(){
        super();
    }

    @Test(priority = 1)
    public void testCase_001() throws InterruptedException {
        log= LogManager.getLogger(this.getClass().getName());
        log.info("Verify that User can Login to the Application with valid Credentials.");
        Thread.sleep(1000);
        doctorLoginPage=new DoctorLoginPage(driver);
        String email=prop.getProperty("doctorEmail");
        String password=prop.getProperty("doctorPassword");
        log.info("Entering the Email");
        log.info("Entering the Password");
        log.info("Clicking the Login Button");
        doctorDashBoardPage=doctorLoginPage.login(email,password);
        Thread.sleep(5000);
        String actualTitle=doctorDashBoardPage.pageTitle();
        String expectedTitle="Doctor Dashboard - Hospital Management System";
        log.info("Verifying the title");
        Assert.assertEquals(actualTitle,expectedTitle);
        log.info("Home page Title is matching");
        doctorDashBoardPage.logout();

    }
    @Test(priority = 2)
    public void testCase_002() throws InterruptedException {
        log.info("Verify that User can Login to the Application with Invalid Credentials.");
        Thread.sleep(500);
        String email=prop.getProperty("doctorEmail");
        String password=prop.getProperty("doctorPassword");
        log.info("Entering the Email");
        log.info("Entering the Password");
        log.info("Clicking the Login Button");
        doctorDashBoardPage=doctorLoginPage.login(email,password);
        Thread.sleep(5000);
        String actualTitle=doctorLoginPage.pageTitle();
        String expectedTitle="Login | Hospital Management System";
        log.info("Verifying the Title");
        Assert.assertEquals(actualTitle,expectedTitle);
        log.info("Login Page Title is Matching");
    }

}
