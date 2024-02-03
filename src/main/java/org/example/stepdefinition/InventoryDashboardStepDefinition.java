package org.example.stepdefinition;

import io.cucumber.java.en.*;
import org.example.pageinteractionUtility.InventoryDashboardInteractionUtility;
import org.example.pageinteractionUtility.LoginPageInteractionUtility;
import org.junit.Assert;

import static org.example.stepdefinition.LoginStepDefinition.*;

public class InventoryDashboardStepDefinition {

    InventoryDashboardInteractionUtility inventoryDashboardInteractionUtility = new InventoryDashboardInteractionUtility();
    LoginStepDefinition loginStepDefinition = new LoginStepDefinition();
    private static String productTitle = null;

    @Given("User is on inventory dashboard page {string} {string}")
    public void User_Is_On_Inventory_Dashboard_Page(String userName, String password){
        loginStepDefinition.User_Is_On_Login_Page();
        loginStepDefinition.Enter_Username(userName);
        loginStepDefinition.Enter_Password(password);
        loginStepDefinition.Click_On_Login_Button();
        loginStepDefinition.Ensure_User_Land_On_Dashboard_Page();
    }

    @When("Click on add to cart button of first product")
    public void click_on_add_to_cart_button_of_first_product() {
        int product_index = 1;
        productTitle = inventoryDashboardInteractionUtility.getProductTitleFromDashboard(product_index).getText();
        inventoryDashboardInteractionUtility.clickOnAddToCartButton(product_index);
    }
    @Then("Ensure remove button is present there")
    public void ensure_remove_button_is_present_there() {
        int product_index = 1;
        Assert.assertEquals(productTitle ,inventoryDashboardInteractionUtility.getProductTitleFromDashboard(product_index).getText());
        Assert.assertEquals("Remove", inventoryDashboardInteractionUtility.getRemoveButton(product_index).getText());
    }

    @When("Click on cart button")
    public void click_on_cart_button() {
        inventoryDashboardInteractionUtility.clickOnCartButton();
    }

    @Then("Ensure your cart screen opens")
    public void ensure_your_cart_screen_opens() {
        Assert.assertEquals("Your Cart", inventoryDashboardInteractionUtility.getPageHeader().getText());
    }
    @Then("Ensure that product is present in cart")
    public void ensure_that_product_is_present_in_cart() {
        Assert.assertEquals(productTitle, inventoryDashboardInteractionUtility.getProductTitleFromYourCartScreen(1).getText());
    }

    @When("Click on checkout button")
    public void click_on_checkout_button() {
        inventoryDashboardInteractionUtility.clickOnCheckoutButton();
    }

    @When("Enter first name, last name and Zip code {string} {string} {string}")
    public void enter_first_name_last_name_and_zip_code(String firstName, String lastName, String zipCode) {
        inventoryDashboardInteractionUtility.enterFirstName(firstName);
        inventoryDashboardInteractionUtility.enterLastName(lastName);
        inventoryDashboardInteractionUtility.enterZipCode(zipCode);
    }

    @When("Click on Continue button")
    public void click_on_continue_button() {
        inventoryDashboardInteractionUtility.clickOnContinueButton();
    }

    @Then("Ensure user is on Checkout: Overview page")
    public void ensure_user_is_on_checkout_overview_page() {
        Assert.assertEquals("Checkout: Overview", inventoryDashboardInteractionUtility.getPageHeader().getText());
    }

    @Then("Ensure given product is present on Checkout: Overview page")
    public void ensure_given_product_is_present_on_checkout_overview_page() {
        Assert.assertEquals(productTitle, inventoryDashboardInteractionUtility.getProductTitleFromCheckoutOverviewScreen(1).getText());
    }

    @Then("Ensure following information are present there - Payment Information and Shipping Information")
    public void ensure_following_information_are_present_there_payment_information_shipping_information_and_total() {
        Assert.assertNotEquals("", inventoryDashboardInteractionUtility.getPaymentInformation().getText());
        Assert.assertNotEquals("", inventoryDashboardInteractionUtility.getShippingInformation().getText());
    }

    @When("Click on finish button")
    public void click_on_finish_button() {
        inventoryDashboardInteractionUtility.clickOnFinishButton();
    }

    @Then("Ensure user get order success message")
    public void ensure_user_get_order_success_message() {
        Assert.assertEquals("Thank you for your order!",
                inventoryDashboardInteractionUtility.getOrderSuccessMessage().getText());
    }
}
