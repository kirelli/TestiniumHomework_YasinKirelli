package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.WebElementUtils.enterText;

public class HomePage extends BasePage{

    @FindBy(className = "search-input")
    private WebElement search;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[1]/div[2]/span")
    private WebElement userScreenTag;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterSearchKey(String searchKey) {
        enterText(search, searchKey);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public String returnUserTag(){
        return userScreenTag.getText();
    }

    public SearchResultsPage searchProfile(String searchKey) throws InterruptedException {
        enterSearchKey(searchKey);
        clickSearchButton();
        return new SearchResultsPage();
    }
}
