package pageObjects;

import cucumber.api.Format;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.basePage;

public class addAppointmentPage extends basePage {
    public addAppointmentPage() {
        super();
    }

    @FindBy(xpath = "//header[text()='Add Appointment']")
    public WebElement headerForAddAppointmentPage;
    //@FindBy(className = "fa fa-calendar") public WebElement calenderIcon;
    @FindBy(css = "input#Appointment_date")
    public WebElement appointmentDateTextBox;
    @FindBy(xpath = "//tr//td[text()='20']")
    public WebElement dayOfAppointment;
    @FindBy(xpath ="//td[text()='22']" )
    public WebElement saturDayAppointmentDate;
    @FindBy(xpath = "//td[text()='23']")
    public WebElement sunDayAppointmentDate;
    @FindBy(id = "site")
    public WebElement siteDropDown;
    @FindBy(id = "Appointmenttime")
    public WebElement timeDropDown;
    @FindBy(css = "select[class='form-control input-height select2 select2-hidden-accessible']")
    public WebElement patientDropDown;
    @FindBy(id = "appointment_type")
    public WebElement appointmentTypeDrowpDown;
    @FindBy(name = "clinician_name")
    public WebElement doctorDropDown;
    @FindBy(className = "form-control-textarea")
    public WebElement commentsTextBox;
    @FindBy(name = "comment") public WebElement commentTextBox;
    @FindBy(className = "btn-info")
    public WebElement submitButton;
    @FindBy(xpath = "//strong[contains(text(),'In Hours bookings are available from 9:00 AM to 5:30 PM.')]")
    public WebElement msgBookOutOfHours;
    @FindBy(xpath = "//strong[contains(text(),'On Saturdays and Sundays please select a Out of Hours.')]")
    public WebElement weekendValidationMsg;


    public void isAdminInAddAppointmentPage() {
        headerForAddAppointmentPage.isDisplayed();
    }

    public void enterAppointmentDate() {
        //calenderIcon.click();
        appointmentDateTextBox.click();
        dayOfAppointment.click();
        //appointmentDateTextBox.sendKeys(date);
    }
    public void enterSaturdayAsAppointmentDate()
    {
        appointmentDateTextBox.click();
        saturDayAppointmentDate.click();
    }
    public void enterSundayAsAppointmentDate()
    {
        appointmentDateTextBox.click();
        sunDayAppointmentDate.click();
    }

    /*
    public void choosePreferredSiteAs(String site) {
        try {
            utils.waitToLoad();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//li[@ng-click=\"siteDetails(site,'bookAppointment-siteDetails')\"]"));
        utils.clickOnWebElement(driver, element);
        selectSiteBtn.click();
    }*/
    public void enterAppointmentDetails(String site, String time, String patient, String AppointmentType, String DoctorName, String comments) {
        Select Site = new Select(siteDropDown);
        Site.selectByVisibleText(site);

        Select Time = new Select(timeDropDown);
        Time.selectByVisibleText(time);

        Select Patient = new Select(patientDropDown);
        Patient.selectByVisibleText(patient);

        Select ap = new Select(appointmentTypeDrowpDown);
        ap.selectByVisibleText(AppointmentType);

        Select doc = new Select(doctorDropDown);
        doc.selectByVisibleText(DoctorName);

        commentsTextBox.sendKeys(comments);

    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void isAdminGotOutOfHoursValidationMsg()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(msgBookOutOfHours, "In Hours bookings are available from 9:00 AM to 5:30 PM. Outside of these times please select a Out of Hours."));

        msgBookOutOfHours.isDisplayed();
    }

    public void isAdminGotWeedEndValidationMsg()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(weekendValidationMsg, "On Saturdays and Sundays please select a Out of Hours."));

        weekendValidationMsg.isDisplayed();
    }
}



