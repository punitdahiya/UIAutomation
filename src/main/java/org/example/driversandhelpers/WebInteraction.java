package org.example.driversandhelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WebInteraction extends Driver{
    public static WebElement waitForElementToBeVisible(int timeout, int pollintInterval, By locator, String elementName){
        System.out.println(String.format("Waiting for %s element",elementName));
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofMillis(timeout));
        wait.pollingEvery(Duration.ofMillis(pollintInterval));
        wait.ignoring(NoSuchElementException.class);
        return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeVisible(By locator, String elementName){
        return waitForElementToBeVisible(5000, 250, locator, elementName);
    }

    public static String getTitleOfPage(){
        return driver.getTitle();
    }

    public static String getURLOfPage(){
        return driver.getCurrentUrl();
    }
}
