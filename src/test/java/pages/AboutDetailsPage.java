package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AboutDetailsPage {
    final WebDriver driver;
    public By websiteContentButtonLocator = By.xpath("//body/div[1]/aside[1]/div[1]/button[1]");
    public By pageButtonLocator = By.xpath("//a[contains(text(),'Pages')]");
    public By pageTextLocator = By.xpath("//h3[contains(text(),'Pages')]");
    public By aboutPageEditLocator = By.xpath("//tbody/tr[2]/td[5]/button[1]");
    public By commonTextLocator = By.xpath("//header/div[1]/div[3]/span[1]");
    public By subMenuListTextLocator = By.xpath(" //li[@class='px-1.5 py-1 flex gap-2 items-center rounded-md cursor-pointer hover:bg-accent-50']");
    public By generalTabButtonLocator = By.xpath("//button[contains(text(),'General')]");
    public By generalTabTextLocator = By.xpath("//h6[contains(text(),'General')]");

    public By aboutUsDropdownLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/section[1]/button[1]");
    public By textBoxEditLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/section[1]/div[1]/section[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]");
    public By saveButtonLocator = By.xpath("//button[contains(text(),'Save')]");
    public By publishButtonLocator = By.xpath("//button[contains(text(),'Publish')]");
    public By successfullyPublishedTextLocator = By.xpath("//div[contains(text(),'You have successfully published your changes to th')]");
    public By draftSavedSuccessfullyLocator = By.xpath(" //div[contains(text(),'Draft saved successfully.')]");
    public By churchMapDropdownLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/section[1]/button[1]");
    public By churchMapGotoSettingLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[1]/button[1]");
    public By locationTextLocator = By.xpath(" //div[contains(text(),'Location')]");
    public By findUsGotoSettingLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[5]/section[1]/div[1]/section[1]/div[1]/div[1]/div[1]/button[1]");
    public By findUsDropdownLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[5]/section[1]/button[1]");
    public By contactInfoTextLocator = By.xpath(" //div[contains(text(),'Contact Info')]");
    public By worshipTimeDropdownLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[7]/section[1]/button[1]");
    public By worshipTimeGotoSettingLocator= By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[7]/section[1]/div[1]/section[1]/div[2]/div[1]/div[1]/button[1]");
    public By worshipTimeTextLocator = By.xpath(" //div[contains(text(),'Worship Time')]");
    public By worshipTimeToggleButtonLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[7]/section[1]/div[1]/section[1]/div[1]/div[1]/button[1]");
    public By prayerMeetingDropdownLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[8]/section[1]/button[1]");
    public By prayerMeetingToggleButtonLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[8]/section[1]/div[1]/section[1]/div[1]/div[1]/button[1]");
    public By prayerMeetingGoToPrayerLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[8]/section[1]/div[1]/section[1]/div[2]/div[1]/div[1]/button[1]");
    public By prayerMeetingTextLocator = By.xpath(" //div[contains(text(),'Prayer Meeting Time')]");
    public By sabbathSchoolDropdownLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[9]/section[1]/button[1]");
    public By sabbathSchoolToggleButtonLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[9]/section[1]/div[1]/section[1]/div[1]/div[1]/button[1]");
    public By sabbathSchoolGoToSabbathLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[9]/section[1]/div[1]/section[1]/div[2]/div[1]/div[1]/button[1]");
    public By sabbathSchoolTextLocator = By.xpath(" //div[contains(text(),'Sabbath School Time')]");
    public By contactFormDropdownLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[10]/section[1]/button[1]");
    public By adventistBannerDropdownLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[11]/section[1]/button[1]");
    public By contactFormSupportTeamButtonLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[10]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");
    public By adventistTeamSupportTeamButtonLocator = By.xpath(" //body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[11]/section[1]/div[1]/section[1]/div[1]/div[1]/p[1]/button[1]");
    public By supportTeamFormTextLocator = By.xpath("  //h4[contains(text(),'Support Team Form')]");







    public AboutDetailsPage(WebDriver driver) {
        this.driver = driver;
    }



}