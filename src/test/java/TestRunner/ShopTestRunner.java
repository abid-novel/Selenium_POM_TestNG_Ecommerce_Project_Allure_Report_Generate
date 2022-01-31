package TestRunner;

import Pages.Shop;
import Setup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopTestRunner extends Setup {

    @Test(description = "Click the shop tab")
    public void clickShopTab() {
        driver.get("https://envothemes.com/envo-ecommerce");
        Shop shop = new Shop(driver);
        String getText = shop.shopTab();
        Assert.assertTrue(getText.contains("SHOP"));
    }

    @Test(description = "Search product by name")
    public void productSearchByName() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        Shop shop = new Shop(driver);
        String getText = shop.searchProduct();
        Assert.assertTrue(getText.contains("Hard top"));
    }

    @Test(description = "Search product by wrong name")
    public void productSearchByWrongName() {
        driver.get("https://envothemes.com/envo-ecommerce");
        Shop shop = new Shop(driver);
        String getText = shop.searchWrongProduct();
        Assert.assertTrue(getText.contains("No products were found matching your selection."));
    }

    @Test(description = "Sort products by price low to high")
    public void sortProductByPriceLowToHigh() {
        driver.get("https://envothemes.com/envo-ecommerce");
        Shop shop = new Shop(driver);
        String getText = shop.sortLowToHigh();
        Assert.assertTrue(getText.contains("Black trousers"));
    }

    @Test(description = "Sort products by price high to low")
    public void sortProductByPriceHighToLow() {
        driver.get("https://envothemes.com/envo-ecommerce");
        Shop shop = new Shop(driver);
        String getText = shop.sortHighToLow();
        Assert.assertTrue(getText.contains("Black pants"));
    }

    @Test(description = "Filter products by color")
    public void filterProductByColor() {
        driver.get("https://envothemes.com/envo-ecommerce");
        Shop shop = new Shop(driver);
        String getText = shop.colorSort();
        Assert.assertTrue(getText.contains("Polo T-shirt"));
    }


}
