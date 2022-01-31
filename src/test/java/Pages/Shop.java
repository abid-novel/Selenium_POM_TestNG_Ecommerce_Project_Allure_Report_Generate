package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Shop {
    WebDriver driver;

    @FindBy(className = "nav-link")
    List <WebElement> tabShop;
    @FindBy(name = "s")
    List <WebElement> txtSearchBar;
    @FindBy(className = "header-search-button")
    WebElement iconSearch;
    @FindBy(className = "entry-title")
    WebElement lblProduct;
    @FindBy(className = "woocommerce-info")
    WebElement lblWrongProduct;
    @FindBy(className = "orderby")
    WebElement dropDownSort;
    @FindBy(xpath = "//h2[contains(text(),'Black trousers')]")
    WebElement txtProductLowest;
    @FindBy(xpath = "//h2[contains(text(),'Black pants')]")
    WebElement txtProductHighest;
    @FindBy(className = "select2-search__field")
    WebElement inputFilter;
    @FindBy(xpath = "//li[contains(text(), \"Red\")]")
    WebElement inputOptionRed;
    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    WebElement btnFilterApply;
    @FindBy(xpath = "//h2[contains(text(),'Polo T-shirt')]")
    WebElement txtFilter;

    public Shop(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String shopTab() {
        tabShop.get(1).click();
        return tabShop.get(1).getText();
    }

    public String searchProduct() throws InterruptedException {
        tabShop.get(1).click();
        Thread.sleep(3000);
        txtSearchBar.get(0).sendKeys("Hard top");
        iconSearch.click();
        return lblProduct.getText();
    }

    public String searchWrongProduct() {
        tabShop.get(1).click();
        txtSearchBar.get(0).sendKeys("Watch");
        iconSearch.click();
        return lblWrongProduct.getText();
    }

    public String sortLowToHigh() {
        tabShop.get(1).click();
        Select select = new Select(dropDownSort);
        select.selectByValue("price");
        return txtProductLowest.getText();
    }

    public String sortHighToLow() {
        tabShop.get(1).click();
        Select select = new Select(dropDownSort);
        select.selectByValue("price-desc");
        return txtProductHighest.getText();
    }

    public String colorSort() {
        tabShop.get(1).click();
        inputFilter.click();
        inputOptionRed.click();
        btnFilterApply.click();
        return txtFilter.getText();
    }

}
