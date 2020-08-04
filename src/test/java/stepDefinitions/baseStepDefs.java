package stepDefinitions;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import pageObjects.*;
import pageObjects.old.*;
import utils.BrowserFactory;
import utils.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class baseStepDefs {


    public loginPage loginpage;
    public homePage homepage;
    public navbarPage navbarpage;
    public pageObjects.faqpage faqpage;
    public bookAppointment bookappointment;
    public medicalHistoryPage medicalHistoryPage;
    public membershipsPage membershipspage;
    public AccountdetailsPage accountdetailspage;
    public invoicePage invoicepage;
    public static Properties prop;
    public utils.utilities utils;
    public static WebDriver driver;
    public AppointmentDetails appointmentdetails;
    public ExistingAppointments existingappointments;
    public membershipEnrollment membershipenrollment;
    public allNotificationsPage allnotificationspage;
    public addAppointmentPage addAppointmentPage;
    public appointmentListPage appointmentListPage;


    public baseStepDefs() {
        loginpage = new loginPage();
        homepage = new homePage();
        navbarpage = new navbarPage();
        faqpage = new faqpage();
        bookappointment = new bookAppointment();
        medicalHistoryPage = new medicalHistoryPage();
        membershipspage = new membershipsPage();
        accountdetailspage = new AccountdetailsPage();
        invoicepage = new invoicePage();
        prop = utilities.loadProperties();
        utils = new utilities();
        driver = BrowserFactory.getDriver();
        existingappointments = new ExistingAppointments();
        appointmentdetails = new AppointmentDetails();
        membershipenrollment = new membershipEnrollment();
        allnotificationspage = new allNotificationsPage();
        addAppointmentPage = new addAppointmentPage();
        appointmentListPage = new appointmentListPage();



    }

    public  void takeScreenShot()
    {
        Date d=new Date();
        String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(scrFile, new File(System.getProperty("user.dir")+"/screenshots/"+screenshotFile));
        }
        catch (IOException e) {

            e.printStackTrace();
        }
       // test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir")+"/screenshots/"+screenshotFile));

    }

}