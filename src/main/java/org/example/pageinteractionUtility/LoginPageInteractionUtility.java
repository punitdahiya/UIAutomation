package org.example.pageinteractionUtility;

import org.example.driversandhelpers.WebInteraction;
import org.example.pageinteractioninterface.LoginPageInteraction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageInteractionUtility implements LoginPageInteraction {
    public WebElement enterUserName(String userName){
        By by = By.xpath("//input[@id='user-name']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "username");
        webElement.sendKeys(userName);
        return webElement;
    }
    public WebElement enterPassword(String password){
        By by = By.xpath("//input[@id='password']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "password");
        webElement.sendKeys(password);
        return webElement;
    }
    public WebElement clickOnLoginButton(){
        By by = By.xpath("//input[@id='login-button']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "login button");
        webElement.click();
        return webElement;
    }

    public String getTitleOfPage(){
        return WebInteraction.getTitleOfPage();
    }

    public String getURLOfPage(){
        return WebInteraction.getURLOfPage();
    }

    public WebElement getErrorMessage(){
        By by = By.xpath("//h3[@data-test='error']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "login button");
        webElement.click();
        return webElement;
    }
}
