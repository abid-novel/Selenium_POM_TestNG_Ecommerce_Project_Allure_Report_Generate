import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopTestRunner extends Setup {

    @Test
    public void clickShopTab() {
        driver.get("https://envothemes.com/envo-ecommerce");
        Shop shop = new Shop(driver);
        String getText = shop.shopTab();
        Assert.assertTrue(getText.contains("SHOP"));
    }

    @Test
    public void productSearchByName() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        Shop shop = new Shop(driver);
        String getText = shop.searchProduct();
        Assert.assertTrue(getText.contains("Hard top"));
    }

    @Test
    public void productSearchByWrongName() {
        driver.get("https://envothemes.com/envo-ecommerce");
        Shop shop = new Shop(driver);
        String getText = shop.searchWrongProduct();
        Assert.assertTrue(getText.contains("No products were found matching your selection."));
    }

    @Test
    public void sortProductByPriceLowToHigh() {
        driver.get("https://envothemes.com/envo-ecommerce");
        Shop shop = new Shop(driver);
        String getText = shop.sortLowToHigh();
        Assert.assertTrue(getText.contains("Black trousers"));
    }

    @Test
    public void sortProductByPriceHighToLow() {
        driver.get("https://envothemes.com/envo-ecommerce");
        Shop shop = new Shop(driver);
        String getText = shop.sortHighToLow();
        Assert.assertTrue(getText.contains("Black pants"));
    }

    @Test
    public void filterProductByColor() {
        driver.get("https://envothemes.com/envo-ecommerce");
        Shop shop = new Shop(driver);
        String getText = shop.colorSort();
        Assert.assertTrue(getText.contains("Polo T-shirt"));
    }


}
