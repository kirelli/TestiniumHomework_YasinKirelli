package Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtils {

    public static void enterText(WebElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public static void waitForElement() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
