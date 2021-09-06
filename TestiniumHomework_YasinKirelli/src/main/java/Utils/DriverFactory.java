package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    public static String browserName= utils.Config.BROWSER;
    private static String driverLocation="src/main/resources/drivers/";

    public DriverFactory(){
        this.driver=getDriver();
    }

    public static WebDriver createDriver() {
        DesiredCapabilities capabilities;
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-cache");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        else {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getDriver () {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public static void closeDriver () {
        driver.close();
        driver.quit();
    }

}