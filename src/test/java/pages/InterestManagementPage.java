package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;




public class InterestManagementPage {
    final WebDriver driver;

    public By interestButtonLocator = By.xpath("//body/div[1]/div[1]/aside[1]/div[1]/a[3]");
    public By interestTextLocator = By.xpath("//h3[contains(text(),'Interests')]");
    public By addInterestButtonLocator = By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[3]");

    public By addInterestPageTextLocator = By.xpath(" //h5[contains(text(),'Add Interest')]");
    public By addInterestFirstNameLocator = By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]");
    public By addInterestSecondNameLocator = By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]");
    public By addInterestEmailLocator = By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/input[1]");
    public By specificSourceLocator = By.xpath("//input[@placeholder='eg. Health Expo']");
    public By saveButtonLocator = By.xpath("//button[contains(text(),'Save')]");
    public By successMessageLocator = By.xpath("//div[contains(text(),'Interest created successfully.')]");
    public By interestDetailPageNameLocator = By.xpath("//h4[@class='text-h4 text-content-heading break-all']");
    public By duplicateRecordLocator = By.xpath("//div[contains(text(),'Duplicate record')]");


    public By genderLocator = By.xpath("//button[@id='MALE']");
    public By phoneLocator = By.xpath("//input[@name='phone']");
    public By dateLocator = By.xpath("//input[@placeholder='Pick a Date']");
    public By chooseDateLocator = By.xpath("//button[normalize-space()='1']");
    public By saveChoosenDateLocator = By.xpath("//button[normalize-space()='OK']");

    public By uploadImageLocator = By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[5]/div[1]/input[1]");
    public By adNotesLocator = By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[4]/div[2]/div[1]/div[1]/textarea[1]");
    public By saveUploadImageButtonLocator = By.xpath("//div[@role='dialog']//div//div//button[@type='button'][normalize-space()='Save']");
    public By locationLocator = By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]");
    public By clickOnLocationLocator = By.xpath("//body[1]/div[5]/div[2]/div[1]/div[1]/div[3]");
    public By continueButtonLocator = By.xpath("//button[contains(text(),'Continue')]");
    public By streetLocator = By.xpath("//input[@name='road']");
    public By cityLocator = By.xpath("//input[@name='city']");
    public By saveLocator = By.xpath("//body[1]/div[5]/div[1]/div[1]/button[2]");

    public By quickViewLocator = By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[9]/div[1]/span[1]/button[1]");
    public By quickViewTextLocator = By.xpath("//span[contains(text(),'Quick View')]");
    public By interestDetailedViewLocator = By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/a[1]");
    public By interestDetailedViewTextLocator = By.xpath("//body[1]/div[1]/div[2]/header[1]/div[1]/div[3]/span[1]");
    public By assignTeamMemberButtonLocator = By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[9]/div[1]/span[2]/button[1]");


    public By assignTeamMemberTextLocator = By.xpath("//span[contains(text(),'Assign Team Member')]");


    public By assignTeamMemberFromTeamListLocator = By.xpath("  //body[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
    public By chooseTeamMembersLocator=By.xpath("//body[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]");
    public By saveAssignTeamMemberButtonLocator = By.xpath("//button[contains(text(),'Save')]");
    public By teamMemberUpdatedSuccessfullyLocator = By.xpath("//div[contains(text(),'Team member updated successfully.')]");
    public By favouriteButtonLocator = By.xpath(" //body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[9]/div[1]/span[3]/button[1]");
    public By supportTeamFormCloseButtonLocator = By.xpath("  //body[1]/div[4]/button[1]");
    public By supportTeamFormSubmitButtonLocator = By.xpath("  //button[contains(text(),'Submit')]");

    public By supportFormSubjectIsRequiredLocator = By.xpath("//div[contains(text(),'Subject is required.')]");
    public By supportFormMessageIsRequiredLocator = By.xpath("//span[contains(text(),'Message is required.')]");



    public InterestManagementPage(WebDriver driver) {
        this.driver = driver;
    }

}



