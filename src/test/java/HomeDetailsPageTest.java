import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.HomeDetailsPage;
import pages.LoginPage;



import java.time.Duration;
import java.util.List;

public class HomeDetailsPageTest {

    private WebDriver driver;
    final String correctUsername="binay.poudel@webpoint.io";
    final String correctPassword="Webpoint@2024";
    LoginPage loginPage;
    private HomeDetailsPage homeDetailsPage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://cms.dev.oneaccord.cc/login");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        homeDetailsPage=new HomeDetailsPage(driver);
        loginPage.logins(correctUsername,correctPassword);
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(homeDetailsPage.websiteContentButtonLocator)).perform();
//        driver.findElement(homeDetailsPage.websiteContentButtonLocator).click();
        driver.findElement(homeDetailsPage.pageButtonLocator).click();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyPagesButton() throws InterruptedException {

        String pageText=driver.findElement(homeDetailsPage.pageTextLocator).getText();
        Assertions.assertEquals("Pages",pageText);
    }

    @Test
    public void verifyHomePageEditButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        Thread.sleep(3000);
        String elements = driver.findElement(homeDetailsPage.commonTextLocator).getText();
        System.out.println(elements);
        Assertions.assertEquals("Home Page",elements);
    }
    @Test
    public void verifySubMenuCount() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        Thread.sleep(3000);
        List<WebElement> elements= driver.findElements(homeDetailsPage.subMenuListTextLocator);
        int count=elements.size();
        System.out.println(count);
        Assertions.assertEquals(9,count);
    }
    @Test
    public void verifyGeneralTabButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(homeDetailsPage.generalTabButtonLocator).click();
        String text=driver.findElement(homeDetailsPage.generalTabTextLocator).getText();
        System.out.println(text);
        Assertions.assertEquals("General",text);
    }
    @Test
    public void verifyHeroBannerTitleSaveSection() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(homeDetailsPage.heroBannerButtonLocator).click();
        driver.findElement(homeDetailsPage.heroBannerTitleLocator).clear();
        driver.findElement(homeDetailsPage.heroBannerTitleLocator).sendKeys("Faith is the Answer");
        Thread.sleep(2000);
        driver.findElement(homeDetailsPage.saveButtonLocator).click();
        String successText=driver.findElement(homeDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifyHeroBannerTitlePublishSection() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.heroBannerButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.heroBannerTitleLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(homeDetailsPage.heroBannerTitleLocator).sendKeys("Check Truth is the Answer");
        Thread.sleep(2000);
        driver.findElement(homeDetailsPage.publishButtonLocator).click();
        String successText=driver.findElement(homeDetailsPage.successfullyPublishedTextLocator).getText();
        System.out.println(successText);
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    }
    @Test
    public void verifyHeroBannerEmptyTitlePublishSection() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.heroBannerButtonLocator).click();
        Thread.sleep(2000);
        driver.findElement(homeDetailsPage.heroBannerTitleLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.publishButtonLocator).click();
        String requiredText=driver.findElement(homeDetailsPage.titleRequiredTextLocator).getText();
        Assertions.assertEquals("Title is required.",requiredText);
    }
    @Test
    public void verifyHeroBannerServiceTimePublishButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.heroBannerButtonLocator).click();
        Thread.sleep(2000);
        driver.findElement(homeDetailsPage.heroBannerServiceTimeLocator).click();
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.publishButtonLocator).click();
        String successText=driver.findElement(homeDetailsPage.successfullyPublishedTextLocator).getText();
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    }
    @Test
    public void verifyHeroBannerServiceTimeSaveButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.heroBannerButtonLocator).click();
        Thread.sleep(2000);
        driver.findElement(homeDetailsPage.heroBannerServiceTimeLocator).click();
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.saveButtonLocator).click();
        String successText=driver.findElement(homeDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifyHeroBannerGoToWorshipSetting() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.heroBannerButtonLocator).click();
        Thread.sleep(2000);
        driver.findElement(homeDetailsPage.heroBannerServiceTimeLocator).click();
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.goToWorshipSettingLocator).click();
        String successText=driver.findElement(homeDetailsPage.worshipTimeTextLocator).getText();
        Assertions.assertEquals("Worship Time",successText);
    }
    @Test
    public void verifyEventsToggleSaveButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
