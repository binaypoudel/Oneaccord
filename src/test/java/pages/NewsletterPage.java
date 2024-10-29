package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewsletterPage {
    final WebDriver driver;
    public By websiteContentButtonLocator = By.xpath("//body/div[1]/aside[1]/div[1]/button[1]");
    public By newsLetterButtonLocator = By.xpath("//a[contains(text(),'Newsletter')]");
    public By newsLetterTextLocator = By.xpath("//h3[contains(text(),'Newsletter')]");






    public NewsletterPage(WebDriver driver) {
        this.driver = driver;
    }
}



