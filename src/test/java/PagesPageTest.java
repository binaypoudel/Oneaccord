import  org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.PagesPage;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PagesPageTest {

    private WebDriver driver;
    final String correctUsername="binay.poudel@webpoint.io";
    final String correctPassword="Webpoint@2024";
    LoginPage loginPage;
    private PagesPage pagesPage;

    @BeforeEach
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://cms.dev.oneaccord.cc/login");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        pagesPage=new PagesPage(driver);
        loginPage.logins(correctUsername,correctPassword);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyPagesButton() throws InterruptedException {
        driver.findElement(pagesPage.websiteContentButtonLocator).click();
        driver.findElement(pagesPage.pageButtonLocator).click();
        String pageText=driver.findElement(pagesPage.pageTextLocator).getText();
        Assertions.assertEquals("Pages",pageText);
    }
    @Test
    public void numberOfPageList() throws InterruptedException {
        driver.findElement(pagesPage.websiteContentButtonLocator).click();
        driver.findElement(pagesPage.pageButtonLocator).click();
        Thread.sleep(3000);
        List<WebElement> pagelist=driver.findElements(pagesPage.pageListLocator);
//        for(int i=0; i<pagelist.size();i++) {
//            String elementCheck = pagelist.get(i).getText();
//            System.out.println(elementCheck);
//        }
        int count=pagelist.size();
        Assertions.assertEquals(4,count);

    }
//    @Test
//    public void pageSearchInputValidation() throws InterruptedException {
//        driver.findElement(pagesPage.websiteContentButtonLocator).click();
//        driver.findElement(pagesPage.pageButtonLocator).click();
//        Thread.sleep(3000);
//        String[] searchInput ={"Home","About","Plan Your Visit","Sabbath"};
//        for (String s : searchInput) {
//            driver.findElement(pagesPage.pageSearchLocator).clear();
//            driver.findElement(pagesPage.pageSearchLocator).sendKeys(s);
//            Thread.sleep(3000);
//            List<WebElement> elements = driver.findElements(pagesPage.pageListLocator);
//            for (int a = 0; a < elements.size(); a++) {
//                String elementCheck = elements.get(a).getText();
//                System.out.println(elementCheck);
//                Assertions.assertTrue(elementCheck.contains(s));
//            }
//            driver.navigate().refresh();
//
//        }
//
//    }
    @Test
    public void searchTextInputValidation() throws InterruptedException {
        driver.findElement(pagesPage.websiteContentButtonLocator).click();
        driver.findElement(pagesPage.pageButtonLocator).click();
        String[] searchInput ={"Home","About","Plan Your Visit","Sabbath"};
        for (String s : searchInput) {
            driver.findElement(pagesPage.pageSearchLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
            driver.findElement(pagesPage.pageSearchLocator).sendKeys(s);
            Thread.sleep(3000);
            List<WebElement> elements = driver.findElements(pagesPage.pageListLocator);
            for (int a = 0; a < elements.size(); a++) {
                String elementCheck = elements.get(a).getText();
                System.out.println(elementCheck);
                Assertions.assertTrue(elementCheck.contains(s));
            }
        }

    }
    @Test
    public void inappropriateSearchTextInputValidation() throws InterruptedException {
        driver.findElement(pagesPage.websiteContentButtonLocator).click();
        driver.findElement(pagesPage.pageButtonLocator).click();
        driver.findElement(pagesPage.pageSearchLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(pagesPage.pageSearchLocator).sendKeys("abcd");
        Thread.sleep(3000);
        String elements = driver.findElement(pagesPage.noResultLocator).getText();
        //System.out.println(elements);
        Assertions.assertEquals("No results.",elements);
    }
    @Test
    public void verifyHomePageEditButton() throws InterruptedException {
        driver.findElement(pagesPage.websiteContentButtonLocator).click();
        driver.findElement(pagesPage.pageButtonLocator).click();
        driver.findElement(pagesPage.homePageEditLocator).click();
        Thread.sleep(3000);
        String elements = driver.findElement(pagesPage.commonTextLocator).getText();
        System.out.println(elements);
        Assertions.assertEquals("Home Page",elements);
    }
    @Test
    public void verifyAboutPageEditButton() throws InterruptedException {
        driver.findElement(pagesPage.websiteContentButtonLocator).click();
        driver.findElement(pagesPage.pageButtonLocator).click();
        driver.findElement(pagesPage.aboutPageEditLocator).click();
        Thread.sleep(3000);
        String elements = driver.findElement(pagesPage.commonTextLocator).getText();
        System.out.println(elements);
        Assertions.assertEquals("About Page",elements);
    }
    @Test
    public void verifyPlanYourVisitPageEditButton() throws InterruptedException {
        driver.findElement(pagesPage.websiteContentButtonLocator).click();
        driver.findElement(pagesPage.pageButtonLocator).click();
        driver.findElement(pagesPage.planPageEditLocator).click();
        Thread.sleep(3000);
        String elements = driver.findElement(pagesPage.commonTextLocator).getText();
        System.out.println(elements);
        Assertions.assertEquals("Plan Your Visit",elements);
    }
    @Test
    public void verifySabbathPageEditButton() throws InterruptedException {
        driver.findElement(pagesPage.websiteContentButtonLocator).click();
        driver.findElement(pagesPage.pageButtonLocator).click();
        driver.findElement(pagesPage.sabbathPageEditLocator).click();
        Thread.sleep(3000);
        String elements = driver.findElement(pagesPage.commonTextLocator).getText();
        System.out.println(elements);
        Assertions.assertEquals("Sabbath School",elements);
    }

}