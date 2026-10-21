package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

public class ComposePage {
    private WebDriver driver;
    private WaitHelper waitHelper;

    @FindBy(xpath = "//button[contains(text(), 'New message')]")
    private WebElement newButton;

    @FindBy(xpath = "//input[@data-testid='composer-to-input']")
    private WebElement toField;

    @FindBy(xpath = "//input[@data-testid='composer-subject']")
    private WebElement subjectField;

    @FindBy(xpath = "//iframe[@title='Email body']")
    private WebElement messageBodyIframe; // Proton uses an iframe for the rich text editor

    @FindBy(xpath = "//button[@data-testid='composer-send-button']")
    private WebElement sendButton;

    public ComposePage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void clickNewMessage() {
        waitHelper.waitForClickable(newButton).click();
    }

    public void enterRecipient(String recipient) {
        waitHelper.waitForVisible(toField).sendKeys(recipient);
    }

    public void enterSubject(String subject) {
        waitHelper.waitForVisible(subjectField).sendKeys(subject);
    }

    public void enterBody(String body) {
        driver.switchTo().frame(messageBodyIframe);
        WebElement bodyArea = driver.findElement(By.xpath("//body"));
        bodyArea.sendKeys(body);
        driver.switchTo().defaultContent(); // Switch back out of iframe
    }

    public void clickSend() {
        waitHelper.waitForClickable(sendButton).click();
    }
}
