package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Sale {
    public WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Sale')]")
    List <WebElement> tabSale;
    @FindBy(css = "img")
    List <WebElement> imgProduct;
    @FindBy(xpath = "//h1[contains(text(),'Bikini')]")
    WebElement lblProduct;

    public Sale(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String saleTab() {
        tabSale.get(1).click();
        return tabSale.get(1).getText();
    }

    public String selectProduct() {
        tabSale.get(1).click();
        imgProduct.get(0).click();
        return lblProduct.getText();
    }
}
