package org.example.commonhelpers;

import org.awaitility.Awaitility;
import org.example.pageinteractionUtility.LoginPageInteractionUtility;
import org.junit.Assert;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.example.constants.URL.INVENTORY_PAGE_URL;

public class LoginPageAwaitility {
    public static void waitForUserToLandOnInventoryScreen(LoginPageInteractionUtility loginPageInteractionUtility){
        Awaitility.await()
                .timeout(5, SECONDS)
                .pollDelay(200, MILLISECONDS)
                .untilAsserted(() -> Assert.assertEquals(INVENTORY_PAGE_URL, loginPageInteractionUtility.getURLOfPage()));
    }
}
