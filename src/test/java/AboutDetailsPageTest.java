import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.AboutDetailsPage;
import pages.LoginPage;



import java.time.Duration;
import java.util.List;

public class AboutDetailsPageTest {

    private WebDriver driver;
    final String correctUsername="binay.poudel@webpoint.io";
    final String correctPassword="Webpoint@2024";
    LoginPage loginPage;
    private AboutDetailsPage aboutDetailsPage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://cms.dev.oneaccord.cc/login");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        aboutDetailsPage=new AboutDetailsPage(driver);
        loginPage.logins(correctUsername,correctPassword);
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(aboutDetailsPage.websiteContentButtonLocator)).perform();
        driver.findElement(aboutDetailsPage.pageButtonLocator).click();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyPagesButton() throws InterruptedException {

        String pageText=driver.findElement(aboutDetailsPage.pageTextLocator).getText();
        Assertions.assertEquals("Pages",pageText);
    }

    @Test
    public void verifyAboutPageEditButton() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(3000);
        String elements = driver.findElement(aboutDetailsPage.commonTextLocator).getText();
        System.out.println(elements);
        Assertions.assertEquals("About Page",elements);
    }

    @Test
    public void verifySubMenuCount() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(3000);
        List<WebElement> elements= driver.findElements(aboutDetailsPage.subMenuListTextLocator);
        int count=elements.size();
        System.out.println(count);
        Assertions.assertEquals(10,count);
    }
    @Test
    public void verifyGeneralTabButton() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.generalTabButtonLocator).click();
        String text=driver.findElement(aboutDetailsPage.generalTabTextLocator).getText();
        System.out.println(text);
        Assertions.assertEquals("General",text);
    }
    @Test
    public void verifyAboutUsTextboxSaveSection() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.aboutUsDropdownLocator).click();
        driver.findElement(aboutDetailsPage.textBoxEditLocator).clear();
        driver.findElement(aboutDetailsPage.textBoxEditLocator).sendKeys("Title is Required");
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.saveButtonLocator).click();
        String successText=driver.findElement(aboutDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifyAboutUsTextboxPublishSection() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.aboutUsDropdownLocator).click();
        driver.findElement(aboutDetailsPage.textBoxEditLocator).clear();
        driver.findElement(aboutDetailsPage.textBoxEditLocator).sendKeys("Title is Required");
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.publishButtonLocator).click();
        String successText=driver.findElement(aboutDetailsPage.successfullyPublishedTextLocator).getText();
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    }
    @Test
    public void verifyChurchMapGoToSettingButton() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.churchMapDropdownLocator).click();

        driver.findElement(aboutDetailsPage.churchMapGotoSettingLocator).click();
        String successText=driver.findElement(aboutDetailsPage.locationTextLocator).getText();
        Assertions.assertEquals("Location",successText);
    }

    @Test
    public void verifyFindUsGoToSettingButton() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.findUsDropdownLocator).click();
        driver.findElement(aboutDetailsPage.findUsGotoSettingLocator).click();
        String successText=driver.findElement(aboutDetailsPage.contactInfoTextLocator).getText();
        Assertions.assertEquals("Contact Info",successText);
    }
    @Test
    public void worshipTimeGoToSettingButton() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.worshipTimeDropdownLocator).click();
        driver.findElement(aboutDetailsPage.worshipTimeGotoSettingLocator).click();
        String successText=driver.findElement(aboutDetailsPage.worshipTimeTextLocator).getText();
        Assertions.assertEquals("Worship Time",successText);
    }
    @Test
    public void verifyWorshipTimeVisibleSaveButton() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.worshipTimeDropdownLocator).click();

        driver.findElement(aboutDetailsPage.worshipTimeToggleButtonLocator).click();
        driver.findElement(aboutDetailsPage.saveButtonLocator).click();
        String successText=driver.findElement(aboutDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifyWorshipTimeVisiblePublishSection() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.worshipTimeDropdownLocator).click();

        driver.findElement(aboutDetailsPage.worshipTimeToggleButtonLocator).click();
        driver.findElement(aboutDetailsPage.publishButtonLocator).click();
        String successText=driver.findElement(aboutDetailsPage.successfullyPublishedTextLocator).getText();
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    }
    @Test
    public void verifyPrayerMeetingGoToSettingButton() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.prayerMeetingDropdownLocator).click();
        driver.findElement(aboutDetailsPage.prayerMeetingGoToPrayerLocator).click();
        String successText=driver.findElement(aboutDetailsPage.prayerMeetingTextLocator).getText();
        Assertions.assertEquals("Prayer Meeting Time",successText);
    }
    @Test
    public void verifyPrayerMeetingVisibleSaveButton() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.prayerMeetingDropdownLocator).click();

        driver.findElement(aboutDetailsPage.prayerMeetingToggleButtonLocator).click();
        driver.findElement(aboutDetailsPage.saveButtonLocator).click();
        String successText=driver.findElement(aboutDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifyPrayerMeetingVisiblePublishSection() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.prayerMeetingDropdownLocator).click();

        driver.findElement(aboutDetailsPage.prayerMeetingToggleButtonLocator).click();
        driver.findElement(aboutDetailsPage.publishButtonLocator).click();
        String successText=driver.findElement(aboutDetailsPage.successfullyPublishedTextLocator).getText();
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    }
    @Test
    public void verifySabbathSchoolGoToSettingButton() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.sabbathSchoolDropdownLocator).click();
        driver.findElement(aboutDetailsPage.sabbathSchoolGoToSabbathLocator).click();
        String successText=driver.findElement(aboutDetailsPage.sabbathSchoolTextLocator).getText();
        Assertions.assertEquals("Sabbath School Time",successText);
    }
    @Test
    public void verifySabbathSchoolVisibleSaveButton() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.sabbathSchoolDropdownLocator).click();

        driver.findElement(aboutDetailsPage.sabbathSchoolToggleButtonLocator).click();
        driver.findElement(aboutDetailsPage.saveButtonLocator).click();
        String successText=driver.findElement(aboutDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifySabbathSchoolVisiblePublishSection() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.sabbathSchoolDropdownLocator).click();

        driver.findElement(aboutDetailsPage.sabbathSchoolToggleButtonLocator).click();
        driver.findElement(aboutDetailsPage.publishButtonLocator).click();
        String successText=driver.findElement(aboutDetailsPage.successfullyPublishedTextLocator).getText();
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    }
   @Test
    public void verifyContactFormSupportTeamButton() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.contactFormDropdownLocator).click();
        driver.findElement(aboutDetailsPage.contactFormSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(aboutDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
    @Test
    public void verifyAdventistBannerSupportTeamButton() throws InterruptedException {
        driver.findElement(aboutDetailsPage.aboutPageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(aboutDetailsPage.adventistBannerDropdownLocator).click();
        driver.findElement(aboutDetailsPage.adventistTeamSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(aboutDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
}