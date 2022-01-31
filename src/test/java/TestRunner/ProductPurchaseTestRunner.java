package TestRunner;

import Pages.ProductPurchase;
import Setup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPurchaseTestRunner extends Setup {
    @Test(priority = 0, description = "Search product by category")
    public void searchProductByCategory() {
        driver.get("https://envothemes.com/envo-ecommerce");
        ProductPurchase purchase = new ProductPurchase(driver);
        purchase.searchProduct();
    }

    @Test(priority = 1, description = "Select a product from category")
    public void selectProductFromCategory() throws InterruptedException {
        ProductPurchase purchase = new ProductPurchase(driver);
        String getText = purchase.selectProduct();
        Assert.assertTrue(getText.contains("Bikini"));
    }

    @Test(priority = 2, description = "Add product to the cart")
    public void productAddToCart() {
        ProductPurchase purchase = new ProductPurchase(driver);
        String getText = purchase.addCart();
        Assert.assertTrue(getText.contains("1"));
    }

    @Test(priority = 3, description = "View the cart")
    public void clickViewCartBtn() throws InterruptedException {
        ProductPurchase purchase = new ProductPurchase(driver);
        String getText = purchase.viewCart();
        Assert.assertTrue(getText.contains("Cart"));
    }

    @Test(priority = 4, description = "Proceed to checkout button click" )
    public void clickCheckOutBtn() {
        ProductPurchase purchase = new ProductPurchase(driver);
        String getText = purchase.checkOut();
        Assert.assertTrue(getText.contains("Checkout"));
    }

    @Test(priority = 5, description = "Apply wrong coupon code")
    public void applyWrongCouponCode() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        ProductPurchase purchase = new ProductPurchase(driver);
        String getText = purchase.wrongCoupon();
        Assert.assertTrue(getText.contains("does not exist!"));
    }

}
