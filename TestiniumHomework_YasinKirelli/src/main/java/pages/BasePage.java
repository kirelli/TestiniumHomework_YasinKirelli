package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import Utils.DriverFactory;
import java.time.Duration;
import java.util.Random;

public class BasePage {

    public WebDriver driver = DriverFactory.getDriver();

    protected Wait<WebDriver> waitfor = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.out.println(element.getText() + " couldnt click");
        }
    }

    public void write(WebElement element, String text) {
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println(element.getText() + " couldnt send value to element");
        }
    }

    public void writeAndEnter(WebElement element, String text) {
        try {
            element.sendKeys(text, Keys.ENTER);
        } catch (Exception e) {
            System.out.println(element.getText() + " couldnt send value");
        }
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public void randomSelectProduct() {
        waitSeconds(2);
        Random rand = new Random();
        int r = rand.nextInt(4);
        System.out.println(r);
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[2]/div[3]/ul/li[" + r + "]/article/div/a/div/div[1]/div/div[3]/div/img")).click();
    }

    public void waitForPageLoad (By by){
        waitfor.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitElementToClickable (By by){
        try {
            waitfor.until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
            System.out.println(e);
        }
    }

    public void waitSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickWithEnter (WebElement element){
        try {
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
        }
    }

    public void clickWithById (By by){
        try {
            WebElement element = driver.findElement(by);
            element.click();
        } catch (Exception e) {
            System.out.println(" couldnt click this element ");
        }
    }

    public boolean isElementPresent (By locatorKey){
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void goBackPage()
    {
        driver.navigate().back();
    }

    public void scrollDown()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4000)");
    }

}