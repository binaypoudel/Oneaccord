package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PagesPage {
    final WebDriver driver;
    public By websiteContentButtonLocator = By.xpath("//body/div[1]/aside[1]/div[1]/button[1]");
    public By pageButtonLocator = By.xpath("//a[contains(text(),'Pages')]");
    public By pageTextLocator = By.xpath("//h3[contains(text(),'Pages')]");
    public By pageListLocator = By.xpath("//tbody/tr[@class='border-b border-stroke-divider transition-colors hover:bg-muted/50 data-[state=selected]:bg-muted text-b1 text-content-body group']");
    public By pageSearchLocator = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
    public By noResultLocator = By.xpath("//td[contains(text(),'No results.')]");
    public By homePageEditLocator = By.xpath("//tbody/tr[1]/td[5]/button[1]");
    public By aboutPageEditLocator = By.xpath("//tbody/tr[2]/td[5]/button[1]");
    public By planPageEditLocator = By.xpath("//tbody/tr[3]/td[5]/button[1]");
    public By sabbathPageEditLocator = By.xpath("//tbody/tr[4]/td[5]/button[1]");
    public By commonTextLocator = By.xpath("//header/div[1]/div[3]/span[1]");






    public PagesPage(WebDriver driver) {
        this.driver = driver;
    }



}