//        driver.findElement(homeDetailsPage.heroBannerButtonLocator).click();
//        Thread.sleep(2000);
        driver.findElement(homeDetailsPage.eventDropdownLocator).click();

        driver.findElement(homeDetailsPage.eventsToggleButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.saveButtonLocator).click();
        String successText=driver.findElement(homeDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifyEventsTogglePublishButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
//        driver.findElement(homeDetailsPage.heroBannerButtonLocator).click();
//        Thread.sleep(2000);
        driver.findElement(homeDetailsPage.eventDropdownLocator).click();
        driver.findElement(homeDetailsPage.eventsToggleButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.publishButtonLocator).click();
        String successText=driver.findElement(homeDetailsPage.successfullyPublishedTextLocator).getText();
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    }

    @Test
    public void verifyEventsGoToEventManagementButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
//        driver.findElement(homeDetailsPage.heroBannerButtonLocator).click();
//        Thread.sleep(2000);
        driver.findElement(homeDetailsPage.eventDropdownLocator).click();
        driver.findElement(homeDetailsPage.goToEventManagementLocator).click();
        String successText=driver.findElement(homeDetailsPage.eventPageTextLocator).getText();
        Assertions.assertEquals("Events",successText);
    }
    @Test
    public void verifySabbathSchoolToggleSaveButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.sabbathDropdownLocator).click();

        driver.findElement(homeDetailsPage.sabbathSchoolToggleButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.saveButtonLocator).click();
        String successText=driver.findElement(homeDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifySabbathSchoolTogglePublishButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.sabbathDropdownLocator).click();
        driver.findElement(homeDetailsPage.sabbathSchoolToggleButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.publishButtonLocator).click();
        String successText=driver.findElement(homeDetailsPage.successfullyPublishedTextLocator).getText();
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    }
    @Test
    public void verifySabbathGoToSabbathSchoolButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.sabbathDropdownLocator).click();
        driver.findElement(homeDetailsPage.goToSabbathPageLocator).click();
        String successText=driver.findElement(homeDetailsPage.sabbathClassTextLocator).getText();
        Assertions.assertEquals("Sabbath Classes",successText);
    }
    @Test
    public void verifyLearningCenterToggleSaveButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.learningCenterDropdownLocator).click();

        driver.findElement(homeDetailsPage.learningCenterToggleButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.saveButtonLocator).click();
        String successText=driver.findElement(homeDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifyLearningCenterTogglePublishButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.learningCenterDropdownLocator).click();
        driver.findElement(homeDetailsPage.learningCenterToggleButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.publishButtonLocator).click();
        String successText=driver.findElement(homeDetailsPage.successfullyPublishedTextLocator).getText();
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    } @Test
    public void verifyConnectWithUsToggleSaveButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.connectWithUsDropdownLocator).click();

        driver.findElement(homeDetailsPage.connectWithUsToggleButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.saveButtonLocator).click();
        String successText=driver.findElement(homeDetailsPage.draftSavedSuccessfullyLocator).getText();
        Assertions.assertEquals("Draft saved successfully.",successText);
    }
    @Test
    public void verifyConnectWithUsTogglePublishButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.connectWithUsDropdownLocator).click();
        driver.findElement(homeDetailsPage.connectWithUsToggleButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(homeDetailsPage.publishButtonLocator).click();
        String successText=driver.findElement(homeDetailsPage.successfullyPublishedTextLocator).getText();
        Assertions.assertEquals("You have successfully published your changes to the live.",successText);
    }
    @Test
    public void verifyConnectGoToGeneralConfigurationButton() throws InterruptedException {
        driver.findElement(homeDetailsPage.homePageEditLocator).click();
        driver.findElement(homeDetailsPage.connectWithUsDropdownLocator).click();
        driver.findElement(homeDetailsPage.goToGeneralConfigurationLocator).click();
        String successText=driver.findElement(homeDetailsPage.generalConfigurationTextLocator).getText();
        Assertions.assertEquals("General Configuration",successText);
    }
}