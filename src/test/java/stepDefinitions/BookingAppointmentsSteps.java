package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static runner.RunCukeTestng.afterClass;
import static utils.utilities.waitForPageLoad;

public class BookingAppointmentsSteps extends baseStepDefs
{
    @When("^Admin enter username \"([^\"]*)\"  and enter password \"([^\"]*)\"$")
    public void adminEnterUsernameAndEnterPassword(String username, String password) throws Throwable
    {
        loginpage.loginToDoctorPortal(username,password);
    }
    @Then("^Admin should be navigate to Home page \"([^\"]*)\"$")
    public void adminShouldBeNavigateToHomePage(String title) throws Throwable
    {
        Assert.assertEquals(title,homepage.getTheTitleOfThePage());
    }
    @When("^Admin select Appointments from left side panel and select Book Appointment$")
    public void adminSelectAppointmentsFromLeftSidePanelAndSelectBookAppointment()
    {
        homepage.bookNewAppointment();
    }
    @Then("^Admin should be navigate to Book Appointment screen$")
    public void adminShouldBeNavigateToBookAppointmentScreen()
    {
        addAppointmentPage.isAdminInAddAppointmentPage();
    }
    @When("^Admin select date of Appointment$")
    public void adminSelectDateOfAppointment()
    {
        addAppointmentPage.enterAppointmentDate();
    }
    @And("^Admin select \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
    public void adminSelect(String site, String time, String patient, String AppointmentType, String DoctorName, String comments) throws Throwable {
        addAppointmentPage.enterAppointmentDetails(site,time,patient,AppointmentType,DoctorName,comments);
    }

    @And("^Admin click submit button$")
    public void adminClickSubmitButton()
    {
        addAppointmentPage.clickSubmitButton();
    }

    @Then("^Admin should get validation message$")
    public void adminShouldGetValidationMessage()
    {
        appointmentListPage.isSuccessMsgDisplayed();
    }

    @Then("^Admin should get validation message to book for Out of Hours$")
    public void adminShouldGetValidationMessageToBookForOutOfHours()
    {
        addAppointmentPage.isAdminGotOutOfHoursValidationMsg();
        takeScreenShot();
        homepage.logout();
    }

    @And("^Booking should be updated in All Appointment screen with Confirmed status$")
    public void bookingShouldBeUpdatedInAllAppointmentScreenWithConfirmedStatus()
    {
        appointmentListPage.isStatusConfirmed();
        takeScreenShot();
        homepage.logout();
    }

    @And("^Booking should be updated in All Appointment screen with Confirmed \"([^\"]*)\"$")
    public void bookingShouldBeUpdatedInAllAppointmentScreenWithConfirmed(String status) throws Throwable
    {
        Assert.assertEquals(appointmentListPage.getConfirmedStatus(), status);
        takeScreenShot();
        homepage.logout();
    }


    @And("^Appointment booking should be updated in All Appointment screen with Pending \"([^\"]*)\"$")
    public void appointmentBookingShouldBeUpdatedInAllAppointmentScreenWithPending(String status) throws Throwable {
        Assert.assertEquals(appointmentListPage.getPendingStatus(), status);
        takeScreenShot();
        homepage.logout();
    }

    @When("^Admin select Saturday as date of Appointment$")
    public void adminSelectSaturdayAsDateOfAppointment()
    {
        addAppointmentPage.enterSaturdayAsAppointmentDate();
    }

    @When("^Admin select Sunday as date of Appointment$")
    public void adminSelectSundayAsDateOfAppointment()
    {
        addAppointmentPage.enterSundayAsAppointmentDate();
    }

    @Then("^Admin should get validation message for booking weekend Appointment \"([^\"]*)\"$")
    public void adminShouldGetValidationMessageForBookingWeekendAppointment(String weekEndValMsg) throws Throwable
    {
        addAppointmentPage.isAdminGotWeedEndValidationMsg();
        takeScreenShot();
        String val1 = addAppointmentPage.weekendValidationMsg.getText();
        Assert.assertEquals(val1,weekEndValMsg);
        homepage.logout();

    }


}
