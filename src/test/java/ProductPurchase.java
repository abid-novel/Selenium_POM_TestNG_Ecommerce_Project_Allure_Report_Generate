import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPurchase {
    WebDriver driver;

    @FindBy(name = "product_cat")
    WebElement dropDownCategory;
    @FindBy(className = "fa-search")
    WebElement iconSearch;
    @FindBy(css = "img")
    List <WebElement> imgProduct;
    @FindBy(xpath = "//h1[contains(text(),'Bikini')]")
    WebElement lblProduct;
    @FindBy(name = "add-to-cart")
    WebElement btnAddCart;
    @FindBy(className = "fa-shopping-bag")
    List <WebElement> iconCart;
    @FindBy(xpath = "//a[contains(text(), 'View cart')]")
    List <WebElement> btnViewCart;
    @FindBy(className = "single-title")
    WebElement lblViewCart;
    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    WebElement btnCheckOut;
    @FindBy(className = "single-title")
    WebElement lblCheckOut;
    @FindBy(id = "coupon_code")
    WebElement txtFieldCouponCode;
    @FindBy(className = "button")
    List <WebElement> btnApplyCode;
    @FindBy(className = "woocommerce-error")
    WebElement lblWrongCoupon;

    public ProductPurchase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct() {
        Select select = new Select(dropDownCategory);
        select.selectByIndex(4);
        iconSearch.click();
    }

    public String selectProduct() throws InterruptedException {
        imgProduct.get(3).click();
        Thread.sleep(3000);
        return lblProduct.getText();
    }

    public String addCart() {
        btnAddCart.click();
        return iconCart.get(0).getText();
    }

    public String viewCart() throws InterruptedException {
        Thread.sleep(3000);
        btnViewCart.get(2).click();
        Thread.sleep(2000);
        return lblViewCart.getText();
    }

    public String checkOut() {
        btnCheckOut.click();
        return lblCheckOut.getText();
    }

    public String wrongCoupon() throws InterruptedException {
        Select select = new Select(dropDownCategory);
        select.selectByIndex(4);
        iconSearch.click();
        imgProduct.get(3).click();
        btnAddCart.click();
        Thread.sleep(3000);
        btnViewCart.get(2).click();
        txtFieldCouponCode.sendKeys("xyz");
        btnApplyCode.get(0).click();
        Thread.sleep(3000);
        return lblWrongCoupon.getText();
    }
}

