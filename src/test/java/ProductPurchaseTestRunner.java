import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPurchaseTestRunner extends Setup {
    @Test(priority = 0)
    public void searchProductByCategory() {
        driver.get("https://envothemes.com/envo-ecommerce");
        ProductPurchase purchase = new ProductPurchase(driver);
        purchase.searchProduct();
    }

    @Test(priority = 1)
    public void selectProductFromCategory() throws InterruptedException {
        ProductPurchase purchase = new ProductPurchase(driver);
        String getText = purchase.selectProduct();
        Assert.assertTrue(getText.contains("Bikini"));
    }

    @Test(priority = 2)
    public void productAddToCart() {
        ProductPurchase purchase = new ProductPurchase(driver);
        String getText = purchase.addCart();
        Assert.assertTrue(getText.contains("1"));
    }

    @Test(priority = 3)
    public void clickViewCartBtn() throws InterruptedException {
        ProductPurchase purchase = new ProductPurchase(driver);
        String getText = purchase.viewCart();
        Assert.assertTrue(getText.contains("Cart"));
    }

    @Test(priority = 4)
    public void applyWrongCouponCode() throws InterruptedException {
        ProductPurchase purchase = new ProductPurchase(driver);
        String getText = purchase.wrongCoupon();
        Assert.assertTrue(getText.contains("does not exist!"));
    }

    @Test(priority = 5, enabled = false)
    public void clickCheckOutBtn() {
        ProductPurchase purchase = new ProductPurchase(driver);
        String getText = purchase.checkOut();
        Assert.assertTrue(getText.contains("Checkout"));
    }

}
