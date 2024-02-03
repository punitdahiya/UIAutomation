package org.example.pageinteractionUtility;

import org.example.driversandhelpers.WebInteraction;
import org.example.pageinteractioninterface.InventoryDashboardInteraction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InventoryDashboardInteractionUtility implements InventoryDashboardInteraction {

    public WebElement getProductTitleFromDashboard(int product_index){
        By by = By.xpath(String.format("(//div[@id='inventory_container']//a[contains(@id, 'title_link')]/div[@class='inventory_item_name '])[%s]", product_index));
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, String.format("%s product title", product_index));
        return webElement;
    }

    public WebElement clickOnAddToCartButton(int product_index){
        By by = By.xpath(String.format("(//button[contains(@id,'add-to-cart')])[%s]", product_index));
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "cart button");
        webElement.click();
        return webElement;
    }

    public WebElement getRemoveButton(int product_index){
        By by = By.xpath(String.format("(//button[contains(@id,'remove') and text()='Remove'])[%s]", product_index));
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "remove from cart button");
        return webElement;
    }

    public WebElement clickOnCartButton(){
        By by = By.xpath("//div[@id='shopping_cart_container']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "go to cart button");
        webElement.click();
        return webElement;
    }

    public WebElement getPageHeader(){
        By by = By.xpath("//div[@id='header_container']/div[@class='header_secondary_container']/span[@class='title']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "page header");
        return webElement;
    }

    public WebElement getProductTitleFromYourCartScreen(int product_index){
        By by = By.xpath(String.format("(//div[@id='cart_contents_container']//a[contains(@id,'title_link')]/div[@class='inventory_item_name'])[%s]", product_index));
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "product title");
        return webElement;
    }

    public WebElement clickOnCheckoutButton(){
        By by = By.xpath("//button[@id='checkout']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "checkout button");
        webElement.click();
        return webElement;
    }

    public WebElement enterFirstName(String firstName){
        By by = By.xpath("//input[@id='first-name']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "first name text box");
        webElement.sendKeys(firstName);
        return webElement;
    }

    public WebElement enterLastName(String lastName){
        By by = By.xpath("//input[@id='last-name']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "last name text box");
        webElement.sendKeys(lastName);
        return webElement;
    }

    public WebElement enterZipCode(String zipCode){
        By by = By.xpath("//input[@id='postal-code']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "zip code text box");
        webElement.sendKeys(zipCode);
        return webElement;
    }

    public WebElement clickOnContinueButton(){
        By by = By.xpath("//input[@id='continue']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "continue button");
        webElement.click();
        return webElement;
    }

    public WebElement getProductTitleFromCheckoutOverviewScreen(int product_index){
        By by = By.xpath(String.format("(//div[@id='checkout_summary_container']//a[contains(@id,'title_link')]/div[@class='inventory_item_name'])[%s]", product_index));
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "product title");
        return webElement;
    }

    public WebElement clickOnFinishButton(){
        By by = By.xpath("//button[@id='finish']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "finish button");
        webElement.click();
        return webElement;
    }

    public WebElement getPaymentInformation(){
        By by = By.xpath("(//div[@id='checkout_summary_container']//div[@class='summary_info']/div[@class='summary_info_label' and text()='Payment Information']/following-sibling::div[@class='summary_value_label'])[1]");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "payment information");
        return webElement;
    }

    public WebElement getShippingInformation(){
        By by = By.xpath("(//div[@id='checkout_summary_container']//div[@class='summary_info']/div[@class='summary_info_label' and text()='Shipping Information']/following-sibling::div[@class='summary_value_label'])[1]");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "shipping information");
        return webElement;
    }

    public WebElement getOrderSuccessMessage(){
        By by = By.xpath("//div[@id='checkout_complete_container']/h2[@class='complete-header']");
        WebElement webElement = WebInteraction.waitForElementToBeVisible(by, "shipping information");
        return webElement;
    }
}
