import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MyWebsitePage;


import java.time.Duration;

public class MyWebsitePageTest {

    private WebDriver driver;
    final String correctUsername="binay.poudel@webpoint.io";
    final String correctPassword="Webpoint@2024";
    LoginPage loginPage;
    private MyWebsitePage myWebsitePage;

    @BeforeEach
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://cms.dev.oneaccord.cc/login");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        myWebsitePage=new MyWebsitePage(driver);
        loginPage.logins(correctUsername,correctPassword);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void helpButton() throws InterruptedException {
        driver.findElement(myWebsitePage.helpButtonLocator).click();
        Thread.sleep(2000);
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        String title=driver.getTitle();
        System.out.println(title);
        Assertions.assertEquals("One Accord Help Center",title);
        driver.close();
    }
    @Test
    public void learnMore() throws InterruptedException {
        driver.findElement(myWebsitePage.learnMoreLocator).click();
        Thread.sleep(2000);
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        String title=driver.getTitle();
        System.out.println(title);
        Assertions.assertEquals("One Accord Help Center",title);
        driver.close();
    }
    @Test
    public void viewLiveSite() throws InterruptedException {
        Thread.sleep(2000);
        String domain=driver.findElement(myWebsitePage.domainLocator).getText()+"/";
        System.out.println(domain);
        driver.findElement(myWebsitePage.viewLiveSiteLocator).click();
        Thread.sleep(2000);
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        String url=driver.getCurrentUrl();
        System.out.println(url);
        Assertions.assertEquals(domain,url);

    }
    @Test
    public void configureDomain() throws InterruptedException {
        driver.findElement(myWebsitePage.configureDomainLocator).click();
        Thread.sleep(2000);
        String domainSetup=driver.findElement(myWebsitePage.domainSetupLocator).getText();
        System.out.println(domainSetup);
        Assertions.assertEquals("Domain Setup",domainSetup);
    }
    @Test
    public void editContent() throws InterruptedException {
        driver.findElement(myWebsitePage.editContentLocator).click();
        Thread.sleep(2000);
        String pagesText=driver.findElement(myWebsitePage.pagesLocator).getText();
        System.out.println(pagesText);
        Assertions.assertEquals("Pages",pagesText);
    }
}