import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.PlanVisitDetailsPage;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class PlanVisitDetailsPageTest {

    private WebDriver driver;
    final String correctUsername="binay.poudel@webpoint.io";
    final String correctPassword="Webpoint@2024";
    LoginPage loginPage;
    private PlanVisitDetailsPage planVisitDetailsPage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://cms.dev.oneaccord.cc/login");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        planVisitDetailsPage=new PlanVisitDetailsPage(driver);
        loginPage.logins(correctUsername,correctPassword);
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(planVisitDetailsPage.websiteContentButtonLocator)).perform();
        driver.findElement(planVisitDetailsPage.pageButtonLocator).click();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyPagesButton() throws InterruptedException {

        String pageText=driver.findElement(planVisitDetailsPage.pageTextLocator).getText();
        Assertions.assertEquals("Pages",pageText);
    }

    @Test
    public void verifyPlanVisitEditButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(3000);
        String elements = driver.findElement(planVisitDetailsPage.commonTextLocator).getText();
        System.out.println(elements);
        Assertions.assertEquals("Plan Your Visit",elements);
    }

    @Test
    public void verifySubMenuCount() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(3000);
        List<WebElement> elements= driver.findElements(planVisitDetailsPage.subMenuListTextLocator);
        int count=elements.size();
        System.out.println(count);
        Assertions.assertEquals(7,count);
    }
    @Test
    public void verifyHeaderBannerSupportTeamButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.headerBannerDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.headerBannerSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String text=driver.findElement(planVisitDetailsPage.supportTeamFormTextLocator).getText();
        System.out.println(text);
        Assertions.assertEquals("Support Team Form",text);
    }

    @Test
    public void verifyFirstVisitSupportTeamButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.firstVisitDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.firstVisitSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(planVisitDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
    @Test
    public void verifySabbathSchoolSupportTeamButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.sabbathSchoolDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.sabbathSchoolSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(planVisitDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
    @Test
    public void verifyWorshipServiceSupportTeamButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.worshipServiceDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.worshipServiceSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(planVisitDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
    @Test
    public void verifyAdditionalProgramsFellowshipMealSaveButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.additionalProgramDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.additionalProgramFellowshipMealToggleLocator).click();
        driver.findElement(planVisitDetailsPage.saveButtonLocator).click();

        String successText=driver.findElement(planVisitDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifyAdditionalProgramsFellowshipMealPublishButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.additionalProgramDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.additionalProgramFellowshipMealToggleLocator).click();
        driver.findElement(planVisitDetailsPage.publishButtonLocator).click();

        String successText=driver.findElement(planVisitDetailsPage.successfullyPublishedTextLocator).getText();
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    }
    @Test
    public void verifyAdditionalProgramsVespersSaveButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.additionalProgramDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.additionalProgramVespersToggleLocator).click();
        driver.findElement(planVisitDetailsPage.saveButtonLocator).click();

        String successText=driver.findElement(planVisitDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifyAdditionalProgramsVespersPublishButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.additionalProgramDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.additionalProgramVespersToggleLocator).click();
        driver.findElement(planVisitDetailsPage.publishButtonLocator).click();

        String successText=driver.findElement(planVisitDetailsPage.successfullyPublishedTextLocator).getText();
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    }
    @Test
    public void verifyAdditionalProgramsPrayerMeetingSaveButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.additionalProgramDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.additionalProgramPrayerMeetingToggleLocator).click();
        driver.findElement(planVisitDetailsPage.saveButtonLocator).click();

        String successText=driver.findElement(planVisitDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifyAdditionalProgramsPrayerMeetingPublishButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.additionalProgramDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.additionalProgramPrayerMeetingToggleLocator).click();
        driver.findElement(planVisitDetailsPage.publishButtonLocator).click();

        String successText=driver.findElement(planVisitDetailsPage.successfullyPublishedTextLocator).getText();
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    }
    @Test
    public void verifyChurchMapSupportTeamButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.churchMapDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.churchMapSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(planVisitDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
    @Test
    public void verifyContactFormSupportTeamButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.contactFormDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.contactFormSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(planVisitDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
    @Test
    public void verifySupportTeamFormWithValidSubjectAndMessageButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.contactFormDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.contactFormSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.supportTeamFormSubjectTextLocator).sendKeys("Support Subject");
        driver.findElement(planVisitDetailsPage.supportTeamFormMessageTextareaLocator).sendKeys("Support Message");
        driver.findElement(planVisitDetailsPage.supportTeamFormSubmitButtonLocator).click();
        String successText=driver.findElement(planVisitDetailsPage.successMessageLocator).getText();

        Assertions.assertEquals("Sent message to support team",successText);
    }
    @Test
    public void verifySupportTeamFormWithEmptySubjectAndMessageButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.contactFormDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.contactFormSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.supportTeamFormSubmitButtonLocator).click();
        String successText=driver.findElement(planVisitDetailsPage.supportFormSubjectIsRequiredLocator).getText();

        Assertions.assertEquals("Subject is required.",successText);
    }
    @Test
    public void verifySupportTeamFormWithValidSubjectAndEmptyMessageButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.contactFormDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.contactFormSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.supportTeamFormSubjectTextLocator).sendKeys("Support Subject");
        driver.findElement(planVisitDetailsPage.supportTeamFormSubmitButtonLocator).click();
        String successText=driver.findElement(planVisitDetailsPage.supportFormMessageIsRequiredLocator).getText();

        Assertions.assertEquals("Message is required.",successText);
    }
    @Test
    public void verifySupportTeamFormCancelButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.contactFormDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.contactFormSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.supportTeamFormSubjectTextLocator).sendKeys("Support Subject");
        driver.findElement(planVisitDetailsPage.supportTeamFormMessageTextareaLocator).sendKeys("Support Message");
        driver.findElement(planVisitDetailsPage.supportTeamFormCancelButtonLocator).click();
        Thread.sleep(2000);
        if (planVisitDetailsPage.isCancelOrCloseSuccessful()) {
            Assertions.assertFalse(planVisitDetailsPage.isCancelOrCloseSuccessful());
        } else {
            Assertions.assertFalse(planVisitDetailsPage.isCancelOrCloseSuccessful());
        }


    }
    @Test
    public void verifySupportTeamFormCloseButton() throws InterruptedException {
        driver.findElement(planVisitDetailsPage.planVisitEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.contactFormDropdownLocator).click();
        driver.findElement(planVisitDetailsPage.contactFormSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        driver.findElement(planVisitDetailsPage.supportTeamFormSubjectTextLocator).sendKeys("Support Subject");
        driver.findElement(planVisitDetailsPage.supportTeamFormMessageTextareaLocator).sendKeys("Support Message");

        driver.findElement(planVisitDetailsPage.supportTeamFormCloseButtonLocator).click();
        Thread.sleep(2000);
        if (planVisitDetailsPage.isCancelOrCloseSuccessful()) {
            Assertions.assertFalse(planVisitDetailsPage.isCancelOrCloseSuccessful());
        } else {
            Assertions.assertFalse(planVisitDetailsPage.isCancelOrCloseSuccessful());
        }
    }
}
