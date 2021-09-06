package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.Config;
import Utils.DriverFactory;

public class TestiniumScenarios {

    public LoginPage loginPage;
    public HomePage homePage;
    public SearchResultsPage searchResultsPage = new SearchResultsPage();

    @BeforeTest(alwaysRun = true)
    public void setUp(){
        WebDriver driver=DriverFactory.getDriver();
        String baseUrl =Config.URL;
        driver.get(baseUrl);
    }

    @Test
    public void Login() {
        loginPage= new LoginPage();
        homePage= loginPage.login(Config.USERNAME,Config.PASSWORD);
        Assert.assertEquals(Config.USERNAME,homePage.returnUserTag());
    }

    @Test
    public void SearchAndSelectRandomProductAndCheckPrice() throws Exception {
        searchResultsPage.GoHomePage();
        searchResultsPage.waitSeconds(1);
        searchResultsPage.writeAndEnter(searchResultsPage.searchElement,Config.SEARCHKEY);
        searchResultsPage.waitSeconds(2);
        searchResultsPage.scrollDown();
        searchResultsPage.waitSeconds(1);
        searchResultsPage.ClickSecondPage();
        searchResultsPage.waitSeconds(1);
        searchResultsPage.randomSelectProduct();
        searchResultsPage.waitSeconds(5);
        searchResultsPage.scrollDown();
        //Fiyat bilgisi dosyaya yazılır
        searchResultsPage.WritePriceToFile(searchResultsPage.getproductPrice());
        searchResultsPage.AddtoBasket();
        searchResultsPage.waitSeconds(3);
        searchResultsPage.GoToBasketPage();
        searchResultsPage.waitSeconds(4);
        //Dosyadan Fiyat Kontrol Edilir.
        Assert.assertEquals(searchResultsPage.ReadPriceFromFile(), searchResultsPage.getproductPrice()) ;
    }

    @Test
    public void CheckProductAmountIsSame() throws Exception {
        searchResultsPage.goBackPage();
        searchResultsPage.scrollDown();
        // Ürün sayısı artırılır.
        searchResultsPage.AddtoBasket();
        searchResultsPage.waitSeconds(3);
        searchResultsPage.GoToBasketPage();
        //Ürün sayısı kontrol edilir.
        Assert.assertEquals(Config.PRODUCTCOUNT,searchResultsPage.getProductAmountValue());
    }

    @Test
    public void CheckEmptyCardMessage() throws Exception {
        searchResultsPage.waitSeconds(2);
        searchResultsPage.DeleteProduct();
        searchResultsPage.waitSeconds(2);
        // Sepetin boş olduğu kontrol edilir.
        Assert.assertEquals(Config.EMPTYMESSAGE,searchResultsPage.getEmptyCardMessageElementValue());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        DriverFactory.closeDriver();
    }

}
