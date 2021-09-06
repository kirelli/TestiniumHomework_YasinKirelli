package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Config;
import java.io.*;

public class SearchResultsPage extends BasePage {

    @FindBy(className = "ssc-4995aq-0 sc-14oyvky-0 gHqOYK")
    public WebElement searchElement;

    @FindBy(className = "sc-12aj18f-0 eIowWe")
    public WebElement secondPage;

    @FindBy(id = "add-to-basket")
    public WebElement addToBasketButton;

    @FindBy(className = "basket-icon-title hidden-m hidden-t")
    public WebElement basketPageButton;

    @FindBy(className = "gg-input gg-input-select")
    public WebElement selectProductAmountValue;

    @FindBy(className = "gg-d-19 gg-w-21 gg-t-19 gg-m-18")
    public WebElement emptyCardMessageElement;

    @FindBy(className = "btn-delete btn-update-item")
    public WebElement deleteProductButton;

    @FindBy(id = "sp-price-highPrice")
    public WebElement productPrice;


    public SearchResultsPage() {
        PageFactory.initElements(driver, this);
    }

    public void GoHomePage() {
        driver.get(Config.URL);
    }

    public void ClickSecondPage() {
        click(secondPage);
    }

    public void AddtoBasket()
    {
        click(addToBasketButton);
    }

    public void GoToBasketPage()
    {
        click(basketPageButton);
    }

    public String getProductAmountValue()
    {
        System.out.println("gelen değer : " + getElementText(selectProductAmountValue));

        return getElementText(selectProductAmountValue);
    }

    public void DeleteProduct()
    {
        click(deleteProductButton);
    }

    public String getEmptyCardMessageElementValue()
    {
        System.out.println("gelen değer : " + getElementText(emptyCardMessageElement));

        return getElementText(emptyCardMessageElement);
    }

    public String getproductPrice()
    {
        return getElementText(productPrice);
    }

    public void WritePriceToFile(String pPrice) throws IOException {
        File file = new File("productPrice.txt");
        if (file.exists()) {
        } else {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(pPrice);
        bWriter.close();
    }

    public String ReadPriceFromFile() throws IOException {

        File file = new File("productprice.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String price = reader.readLine();

        while (price!=null) {
            System.out.println(price);
            price = reader.readLine();
        }
        return price;
    }
}
