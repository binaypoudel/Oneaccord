package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    private WebDriver driver;

    public DriverFactory(){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream("config.properties")) {
            properties.load(resourceStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setBrowser(properties.getProperty("browserName"));
        driver.get(properties.getProperty("baseUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){
        return driver;
    }

    private WebDriver setBrowser(String browserName){
        switch (browserName) {
            case "chrome" :
                ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--disable-geolocation");

                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox" :
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--disable-geolocation");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge" :
                EdgeOptions edgeOptions = new EdgeOptions();
                //edgeOptions.addArguments("--headless");
                //edgeOptions.addArguments("--disable-geolocation");
                driver = new EdgeDriver();
                break;
            case null, default : System.out.println("Invalid Browser");
        }
        return driver;
    }
}
