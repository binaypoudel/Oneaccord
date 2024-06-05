import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.ManageTeamPage;
import org.openqa.selenium.Cookie;
import pages.SabbathSchoolDetailsPage;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;


public class ManageTeamPageTest {

    private static WebDriver driver;
    final static String correctUsername="binay.poudel@webpoint.io";
    final static String correctPassword="Webpoint@2024";
    public static LoginPage loginPage;
    public static ManageTeamPage manageTeamPage;
    private static Set<Cookie> cookies;

    @BeforeAll
    public  static void setUpOnce() throws InterruptedException, IOException {
        Properties prop=new Properties();
        File file=new File("src/test/java/config.properties");
        FileInputStream fis=new FileInputStream(file);
        prop.load(fis);
        String browserName=prop.getProperty("browser");

        switch (browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                driver = new ChromeDriver();
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            case null, default:
                System.out.println("Invalid Browser");
        }
        String linkName=prop.getProperty("linkName");
        driver.get(linkName);
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        manageTeamPage=new ManageTeamPage(driver);
        loginPage.logins(correctUsername,correctPassword);
        cookies = driver.manage().getCookies();
        Thread.sleep(2000);

    }
    @BeforeEach
    public void setUp() throws InterruptedException {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://admin.dev.oneaccord.cc/dashboard/teams");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        manageTeamPage=new ManageTeamPage(driver);
        driver.findElement(manageTeamPage.ManageTeamButtonLocator).click();

    }

    @AfterAll
    public  static void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyManageTeamPage() throws InterruptedException {

        String pageText=driver.findElement(manageTeamPage.ManageTeamTextLocator).getText();
        Assertions.assertEquals("Manage Team",pageText);
    }

