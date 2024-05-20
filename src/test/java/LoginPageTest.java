import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;


import java.time.Duration;

public class LoginPageTest {

    private WebDriver driver;
    private  final String correctUsername="binay.poudel@webpoint.io";
    private final String correctPassword="Webpoint@2024";
    private LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://cms.dev.oneaccord.cc/login");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void correctUsernameAndPassword() throws InterruptedException {
        loginPage.logins(correctUsername,correctPassword);
        String dashboardText= driver.findElement(loginPage.dashboardTextLocator).getText();
        System.out.println(dashboardText);
        Assertions.assertEquals("Dashboard /",dashboardText);
    }
    @Test
    public void correctUsernameAndEmptyPassword() throws InterruptedException {
        loginPage.logins(correctUsername,"");
        String passwordRequiredText= driver.findElement(loginPage.passwordRequiredLocator).getText();
        System.out.println(passwordRequiredText);
        Assertions.assertEquals("Password is required.",passwordRequiredText);
    }
    @Test
    public void emptyUsernameAndEmptyPassword() throws InterruptedException {
        loginPage.logins("","");
        String emailRequiredText= driver.findElement(loginPage.emailRequiredLocator).getText();
        System.out.println(emailRequiredText);
        Assertions.assertEquals("Email address is not valid.",emailRequiredText);
    }
    @Test
    public void validUsernameAndInvalidPassword() throws InterruptedException {
        loginPage.logins(correctUsername,"webPoint123");
        Thread.sleep(2000);
        String emailAndPasswordNotCorrectText= driver.findElement(loginPage.emailAndPasswordnotcorrectLocator).getText();
        System.out.println(emailAndPasswordNotCorrectText);
        Assertions.assertEquals("Email or Password is not correct.",emailAndPasswordNotCorrectText);
    }
    @Test
    public void logout() throws InterruptedException {
        loginPage.logins(correctUsername,correctPassword);
        String dashboardText= driver.findElement(loginPage.dashboardTextLocator).getText();
        System.out.println(dashboardText);
        Assertions.assertEquals("Dashboard /",dashboardText);
        driver.findElement(loginPage.logoutIconLocator).click();
        driver.findElement(loginPage.logoutButtonLocator).click();
        String loginText=driver.findElement(loginPage.welcomeBackLocator).getText();
        System.out.println(loginText);
        Assertions.assertEquals("Welcome Back",loginText);

    }

}