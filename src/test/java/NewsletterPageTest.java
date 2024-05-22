import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.NewsletterPage;


import java.time.Duration;
import java.util.List;

public class NewsletterPageTest {

    private WebDriver driver;
    final String correctUsername="binay.poudel@webpoint.io";
    final String correctPassword="Webpoint@2024";
    LoginPage loginPage;
    private NewsletterPage newsletterPage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://cms.dev.oneaccord.cc/login");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        newsletterPage=new NewsletterPage(driver);
        loginPage.logins(correctUsername,correctPassword);
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(newsletterPage.websiteContentButtonLocator)).perform();
        driver.findElement(newsletterPage.newsLetterButtonLocator).click();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyNewsletterPage() throws InterruptedException {

        String pageText=driver.findElement(newsletterPage.newsLetterTextLocator).getText();
        Assertions.assertEquals("Newsletter",pageText);
    }
}
