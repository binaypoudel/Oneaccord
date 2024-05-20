package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomeDetailsPage {
    final WebDriver driver;
    public By websiteContentButtonLocator = By.xpath("//body/div[1]/aside[1]/div[1]/button[1]");
    public By pageButtonLocator = By.xpath("//a[contains(text(),'Pages')]");
    public By pageTextLocator = By.xpath("//h3[contains(text(),'Pages')]");
    public By homePageEditLocator = By.xpath("//tbody/tr[1]/td[5]/button[1]");
    public By commonTextLocator = By.xpath("//header/div[1]/div[3]/span[1]");
    public By subMenuListTextLocator = By.xpath(" //li[@class='px-1.5 py-1 flex gap-2 items-center rounded-md cursor-pointer hover:bg-accent-50']");
    public By generalTabButtonLocator = By.xpath("//button[contains(text(),'General')]");
    public By generalTabTextLocator = By.xpath("//h6[contains(text(),'General')]");
    public By heroBannerButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/section[1]/button[1]");
    public By heroBannerTitleLocator = By.tagName("textarea");
    public By saveButtonLocator = By.xpath("//button[contains(text(),'Save')]");
    public By publishButtonLocator = By.xpath("//button[contains(text(),'Publish')]");
    public By successfullyPublishedTextLocator = By.xpath("//div[contains(text(),'You have successfully published your changes to th')]");
    public By titleRequiredTextLocator = By.xpath("//span[contains(text(),'Title is required.')]");
    public By draftSavedSuccessfullyLocator = By.xpath(" //div[contains(text(),'Draft saved successfully.')]");
    public By heroBannerServiceTimeLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/section[1]/div[1]/section[2]/div[1]/div[1]/button[1]/span[1]");
    public By goToWorshipSettingLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/section[1]/div[1]/section[2]/div[2]/a[1]");
    public By eventDropdownLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/section[1]/button[1]");
    public By worshipTimeTextLocator = By.xpath(" //div[contains(text(),'Worship Time')]");
    public By eventsToggleButtonLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/section[1]/div[1]/section[1]/div[1]/div[1]/button[1]");
    public By goToEventManagementLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/section[1]/div[1]/section[1]/div[2]/div[1]/div[1]/button[1]");
    public By eventPageTextLocator = By.xpath(" //h3[contains(text(),'Events')]");
    public By  sabbathDropdownLocator= By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[7]/section[1]/button[1]");
    public By goToSabbathPageLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[7]/section[1]/div[1]/section[1]/div[2]/div[1]/div[1]/button[1]");
    public By sabbathClassTextLocator = By.xpath(" //h4[contains(text(),'Sabbath Classes')]");
    public By sabbathSchoolToggleButtonLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[7]/section[1]/div[1]/section[1]/div[1]/div[1]/button[1]");
    public By learningCenterDropdownLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[8]/section[1]/button[1]");
    public By learningCenterToggleButtonLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[8]/section[1]/div[1]/section[1]/div[1]/div[1]/button[1]");
    public By connectWithUsDropdownLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[9]/section[1]/button[1]");
    public By connectWithUsToggleButtonLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[9]/section[1]/div[1]/section[1]/div[1]/div[1]/button[1]");
    public By goToGeneralConfigurationLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[9]/section[1]/div[1]/section[1]/div[2]/div[1]/div[1]/button[1]");
    public By generalConfigurationTextLocator = By.xpath(" //h3[contains(text(),'General Configuration')]");











    public HomeDetailsPage(WebDriver driver) {
        this.driver = driver;
    }



}