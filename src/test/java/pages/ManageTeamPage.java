package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;




public class ManageTeamPage {
    final WebDriver driver;
    public By ManageTeamButtonLocator = By.xpath("//body/div[1]/div[1]/aside[1]/div[1]/a[4]");
    public By ManageTeamTextLocator = By.xpath("//h3[contains(text(),'Manage Team')]");
    public By addTeamMemberButtonLocator = By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]");
    public By addTeamMemberTextLocator = By.xpath(" //h3[contains(text(),'Add Team Member')]");
    public By searchAddressTextLocator = By.tagName("h2");
    public By saveButtonLocator = By.xpath("//body[1]/div[1]/div[1]/header[1]/div[2]/button[2]");


    public By successMessageLocator = By.xpath("//body[1]/section[1]/ol[1]/li[1]/div[2]/div[1]");
    public By emailIsRequiredTextLocator = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]");
    public By validPhoneNumberRequiredLocator = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]");
    public By validFaceBookUrlRequiredLocator = By.xpath("//div[contains(text(),'Valid Facebook group or page URL is required.')]");
    public By validYoutubeUrlRequiredLocator = By.xpath("//div[contains(text(),'Valid youtube Channel URL is required.')]");
    public By validInstagramUrlRequiredLocator = By.xpath("//div[contains(text(),'Valid Instagram URL is required.')]");
    public By addTeamMemberCancelButtonLocator = By.xpath("//button[contains(text(),'Cancel')]");
    public By locationCloseButtonLocator = By.xpath("//body[1]/div[4]/div[1]/div[1]/button[3]");








    public ManageTeamPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isCancelOrCloseSuccessful() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(addTeamMemberTextLocator));
            WebElement res = driver.findElement(addTeamMemberTextLocator);
            String str = res.getText();
            return str.equals("Add Team Member");
        }
        catch (Exception e){
            return false;

        }
    }

}



