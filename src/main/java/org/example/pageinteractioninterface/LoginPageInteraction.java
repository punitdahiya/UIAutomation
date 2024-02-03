package org.example.pageinteractioninterface;

import org.openqa.selenium.WebElement;

public interface LoginPageInteraction {

    WebElement enterUserName(String userName);
    WebElement enterPassword(String password);
    WebElement clickOnLoginButton();
}
