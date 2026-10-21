package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        
        // Replace with your test credentials or dummy test account details
        loginPage.login("your-test-email@proton.me", "your-test-password");
        
        // Add an assertion here later to verify successful login (e.g., checking if Inbox element is visible)
    }
}
