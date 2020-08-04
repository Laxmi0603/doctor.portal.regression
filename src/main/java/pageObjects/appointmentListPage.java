package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.basePage;

public class appointmentListPage extends basePage
{
    public appointmentListPage()
    {
        super();
    }
    @FindBy(xpath = "//strong[contains(text(),'Appointment added successfully')]") public WebElement successMsg;
    @FindBy(xpath = "(//select//option[@value='2'])[1]") public WebElement confirmedStatus;
    @FindBy(xpath = "(//select//option[@value='0'])[1]") public WebElement pendingStatus;

    public void isSuccessMsgDisplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(successMsg, "Appointment added successfully"));
        successMsg.isDisplayed();
    }
    public void isStatusConfirmed()
    {
        confirmedStatus.isSelected();
    }
    public String getConfirmedStatus()
    {
       return confirmedStatus.getText();
    }
    public String getPendingStatus()
    {
        return pendingStatus.getText();
    }
}
