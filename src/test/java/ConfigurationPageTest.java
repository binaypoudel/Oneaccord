import configuration.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.ConfigurationPage;
import pages.LoginPage;

import java.io.IOException;

public class ConfigurationPageTest {

    private static WebDriver driver;
    final static String correctUsername="binay.poudel@webpoint.io";
    final static String correctPassword="Webpoint@2024";
    public static LoginPage loginPage;
    public static ConfigurationPage configurationPage;

    @BeforeEach
    public  void setUp() throws InterruptedException, IOException {
        driver = new DriverFactory().getDriver();
        loginPage=new LoginPage(driver);
        configurationPage=new ConfigurationPage(driver);
        loginPage.logins(correctUsername,correctPassword);
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(configurationPage.websiteContentButtonLocator)).perform();
        driver.findElement(configurationPage.configurationButtonLocator).click();
    }

    @AfterEach
    public  void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyConfigurationPage() throws InterruptedException {

        String pageText=driver.findElement(configurationPage.configurationTextLocator).getText();
        System.out.println(pageText);
        Assertions.assertEquals("General Configuration",pageText);

    }

//    @Test
//    public void verifyChangingCorrectEmail() throws InterruptedException {
//        driver.findElement(configurationPage.emailFieldLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.emailFieldLocator).sendKeys("bimala.raii@webpoint.io");
//        Thread.sleep(3000);
//        driver.findElement(configurationPage.saveButtonLocator).click();
//        String elements = driver.findElement(configurationPage.successMessageLocator).getText();
//        System.out.println(elements);
//        Assertions.assertEquals("Website configuration updated successfully.",elements);
//    }
//    @Test
//    public void verifyPassingInCorrectEmail() throws InterruptedException {
//        driver.findElement(configurationPage.emailFieldLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        driver.findElement(configurationPage.emailFieldLocator).sendKeys("bimala.rai@webpoint");
//        Thread.sleep(3000);
//        driver.findElement(configurationPage.saveButtonLocator).click();
//        String elements = driver.findElement(configurationPage.emailIsRequiredTextLocator).getText();
//        System.out.println(elements);
//        Assertions.assertEquals("Valid email address is required.",elements);
//    }
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
////    @Test
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
//     @Test
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
