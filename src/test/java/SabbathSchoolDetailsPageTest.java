import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.SabbathSchoolDetailsPage;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SabbathSchoolDetailsPageTest {

    private WebDriver driver;
    final String correctUsername="binay.poudel@webpoint.io";
    final String correctPassword="Webpoint@2024";
    LoginPage loginPage;
    private SabbathSchoolDetailsPage sabbathSchoolDetailsPage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://cms.dev.oneaccord.cc/login");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        sabbathSchoolDetailsPage=new SabbathSchoolDetailsPage(driver);
        loginPage.logins(correctUsername,correctPassword);
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(sabbathSchoolDetailsPage.websiteContentButtonLocator)).perform();
        driver.findElement(sabbathSchoolDetailsPage.pageButtonLocator).click();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyPagesButton() throws InterruptedException {

        String pageText=driver.findElement(sabbathSchoolDetailsPage.pageTextLocator).getText();
        Assertions.assertEquals("Pages",pageText);
    }

    @Test
    public void verifySabbathSchoolEditButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(3000);
        String elements = driver.findElement(sabbathSchoolDetailsPage.commonTextLocator).getText();
        System.out.println(elements);
        Assertions.assertEquals("Sabbath School",elements);
    }

    @Test
    public void verifySubMenuCount() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(3000);
        List<WebElement> elements= driver.findElements(sabbathSchoolDetailsPage.subMenuListTextLocator);
        int count=elements.size();
        System.out.println(count);
        Assertions.assertEquals(8,count);
    }
    @Test
    public void verifyGeneralTabButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(sabbathSchoolDetailsPage.generalTabButtonLocator).click();
        String text=driver.findElement(sabbathSchoolDetailsPage.generalTabTextLocator).getText();
        System.out.println(text);
        Assertions.assertEquals("General",text);
    }
    @Test
    public void verifyHeaderBannerSupportTeamButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(sabbathSchoolDetailsPage.headerBannerDropdownLocator).click();
        driver.findElement(sabbathSchoolDetailsPage.headerBannerSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String text=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
        System.out.println(text);
        Assertions.assertEquals("Support Team Form",text);
    }

    @Test
    public void verifyWhatIsSabbathSchoolSupportTeamButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(sabbathSchoolDetailsPage.whatIsSabbathSchoolDropdownLocator).click();
        driver.findElement(sabbathSchoolDetailsPage.whatIsSabbathSchoolSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
    @Test
    public void verifyChurchMapSupportTeamButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(sabbathSchoolDetailsPage.churchMapDropdownLocator).click();
        driver.findElement(sabbathSchoolDetailsPage.churchMapSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
    @Test
    public void verifyFocusOnMissionSupportTeamButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(sabbathSchoolDetailsPage.focusOnMissionDropdownLocator).click();
        driver.findElement(sabbathSchoolDetailsPage.focusOnMissionSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
    @Test
    public void verifySabbathClassesAgeToggleSaveButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(2000);
        sabbathSchoolDetailsPage.multipleSaveSabbathClassesAges();


    }
    @Test
    public void verifySabbathClassesAgeTogglePublishButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(2000);
        sabbathSchoolDetailsPage.multiplePublishSabbathClassesAges();

    }
    @Test
    public void verifyThisWeekLessonSupportTeamButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(sabbathSchoolDetailsPage.thisWeekLessonDropdownLocator).click();
        driver.findElement(sabbathSchoolDetailsPage.thisWeekLessonSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
    @Test
    public void verifySabbathSchoolBannerSupportTeamButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolBannerDropdownLocator).click();
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolBannerSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
    @Test
    public void verifyContactFormSupportTeamButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(sabbathSchoolDetailsPage.contactFormDropdownLocator).click();
        driver.findElement(sabbathSchoolDetailsPage.contactFormSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        String successText=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
        Assertions.assertEquals("Support Team Form",successText);
    }
    @Test
    public void verifySupportTeamFormCancelButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(sabbathSchoolDetailsPage.contactFormDropdownLocator).click();
        driver.findElement(sabbathSchoolDetailsPage.contactFormSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        driver.findElement(sabbathSchoolDetailsPage.supportTeamFormSubjectTextLocator).sendKeys("Support Subject");
        driver.findElement(sabbathSchoolDetailsPage.supportTeamFormMessageTextareaLocator).sendKeys("Support Message");
        driver.findElement(sabbathSchoolDetailsPage.supportTeamFormCancelButtonLocator).click();
        Thread.sleep(2000);
        if (sabbathSchoolDetailsPage.isCancelOrCloseSuccessful()) {
            Assertions.assertFalse(sabbathSchoolDetailsPage.isCancelOrCloseSuccessful());
        } else {
            Assertions.assertFalse(sabbathSchoolDetailsPage.isCancelOrCloseSuccessful());
        }


    }
    @Test
    public void verifySupportTeamFormCloseButton() throws InterruptedException {
        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
        Thread.sleep(2000);
        driver.findElement(sabbathSchoolDetailsPage.contactFormDropdownLocator).click();
        driver.findElement(sabbathSchoolDetailsPage.contactFormSupportTeamButtonLocator).click();
        Thread.sleep(2000);
        driver.findElement(sabbathSchoolDetailsPage.supportTeamFormSubjectTextLocator).sendKeys("Support Subject");
        driver.findElement(sabbathSchoolDetailsPage.supportTeamFormMessageTextareaLocator).sendKeys("Support Message");

        driver.findElement(sabbathSchoolDetailsPage.supportTeamFormCloseButtonLocator).click();
        Thread.sleep(2000);
        if (sabbathSchoolDetailsPage.isCancelOrCloseSuccessful()) {
            Assertions.assertFalse(sabbathSchoolDetailsPage.isCancelOrCloseSuccessful());
        } else {
            Assertions.assertFalse(sabbathSchoolDetailsPage.isCancelOrCloseSuccessful());
        }
    }
}
