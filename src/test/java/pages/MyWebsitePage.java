package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyWebsitePage {
    final  WebDriver driver;
    public  By helpButtonLocator=By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]");
    public  By learnMoreLocator=By.xpath("//body/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/a[1]");
    public  By viewLiveSiteLocator=By.xpath("//body/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/a[2]");
    public  By domainLocator=By.xpath("//body/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]");
    public  By configureDomainLocator=By.xpath("//body/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/button[1]");
    public  By domainSetupLocator=By.xpath("//button[contains(text(),'Domain Setup')]");
    public  By editContentLocator=By.xpath("//body/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/button[1]");
    public  By pagesLocator=By.xpath("//h3[contains(text(),'Pages')]");







    public MyWebsitePage(WebDriver driver){
        this.driver=driver;
    }

}