    @Test
    public void verifyAddTeamMemberButton() throws InterruptedException {
        driver.findElement(manageTeamPage.addTeamMemberButtonLocator).click();
        String elements = driver.findElement(manageTeamPage.addTeamMemberTextLocator).getText();
        System.out.println(elements);
        Assertions.assertEquals("Add Team Member",elements);
    }
    @Test
    public void verifyAddTeamMemberCancelButton() throws InterruptedException {
        driver.findElement(manageTeamPage.addTeamMemberButtonLocator).click();
        Thread.sleep(2000);
        driver.findElement(manageTeamPage.addTeamMemberCancelButtonLocator).click();
        Thread.sleep(2000);
        if (manageTeamPage.isCancelOrCloseSuccessful()) {
            Assertions.assertFalse(manageTeamPage.isCancelOrCloseSuccessful());
        } else {
            Assertions.assertFalse(manageTeamPage.isCancelOrCloseSuccessful());
        }
    }
    @Test
    public void verifyLocationFormCancelButton() throws InterruptedException {

    }
//    @Test
//    public void verifyChangingPhoneNumber() throws InterruptedException {
//        driver.findElement(configurationPage.phoneNumberFieldLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.phoneNumberFieldLocator).sendKeys("9876084934");
//        Thread.sleep(3000);
//        driver.findElement(configurationPage.saveButtonLocator).click();
//        String elements = driver.findElement(configurationPage.successMessageLocator).getText();
//        System.out.println(elements);
//        Assertions.assertEquals("Website configuration updated successfully.",elements);
//    }
//    @Test
//    public void verifyPassingIncorrectPhoneNumber() throws InterruptedException {
//        driver.findElement(configurationPage.phoneNumberFieldLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.phoneNumberFieldLocator).sendKeys("9876084934");
//        Thread.sleep(3000);
//        driver.findElement(configurationPage.saveButtonLocator).click();
//        String elements = driver.findElement(configurationPage.validPhoneNumberRequiredLocator).getText();
//        System.out.println(elements);
//        Assertions.assertEquals("Valid phone number is required.",elements);
//    }
//    @Test
//    public void verifyAddingCorrectFacebookLink() throws InterruptedException {
//        driver.findElement(configurationPage.facebookLinkLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.facebookLinkLocator).sendKeys("https://www.facebook.com/hello/");
//        Thread.sleep(3000);
//        driver.findElement(configurationPage.saveButtonLocator).click();
//        String elements = driver.findElement(configurationPage.successMessageLocator).getText();
//        System.out.println(elements);
//        Assertions.assertEquals("Website configuration updated successfully.",elements);
//        driver.findElement(configurationPage.facebookLinkLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.saveButtonLocator).click();
//    }
//    @Test
//    public void verifyAddingInCorrectFacebookLink() throws InterruptedException {
//        driver.findElement(configurationPage.facebookLinkLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.facebookLinkLocator).sendKeys("https://www.facebook.com/hello/test");
//        Thread.sleep(3000);
//        driver.findElement(configurationPage.saveButtonLocator).click();
//        String elements = driver.findElement(configurationPage.validFaceBookUrlRequiredLocator).getText();
//        System.out.println(elements);
//        Assertions.assertEquals("Valid Facebook group or page URL is required.",elements);
//    }
//    @Test
//    public void verifyAddingCorrectYouTubeLink() throws InterruptedException {
//        driver.findElement(configurationPage.youtubeLinkLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.youtubeLinkLocator).sendKeys("https://www.youtube.com/@hello");
//        Thread.sleep(3000);
//        driver.findElement(configurationPage.saveButtonLocator).click();
//        String elements = driver.findElement(configurationPage.successMessageLocator).getText();
//        System.out.println(elements);
//        Assertions.assertEquals("Website configuration updated successfully.",elements);
//        driver.findElement(configurationPage.youtubeLinkLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.saveButtonLocator).click();
//    }
//    @Test
//    public void verifyAddingInCorrectYouTubeLink() throws InterruptedException {
//        driver.findElement(configurationPage.youtubeLinkLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.youtubeLinkLocator).sendKeys("https://www.youtube.com/@hello/test");
//        Thread.sleep(3000);
//        driver.findElement(configurationPage.saveButtonLocator).click();
//        String elements = driver.findElement(configurationPage.validYoutubeUrlRequiredLocator).getText();
//        System.out.println(elements);
//        Assertions.assertEquals("Valid youtube Channel URL is required.",elements);
//
//    }
//    @Test
//    public void verifyAddingCorrectInstagramLink() throws InterruptedException {
//        driver.findElement(configurationPage.instagramLinkLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.instagramLinkLocator).sendKeys("https://www.instagram.com/@hello");
//        Thread.sleep(3000);
//        driver.findElement(configurationPage.saveButtonLocator).click();
//        String elements = driver.findElement(configurationPage.successMessageLocator).getText();
//        System.out.println(elements);
//        Assertions.assertEquals("Website configuration updated successfully.",elements);
//        driver.findElement(configurationPage.instagramLinkLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.saveButtonLocator).click();
//    }
//    @Test
//    public void verifyAddingInCorrectInstagramLink() throws InterruptedException {
//        driver.findElement(configurationPage.instagramLinkLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.instagramLinkLocator).sendKeys("https://www.instagram.com/@hello/test");
//        Thread.sleep(3000);
//        driver.findElement(configurationPage.saveButtonLocator).click();
//        String elements = driver.findElement(configurationPage.validInstagramUrlRequiredLocator).getText();
//        System.out.println(elements);
//        Assertions.assertEquals("Valid Instagram URL is required.",elements);
//
//    }
//    @Test
//    public void verifyLocationAddress() throws InterruptedException {
//        driver.findElement(configurationPage.locationButtonLocator).click();
//        Thread.sleep(3000);
//        String elements = driver.findElement(configurationPage.searchAddressTextLocator).getText();
//        System.out.println(elements);
//        Assertions.assertEquals("Search Address",elements);
//
//    }
//    //    @Test
////    public void verifyGeneralTabButton() throws InterruptedException {
////        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
////        Thread.sleep(2000);
////        driver.findElement(sabbathSchoolDetailsPage.generalTabButtonLocator).click();
////        String text=driver.findElement(sabbathSchoolDetailsPage.generalTabTextLocator).getText();
////        System.out.println(text);
////        Assertions.assertEquals("General",text);
////    }
////    @Test
////    public void verifyHeaderBannerSupportTeamButton() throws InterruptedException {
////        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
////        Thread.sleep(2000);
////        driver.findElement(sabbathSchoolDetailsPage.headerBannerDropdownLocator).click();
////        driver.findElement(sabbathSchoolDetailsPage.headerBannerSupportTeamButtonLocator).click();
////        Thread.sleep(2000);
////        String text=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
////        System.out.println(text);
////        Assertions.assertEquals("Support Team Form",text);
////    }
////
////    @Test
////    public void verifyWhatIsSabbathSchoolSupportTeamButton() throws InterruptedException {
////        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
////        Thread.sleep(2000);
////        driver.findElement(sabbathSchoolDetailsPage.whatIsSabbathSchoolDropdownLocator).click();
////        driver.findElement(sabbathSchoolDetailsPage.whatIsSabbathSchoolSupportTeamButtonLocator).click();
////        Thread.sleep(2000);
////        String successText=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
////        Assertions.assertEquals("Support Team Form",successText);
////    }
////    @Test
////    public void verifyChurchMapSupportTeamButton() throws InterruptedException {
////        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
////        Thread.sleep(2000);
////        driver.findElement(sabbathSchoolDetailsPage.churchMapDropdownLocator).click();
////        driver.findElement(sabbathSchoolDetailsPage.churchMapSupportTeamButtonLocator).click();
////        Thread.sleep(2000);
////        String successText=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
////        Assertions.assertEquals("Support Team Form",successText);
////    }
////    @Test
////    public void verifyFocusOnMissionSupportTeamButton() throws InterruptedException {
////        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
////        Thread.sleep(2000);
////        driver.findElement(sabbathSchoolDetailsPage.focusOnMissionDropdownLocator).click();
////        driver.findElement(sabbathSchoolDetailsPage.focusOnMissionSupportTeamButtonLocator).click();
////        Thread.sleep(2000);
////        String successText=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
////        Assertions.assertEquals("Support Team Form",successText);
////    }
////    @Test
////    public void verifySabbathClassesAgeToggleSaveButton() throws InterruptedException {
////        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
////        Thread.sleep(2000);
////        sabbathSchoolDetailsPage.multipleSaveSabbathClassesAges();
////
////
////    }
////    @Test
////    public void verifySabbathClassesAgeTogglePublishButton() throws InterruptedException {
////        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
////        Thread.sleep(2000);
////        sabbathSchoolDetailsPage.multiplePublishSabbathClassesAges();
////
////    }
////    @Test
////    public void verifyThisWeekLessonSupportTeamButton() throws InterruptedException {
////        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
////        Thread.sleep(2000);
////        driver.findElement(sabbathSchoolDetailsPage.thisWeekLessonDropdownLocator).click();
////        driver.findElement(sabbathSchoolDetailsPage.thisWeekLessonSupportTeamButtonLocator).click();
////        Thread.sleep(2000);
////        String successText=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
////        Assertions.assertEquals("Support Team Form",successText);
////    }
////    @Test
////    public void verifySabbathSchoolBannerSupportTeamButton() throws InterruptedException {
////        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
////        Thread.sleep(2000);
////        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolBannerDropdownLocator).click();
////        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolBannerSupportTeamButtonLocator).click();
////        Thread.sleep(2000);
////        String successText=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
////        Assertions.assertEquals("Support Team Form",successText);
////    }
////    @Test
////    public void verifyContactFormSupportTeamButton() throws InterruptedException {
////        driver.findElement(sabbathSchoolDetailsPage.sabbathSchoolEditLocator).click();
////        Thread.sleep(2000);
////        driver.findElement(sabbathSchoolDetailsPage.contactFormDropdownLocator).click();
////        driver.findElement(sabbathSchoolDetailsPage.contactFormSupportTeamButtonLocator).click();
////        Thread.sleep(2000);
////        String successText=driver.findElement(sabbathSchoolDetailsPage.supportTeamFormTextLocator).getText();
////        Assertions.assertEquals("Support Team Form",successText);
////    }
//    @Test
//    public void verifyLocationFormCancelButton() throws InterruptedException {
//        driver.findElement(configurationPage.locationButtonLocator).click();
//        Thread.sleep(2000);
//        driver.findElement(configurationPage.locationCancelButtonLocator).click();
//        Thread.sleep(2000);
//        if (configurationPage.isCancelOrCloseSuccessful()) {
//            Assertions.assertFalse(configurationPage.isCancelOrCloseSuccessful());
//        } else {
//            Assertions.assertFalse(configurationPage.isCancelOrCloseSuccessful());
//        }
//    }
//    @Test
//    public void verifyLocationFormCloseButton() throws InterruptedException {
//        driver.findElement(configurationPage.locationButtonLocator).click();
//        Thread.sleep(2000);
//        driver.findElement(configurationPage.locationCloseButtonLocator).click();
//        Thread.sleep(2000);
//        if (configurationPage.isCancelOrCloseSuccessful()) {
//            Assertions.assertFalse(configurationPage.isCancelOrCloseSuccessful());
//        } else {
//            Assertions.assertFalse(configurationPage.isCancelOrCloseSuccessful());
//        }
//    }
}
