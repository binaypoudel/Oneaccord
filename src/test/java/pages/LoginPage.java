package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    final  WebDriver driver;
    public By usernameLocator=By.xpath("//body/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]");
    public  By passwordLocator=By.xpath("//body/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]");
    public  By loginButtonLocator=By.xpath("//button[contains(text(),'Login')]");
    public  By dashboardTextLocator=By.xpath("//header/div[1]/div[1]/span[1]");
    public  By passwordRequiredLocator=By.xpath("//div[contains(text(),'Password is required.')]");
    public  By emailRequiredLocator=By.xpath("//div[contains(text(),'Email address is not valid.')]");
    public  By emailAndPasswordnotcorrectLocator=By.xpath("//div[contains(text(),'Email or Password is not correct.')]");
    public  By logoutIconLocator=By.xpath("//body/div[1]/aside[1]/div[2]/div[1]/button[1]/*[1]");
    public  By logoutButtonLocator=By.xpath("//body/div[3]/div[1]/button[1]");
    public  By welcomeBackLocator=By.xpath("//h2[contains(text(),'Welcome Back')]");
    public  By forgotPasswordPageTextLocator=By.xpath("//h2[contains(text(),'Forgot Your Password?')]");
    public  By forgotPasswordButtonLocator=By.xpath("//body[1]/div[1]/div[1]/form[1]/a[1]/p[1]");
    public  By forgotPasswordEmailFieldLocator=By.xpath("//body/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]");
    public  By forgotPasswordSubmitButtonLocator=By.xpath("//button[contains(text(),'Send Me the Link')]");
    public  By forgotPasswordSuccessMessageLocator=By.xpath("//div[contains(text(),'Successfully sent forget password email')]");
    public  By forgotPasswordUnsuccessfulMessageLocator=By.xpath("//div[contains(text(),'Email address not found.')]");
    public  By forgotPasswordEmailNotValidMessageLocator=By.xpath("//div[contains(text(),'Email address is not valid.')]");







    public LoginPage(WebDriver driver){
        this.driver=driver;
    }


    // Method to perform login
    public void logins(String username, String password) {
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

}




