package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PlanVisitDetailsPage {
    final WebDriver driver;
    public By websiteContentButtonLocator = By.xpath("//body/div[1]/aside[1]/div[1]/button[1]");
    public By pageButtonLocator = By.xpath("//a[contains(text(),'Pages')]");
    public By pageTextLocator = By.xpath("//h3[contains(text(),'Pages')]");
    public By planVisitEditLocator = By.xpath("//tbody/tr[3]/td[5]/button[1]");
    public By commonTextLocator = By.xpath("//header/div[1]/div[3]/span[1]");
    public By subMenuListTextLocator = By.xpath(" //li[@class='px-1.5 py-1 flex gap-2 items-center rounded-md cursor-pointer hover:bg-accent-50']");

    public By headerBannerDropdownLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/section[1]/button[1]");
    public By firstVisitDropdownLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/section[1]/button[1]");
    public By sabbathSchoolDropdownLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/section[1]/button[1]");
    public By worshipServiceDropdownLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/section[1]/button[1]");
    public By additionalProgramDropdownLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[5]/section[1]/button[1]");
    public By additionalProgramFellowshipMealToggleLocator = By.xpath("//button[@id='fellowship_meal_id']");
    public By additionalProgramVespersToggleLocator = By.xpath("//button[@id='vespers_id']");
    public By additionalProgramPrayerMeetingToggleLocator = By.xpath("//button[@id='prayer_meetings_id']");


    public By churchMapDropdownLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/section[1]/button[1]");
    public By contactFormDropdownLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[7]/section[1]/button[1]");
    public By saveButtonLocator = By.xpath("//button[contains(text(),'Save')]");
    public By publishButtonLocator = By.xpath("//button[contains(text(),'Publish')]");
    public By successfullyPublishedTextLocator = By.xpath("//div[contains(text(),'You have successfully published your changes to th')]");
    public By draftSavedSuccessfullyLocator = By.xpath(" //div[contains(text(),'Draft saved successfully.')]");


    public By headerBannerSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");
    public By firstVisitSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");
    public By sabbathSchoolSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");
    public By worshipServiceSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");
    public By churchMapSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");
    public By contactFormSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[7]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");


    public By supportTeamFormTextLocator = By.xpath("  //h4[contains(text(),'Support Team Form')]");
    public By supportTeamFormSubjectTextLocator = By.xpath("//body[1]/div[4]/div[2]/form[1]/div[1]/div[1]/div[1]/input[1]");
    public By supportTeamFormMessageTextareaLocator = By.xpath("//body[1]/div[4]/div[2]/form[1]/div[2]/div[1]/textarea[1]");
    public By supportTeamFormCancelButtonLocator = By.xpath(" //button[contains(text(),'Cancel')]");
    public By supportTeamFormCloseButtonLocator = By.xpath("  //body[1]/div[4]/button[1]");
    public By supportTeamFormSubmitButtonLocator = By.xpath("  //button[contains(text(),'Submit')]");
    public By successMessageLocator = By.xpath("//div[contains(text(),'Sent message to support team')]");
    public By supportFormSubjectIsRequiredLocator = By.xpath("//div[contains(text(),'Subject is required.')]");
    public By supportFormMessageIsRequiredLocator = By.xpath("//span[contains(text(),'Message is required.')]");
















    public PlanVisitDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isCancelOrCloseSuccessful() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(supportTeamFormTextLocator));
            WebElement res = driver.findElement(supportTeamFormTextLocator);
            String str = res.getText();
            return str.equals("Support Team Form");
        }
        catch (Exception e){
            return false;

        }
    }



}