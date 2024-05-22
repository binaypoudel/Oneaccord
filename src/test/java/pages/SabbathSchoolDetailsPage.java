package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



public class SabbathSchoolDetailsPage {
    final WebDriver driver;
    public By websiteContentButtonLocator = By.xpath("//body/div[1]/aside[1]/div[1]/button[1]");
    public By pageButtonLocator = By.xpath("//a[contains(text(),'Pages')]");
    public By pageTextLocator = By.xpath("//h3[contains(text(),'Pages')]");
    public By sabbathSchoolEditLocator = By.xpath("//tbody/tr[4]/td[5]/button[1]");
    public By commonTextLocator = By.xpath("//header/div[1]/div[3]/span[1]");
    public By subMenuListTextLocator = By.xpath(" //li[@class='px-1.5 py-1 flex gap-2 items-center rounded-md cursor-pointer hover:bg-accent-50']");
    public By generalTabButtonLocator = By.xpath("//button[contains(text(),'General')]");
    public By generalTabTextLocator = By.xpath("//h6[contains(text(),'General')]");



    public By headerBannerDropdownLocator = By.xpath("//h4[contains(text(),'Header Banner')]");
    public By whatIsSabbathSchoolDropdownLocator = By.xpath("//h4[contains(text(),'What Is Sabbath School')]");
    public By churchMapDropdownLocator = By.xpath("//h4[contains(text(),'Church Map')]");
    public By focusOnMissionDropdownLocator = By.xpath("//h4[contains(text(),'Focus On Mission')]");
    public By sabbathClassesDropdownLocator = By.xpath("//h4[contains(text(),'Sabbath Classes')]");
    public By thisWeekLessonDropdownLocator = By.xpath("//h4[contains(text(),\"This Week's Lesson\")]");
    public By sabbathSchoolBannerDropdownLocator = By.xpath("//h4[contains(text(),'Sabbath School Banner')]");
    public By contactFormDropdownLocator = By.xpath("//h4[contains(text(),'Contact Form')]");


    public By sabbathClassesBeginnerToggleLocator = By.xpath("//button[@id='sabbath_classes_beginner']");
    public By sabbathClassesKindergartenToggleLocator = By.xpath("//button[@id='sabbath_classes_kindergarten']");
    public By sabbathClassesPrimaryToggleLocator = By.xpath("//button[@id='sabbath_classes_primary']");
    public By sabbathClassesJuniorToggleLocator = By.xpath("//button[@id='sabbath_classes_junior']");
    public By sabbathClassesTeenageToggleLocator = By.xpath("//button[@id='sabbath_classes_teenage']");
    public By sabbathClassesYouthToggleLocator = By.xpath("//button[@id='sabbath_classes_youth']");
    public By sabbathClassesYoungAdultToggleLocator = By.xpath("//button[@id='sabbath_classes_young_adult']");
    public By sabbathClassesAdultToggleLocator = By.xpath("//button[@id='sabbath_classes_adult']");


    public By saveButtonLocator = By.xpath("//button[contains(text(),'Save')]");
    public By publishButtonLocator = By.xpath("//button[contains(text(),'Publish')]");
    public By successfullyPublishedTextLocator = By.xpath("//div[contains(text(),'You have successfully published your changes to th')]");
    public By draftSavedSuccessfullyLocator = By.xpath(" //div[contains(text(),'Draft saved successfully.')]");


    public By headerBannerSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");
    public By whatIsSabbathSchoolSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");
    public By churchMapSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");
    public By focusOnMissionSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");
    public By thisWeekLessonSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");
    public By sabbathSchoolBannerSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[7]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");


    public By contactFormSupportTeamButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[8]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");


    public By supportTeamFormTextLocator = By.xpath("  //h4[contains(text(),'Support Team Form')]");
    public By supportTeamFormSubjectTextLocator = By.xpath("//body[1]/div[4]/div[2]/form[1]/div[1]/div[1]/div[1]/input[1]");
    public By supportTeamFormMessageTextareaLocator = By.xpath("//body[1]/div[4]/div[2]/form[1]/div[2]/div[1]/textarea[1]");
    public By supportTeamFormCancelButtonLocator = By.xpath(" //button[contains(text(),'Cancel')]");
    public By supportTeamFormCloseButtonLocator = By.xpath("  //body[1]/div[4]/button[1]");
    public By supportTeamFormSubmitButtonLocator = By.xpath("  //button[contains(text(),'Submit')]");
    public By successMessageLocator = By.xpath("//div[contains(text(),'Sent message to support team')]");
    public By supportFormSubjectIsRequiredLocator = By.xpath("//div[contains(text(),'Subject is required.')]");
    public By supportFormMessageIsRequiredLocator = By.xpath("//span[contains(text(),'Message is required.')]");



    public SabbathSchoolDetailsPage(WebDriver driver) {
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
    public void multipleSaveSabbathClassesAges() throws InterruptedException {
        driver.findElement(sabbathClassesDropdownLocator).click();
        String[] elements = {"//button[@id='sabbath_classes_beginner']", "//button[@id='sabbath_classes_kindergarten']", "//button[@id='sabbath_classes_primary']", "//button[@id='sabbath_classes_junior']", "//button[@id='sabbath_classes_teenage']", "//button[@id='sabbath_classes_youth']", "//button[@id='sabbath_classes_young_adult']", "//button[@id='sabbath_classes_adult']"};
        for (String element : elements) {

            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement toggle = driver.findElement(By.xpath(element));
            toggle.click();
            toggle = driver.findElement(By.xpath(element));
            Thread.sleep(2000);
            driver.findElement(saveButtonLocator).click();
            String successText = driver.findElement(draftSavedSuccessfullyLocator).getText();
            Assertions.assertEquals("Draft saved successfully.", successText);

        }
    }
        public void multiplePublishSabbathClassesAges () throws InterruptedException {
            driver.findElement(sabbathClassesDropdownLocator).click();
            String[] elements = {"//button[@id='sabbath_classes_beginner']", "//button[@id='sabbath_classes_kindergarten']", "//button[@id='sabbath_classes_primary']", "//button[@id='sabbath_classes_junior']", "//button[@id='sabbath_classes_teenage']", "//button[@id='sabbath_classes_youth']", "//button[@id='sabbath_classes_young_adult']", "//button[@id='sabbath_classes_adult']"};
            for (String element : elements) {

                Thread.sleep(2000);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement toggle = driver.findElement(By.xpath(element));
                toggle.click();
                toggle = driver.findElement(By.xpath(element));
                Thread.sleep(2000);
                driver.findElement(publishButtonLocator).click();
                String successText = driver.findElement(successfullyPublishedTextLocator).getText();
                Assertions.assertEquals("You have successfully published your changes to the live.", successText);

            }


        }
    }



