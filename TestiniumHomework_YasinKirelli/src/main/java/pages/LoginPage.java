package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.WebElementUtils.enterText;
import static Utils.WebElementUtils.waitForElement;

public class LoginPage extends BasePage{

    @FindBy (className = "gekhq4-4 egoSnI")
    private WebElement loginHoverButton;

    @FindBy (xpath = "/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a")
    private WebElement loginDirectionButton;

    public void setPassword(WebElement password) {
        this.password = password;
    }

    @FindBy (id = "L-UserNameField")
    private WebElement userName;

    @FindBy(id = "L-PasswordField")
    private WebElement password;

    @FindBy(id = "gg-login-enter" )
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String userNameValue) {
        enterText(userName,userNameValue);
    }

    public void enterPassword( String passwordValue) {
        enterText(password,passwordValue);
    }

    public void clickloginHoverButton() {
        loginHoverButton.click();
    }

    public void clickloginDirectionButton() {
        loginDirectionButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public HomePage login(String userNameValue, String passwordValue) {
        clickloginHoverButton();
        waitForElement();
        clickloginDirectionButton();
        waitForElement();
        enterUserName(userNameValue);
        enterPassword(passwordValue);
        clickLoginButton();
        return new HomePage();
    }

}