package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

public class LoginPage {
    private WebDriver driver;
    private WaitHelper waitHelper;

    // Locators using @FindBy
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        waitHelper.waitForVisible(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitHelper.waitForVisible(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        waitHelper.waitForClickable(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
