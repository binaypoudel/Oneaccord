import configuration.DriverFactory;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.InterestManagementPage;
import pages.LoginPage;



import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class InterestManagementPageTest {

    private WebDriver driver;
    final String correctUsername="church@admin.com";
    final String correctPassword="Password@123";
    LoginPage loginPage;
    private InterestManagementPage interestManagementPage;
    String fname="bimala";
    String lname="rai";

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new DriverFactory().getDriver();
        loginPage=new LoginPage(driver);
        interestManagementPage=new InterestManagementPage(driver);
        loginPage.logins(correctUsername,correctPassword);
        Thread.sleep(5000);
        driver.findElement(interestManagementPage.interestButtonLocator).click();
        Thread.sleep(3000);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyInterestPage() throws InterruptedException {

        String pageText=driver.findElement(interestManagementPage.interestTextLocator).getText();
        Assertions.assertEquals("Interests",pageText);
    }

    @Test
    public void verifyAddInterestButton() throws InterruptedException {
        driver.findElement(interestManagementPage.addInterestButtonLocator).click();
        Thread.sleep(3000);
        String elements = driver.findElement(interestManagementPage.addInterestPageTextLocator).getText();
        Assertions.assertEquals("Add Interest",elements);
    }
    @Test
    public void verifyAddInterestWithCompleteMandatoryFields() throws InterruptedException {
        driver.findElement(interestManagementPage.addInterestButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(interestManagementPage.addInterestFirstNameLocator).sendKeys(fname);
        driver.findElement(interestManagementPage.addInterestSecondNameLocator).sendKeys(lname);
        driver.findElement(interestManagementPage.addInterestEmailLocator).sendKeys("bimalatestgdrt@gmail.com");
        WebElement element = driver.findElement(By.cssSelector(".min-h-8"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        WebElement dropdown = driver.findElement(By.name("source_id"));
        Select dropdownCategory = new Select(dropdown);
        dropdownCategory.selectByIndex(2);
        Thread.sleep(3000);
        driver.findElement(interestManagementPage.specificSourceLocator).sendKeys("Helath Expo");
        driver.findElement(interestManagementPage.saveButtonLocator).click();
        String elements=driver.findElement(interestManagementPage.successMessageLocator).getText();
        Assertions.assertEquals("Interest created successfully.",elements);
        Thread.sleep(3000);
        String nameText=driver.findElement(interestManagementPage.interestDetailPageNameLocator).getText();
        Assertions.assertEquals(fname+" "+lname,nameText);

    }
    @Test
    public void verifyAddInterestWithDuplicateEmail() throws InterruptedException {
        driver.findElement(interestManagementPage.addInterestButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(interestManagementPage.addInterestFirstNameLocator).sendKeys(fname);
        driver.findElement(interestManagementPage.addInterestSecondNameLocator).sendKeys(lname);
        driver.findElement(interestManagementPage.addInterestEmailLocator).sendKeys("bimalatestrt@gmail.com");
        WebElement element = driver.findElement(By.cssSelector(".min-h-8"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        WebElement dropdown = driver.findElement(By.name("source_id"));
        Select dropdownCategory = new Select(dropdown);
        dropdownCategory.selectByIndex(2);
        Thread.sleep(3000);
        driver.findElement(interestManagementPage.specificSourceLocator).sendKeys("Helath Expo");
        driver.findElement(interestManagementPage.saveButtonLocator).click();
        String elements=driver.findElement(interestManagementPage.duplicateRecordLocator).getText();
        Assertions.assertEquals("Duplicate record",elements);
    }
    @Test
    public void verifyAddInterestWithAllTheFieldsEntered() throws InterruptedException {
        driver.findElement(interestManagementPage.addInterestButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(interestManagementPage.addInterestFirstNameLocator).sendKeys(fname);
        driver.findElement(interestManagementPage.addInterestSecondNameLocator).sendKeys(lname);
        driver.findElement(interestManagementPage.addInterestEmailLocator).sendKeys("bimalatestrtall@gmail.com");
        driver.findElement(interestManagementPage.genderLocator).click();
        driver.findElement(interestManagementPage.phoneLocator).sendKeys("(989) 034-4544");
        driver.findElement(interestManagementPage.dateLocator).click();
        driver.findElement(interestManagementPage.chooseDateLocator).click();
        driver.findElement(interestManagementPage.saveChoosenDateLocator).click();
        Thread.sleep(5000);
        driver.findElement(interestManagementPage.uploadImageLocator).sendKeys("C:\\Users\\Dell\\Desktop\\planet-space-digital-art-4k.jpg");
        Thread.sleep(3000);
        driver.findElement(interestManagementPage.saveUploadImageButtonLocator).click();
        Thread.sleep(3000);
        driver.findElement(interestManagementPage.locationLocator).click();
        Thread.sleep(5000);
        WebElement element=driver.findElement(interestManagementPage.clickOnLocationLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element,20,100).click().perform();
        Thread.sleep(4000);
        driver.findElement(interestManagementPage.continueButtonLocator).click();
        Thread.sleep(5000);
        String street=driver.findElement(interestManagementPage.streetLocator).getAttribute("value");
        if (street.isEmpty()) {
            driver.findElement(interestManagementPage.streetLocator).sendKeys("Naxal");
        }
        String city=driver.findElement(interestManagementPage.cityLocator).getAttribute("value");
        System.out.println(city);
        if (city.isEmpty()) {
            driver.findElement(interestManagementPage.cityLocator).sendKeys("Kathmandu");
        }
        driver.findElement(interestManagementPage.saveLocator).click();
        Thread.sleep(4000);

        WebElement selectElement = driver.findElement(By.cssSelector("div[role='group']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(selectElement).perform();
        WebElement dropdown = driver.findElement(By.name("source_id"));
        Select dropdownCategory = new Select(dropdown);
        dropdownCategory.selectByIndex(2);
        Thread.sleep(3000);
        WebElement specificSource = driver.findElement(interestManagementPage.specificSourceLocator);
        builder.moveToElement(specificSource).release().perform();
        driver.findElement(interestManagementPage.specificSourceLocator).sendKeys("Helath Expo");
        driver.findElement(interestManagementPage.adNotesLocator).sendKeys("We need to record data how this interest add notes that reflect Timeline");
        driver.findElement(interestManagementPage.saveButtonLocator).click();
        String elements=driver.findElement(interestManagementPage.successMessageLocator).getText();
        Assertions.assertEquals("Interest created successfully.",elements);
        Thread.sleep(3000);
        String nameText=driver.findElement(interestManagementPage.interestDetailPageNameLocator).getText();
        Assertions.assertEquals(fname+" "+lname,nameText);
    }

    @Test
    public void verifyInterestQuickView() throws InterruptedException {
        driver.findElement(interestManagementPage.quickViewLocator).click();
        String s=driver.findElement(interestManagementPage.quickViewTextLocator).getText();
        Assertions.assertEquals("Quick View",s);
    }

    @Test
    public void verifyInterestDetailView() throws InterruptedException {
        driver.findElement(interestManagementPage.interestDetailedViewLocator).click();
        String s=driver.findElement(interestManagementPage.interestDetailedViewTextLocator).getText();
        Assertions.assertEquals("Details",s);
    }
    @Test
    public void verifyAssignTeamMemberButton() throws InterruptedException {

        driver.findElement(interestManagementPage.assignTeamMemberButtonLocator).click();

        Thread.sleep(2000);
        String s=driver.findElement(interestManagementPage.assignTeamMemberTextLocator).getText();
        Assertions.assertEquals("Assign Team Member",s);

    }
    @Test
    public void verifyAssignTeamMemberToInterest() throws InterruptedException {

        driver.findElement(interestManagementPage.assignTeamMemberButtonLocator).click();

        Thread.sleep(2000);
        String s=driver.findElement(interestManagementPage.assignTeamMemberTextLocator).getText();
        Assertions.assertEquals("Assign Team Member",s);
        driver.findElement(interestManagementPage.assignTeamMemberFromTeamListLocator).click();
        driver.findElement(interestManagementPage.chooseTeamMembersLocator).click();
        driver.findElement(interestManagementPage.saveAssignTeamMemberButtonLocator).click();
        String successMessage=driver.findElement(interestManagementPage.teamMemberUpdatedSuccessfullyLocator).getText();
        Assertions.assertEquals("Team member updated successfully.",successMessage);


    }
    @Test
    public void verifyFavouriteButton() throws InterruptedException {

        driver.findElement(interestManagementPage.favouriteButtonLocator).click();


        Thread.sleep(2000);
        String s=driver.findElement(interestManagementPage.assignTeamMemberTextLocator).getText();
        Assertions.assertEquals("Assign Team Member",s);
        driver.findElement(interestManagementPage.assignTeamMemberFromTeamListLocator).click();
        driver.findElement(interestManagementPage.chooseTeamMembersLocator).click();
        driver.findElement(interestManagementPage.saveAssignTeamMemberButtonLocator).click();
        String successMessage=driver.findElement(interestManagementPage.teamMemberUpdatedSuccessfullyLocator).getText();
        Assertions.assertEquals("Team member updated successfully.",successMessage);


    }


}

