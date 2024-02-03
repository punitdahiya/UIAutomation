package org.example.stepdefinition;

import io.cucumber.java.en.*;
import org.example.commonhelpers.LoginPageAwaitility;
import org.example.driversandhelpers.WebInteraction;
import org.example.pageinteractionUtility.LoginPageInteractionUtility;
import org.example.pageinteractioninterface.LoginPageInteraction;
import org.junit.Assert;

import static org.example.constants.URL.*;

public class LoginStepDefinition {
    LoginPageInteractionUtility loginPageInteractionUtility = new LoginPageInteractionUtility();
    @Given("^User is on login page$")
    public void User_Is_On_Login_Page(){
        Assert.assertEquals(loginPageInteractionUtility.getTitleOfPage(), "Swag Labs");
        Assert.assertEquals(loginPageInteractionUtility.getURLOfPage(), LOGIN_PAGE_URL+"/");
    }

    @When("Enter username {string}")
    public void Enter_Username(String userName){
        loginPageInteractionUtility.enterUserName(userName);
    }

    @When("Enter password {string}")
    public void Enter_Password(String password){
        loginPageInteractionUtility.enterPassword(password);
    }

    @When("^Click on login button$")
    public void Click_On_Login_Button(){
        loginPageInteractionUtility.clickOnLoginButton();
    }

    @Then("^Ensure user land on dashboard page$")
    public void Ensure_User_Land_On_Dashboard_Page(){
        LoginPageAwaitility.waitForUserToLandOnInventoryScreen(loginPageInteractionUtility);
        Assert.assertEquals(loginPageInteractionUtility.getURLOfPage(), INVENTORY_PAGE_URL);
    }

    @Then("Ensure user gets error message - {string}")
    public void Ensure_User_Get_Error_Message(String errorMessage){
        Assert.assertEquals(loginPageInteractionUtility.getErrorMessage().getText(), errorMessage);
    }
}
