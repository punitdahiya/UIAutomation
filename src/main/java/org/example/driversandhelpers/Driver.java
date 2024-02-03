package org.example.driversandhelpers;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Driver {
    public static WebDriver driver = null;
    public static WebDriver initializeDriver(String browserName, String URL){
        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else{
            Assert.fail("Given driver is not implemented in code");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
        System.out.println("Opening following url - "+ URL);
        driver.get(URL);
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
    }
}
