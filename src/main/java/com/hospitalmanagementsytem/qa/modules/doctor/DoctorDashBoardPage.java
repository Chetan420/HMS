package com.hospitalmanagementsytem.qa.modules.doctor;

import com.hospitalmanagementsytem.qa.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashBoardPage extends TestBase{
    @FindBy(partialLinkText = "Log Out")
    @CacheLookup
    private WebElement logOutButton;
    @FindBy(xpath = "//a[@data-toggle='dropdown' and @data-hover='dropdown' ]")
    private WebElement viewMessage;
    @FindBy(xpath = "//img[@style='height:44px;']")
    private WebElement doctorLogo;
    @FindBy(xpath = "//a[@class='sidebar-collapse-icon with-animation']//parent::a")
    @CacheLookup
    private WebElement hamBurgerMenu;
    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement dashboardLink;
    @FindBy(xpath = "//span[text()='Appointment']")
    @CacheLookup
    private WebElement appointmentLink;
    @FindBy(xpath = "//span[text()='Appointment List']")
    private WebElement appointmentListLink;
    @FindBy(xpath = "//span[text()='Requested Appointments']")
    private WebElement requestedAppointmentsLink;
    @FindBy(xpath = "//span[text()='Prescription']")
    private WebElement prscriptionLink;
    @FindBy(xpath = "//span[text()='Patient']")
    private WebElement patientLink;
    @FindBy(xpath = "//span[text()='Bed Allotment']")
    private WebElement bedAllotmentLink;
    @FindBy(xpath = "//span[text()='Blood Bank']")
    private WebElement bloodBlankLink;
    @FindBy(xpath = "//span[text()='Report']")
    private WebElement reportLink;
    @FindBy(xpath = "//span[text()='Message']")
    private WebElement messageLink;
    @FindBy(xpath = "//span[text()='Profile']")
    private WebElement profileLink;

    public DoctorDashBoardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String Title(){
        return driver.getTitle();
    }
    public DoctorLoginPage logout(){
        logOutButton.click();
        return new DoctorLoginPage(driver);
    }
    public void alertMessage(){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public String pageTitle(){
        return driver.getTitle();
    }

    public DoctorDashBoardPage doctorDashBoard(){
        dashboardLink.click();
        return new DoctorDashBoardPage(driver);
    }
    public AppointmentList appointmentListLink(){
        appointmentLink.click();
        appointmentListLink.click();
        return new AppointmentList(driver);
    }
    public RequestedAppointments requestedAppointments(){
        requestedAppointmentsLink.click();
        return new RequestedAppointments(driver);
    }
    public PrescriptionPage prescriptionPage(){
        prscriptionLink.click();
        return new PrescriptionPage(driver);
    }
    public PatientPage patientPage(){
        patientLink.click();
        return new PatientPage(driver);
    }
    public BedAllotmentPage bedAllotmentPage(){
        bedAllotmentLink.click();
        return new BedAllotmentPage(driver);
    }
    public BloodBankPage bloodBankPage(){
        bloodBlankLink.click();
        return new BloodBankPage(driver);
    }
    public ReportPage reportPage(){
        reportLink.click();
        return new ReportPage(driver);
    }
    public MessagePage messagePage(){
        messageLink.click();
        return new MessagePage(driver);
    }
    public ProfilePage profilePage(){
        profileLink.click();
        return new ProfilePage(driver);
    }
    public DoctorLoginPage logOut(){
        logOutButton.click();
        return new DoctorLoginPage(driver);
    }
}
