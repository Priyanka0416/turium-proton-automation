package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ComposePage;
import java.time.Duration;

public class MailActionsTests extends BaseTest {

    @Test
    public void testComposeAndSendEmail() {
        // Step 1: Log in to Proton Mail
        LoginPage loginPage = new LoginPage(driver);
        // Replace with your actual test account credentials
        loginPage.login("priyankachitturi@proton.me", "Test@123");

        // Step 2: Compose a new message
        ComposePage composePage = new ComposePage(driver);
        
        // Wait until the inbox/dashboard loads fully after login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        // Click "New message" button
        composePage.clickNewMessage();

        // Fill out email details
        composePage.enterRecipient("pisseylauri@proton.me");
        composePage.enterSubject("Turium AI Automation Assessment");
        composePage.enterBody("Hello, this is an automated test execution verifying message composition and sending.");

        // Click Send
        composePage.clickSend();

        // Step 3: Verify the "Undo" or "Message sent" toast notification (Dynamic Synchronization)
        WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[contains(text(), 'Message sent')] | //button[text()='Undo']")
        ));
        
        Assert.assertTrue(successToast.isDisplayed(), "Failure: 'Message sent' confirmation toast did not appear!");
    }
}