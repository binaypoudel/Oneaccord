import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.LoginPage;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginPageTest {

    private WebDriver driver;
    private  final String correctUsername="binay.poudel@webpoint.io";
    private final String correctPassword="Webpoint@2024";
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() throws IOException {
        Properties prop=new Properties();
        File file=new File("src/test/java/config.properties");
        FileInputStream fis=new FileInputStream(file);
        prop.load(fis);
        String browserName=prop.getProperty("browser");

        switch (browserName) {
            case "chrome" : ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox" : FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge" : EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            case null, default : System.out.println("Invalid Browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String linkName=prop.getProperty("linkName");
        driver.get(linkName);
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyCorrectUsernameAndPassword() {
        loginPage.logins(correctUsername,correctPassword);
        String dashboardText= driver.findElement(loginPage.dashboardTextLocator).getText();
        System.out.println(dashboardText);
        Assertions.assertEquals("Dashboard /",dashboardText);
    }
    @Test
    public void correctUsernameAndEmptyPassword()  {
        loginPage.logins(correctUsername,"");
        String passwordRequiredText= driver.findElement(loginPage.passwordRequiredLocator).getText();
        System.out.println(passwordRequiredText);
        Assertions.assertEquals("Password is required.",passwordRequiredText);
    }
    @Test
    public void emptyUsernameAndEmptyPassword()  {
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
    public void logout()  {
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
    @Test
    public void verifyForgotPasswordPage()  {
        driver.findElement(loginPage.forgotPasswordButtonLocator).click();
        String element=driver.findElement(loginPage.forgotPasswordPageTextLocator).getText();
        System.out.println(element);
        Assertions.assertEquals("Forgot Your Password?",element);
    }
    @Test
    public void verifyForgotPasswordRegisteredEmail() throws InterruptedException {
        driver.findElement(loginPage.forgotPasswordButtonLocator).click();
        driver.findElement(loginPage.forgotPasswordEmailFieldLocator).sendKeys("bimala.rai@webpoint.io");
        driver.findElement(loginPage.forgotPasswordSubmitButtonLocator).click();
        Thread.sleep(200);
        String element=driver.findElement(loginPage.forgotPasswordSuccessMessageLocator).getText();
        System.out.println(element);
        Assertions.assertEquals("Successfully sent forget password email",element);
    }
    @Test
    public void verifyForgotPasswordUnregisteredEmail() throws InterruptedException {
        driver.findElement(loginPage.forgotPasswordButtonLocator).click();
        driver.findElement(loginPage.forgotPasswordEmailFieldLocator).sendKeys("webPoint123@gmail.com");
        driver.findElement(loginPage.forgotPasswordSubmitButtonLocator).click();
        Thread.sleep(200);
        String element=driver.findElement(loginPage.forgotPasswordUnsuccessfulMessageLocator).getText();
        System.out.println(element);
        Assertions.assertEquals("Email address not found.",element);
    }
    @Test
    public void verifyForgotPasswordEmptyEmail()  {
        driver.findElement(loginPage.forgotPasswordButtonLocator).click();
        driver.findElement(loginPage.forgotPasswordSubmitButtonLocator).click();
        String element=driver.findElement(loginPage.forgotPasswordEmailNotValidMessageLocator).getText();
        System.out.println(element);
        Assertions.assertEquals("Email address is not valid.",element);
    }
    @Test
    public void verifyForgotPasswordInvalidEmail() {
        driver.findElement(loginPage.forgotPasswordButtonLocator).click();
        driver.findElement(loginPage.forgotPasswordEmailFieldLocator).sendKeys("webPoint123@gmail");
        driver.findElement(loginPage.forgotPasswordSubmitButtonLocator).click();
        String element=driver.findElement(loginPage.forgotPasswordEmailNotValidMessageLocator).getText();
        System.out.println(element);
        Assertions.assertEquals("Email address is not valid.",element);
    }

}