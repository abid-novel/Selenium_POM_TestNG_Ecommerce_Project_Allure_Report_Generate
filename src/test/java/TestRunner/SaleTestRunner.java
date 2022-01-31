package TestRunner;

import Pages.Sale;
import Setup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaleTestRunner extends Setup {

    @Test(description = "Click the sale tab")
    public void clickSaleTab() {
        driver.get("https://envothemes.com/envo-ecommerce");
        Sale sale = new Sale(driver);
        String getText = sale.saleTab();
        Assert.assertTrue(getText.contains("SALE"));
    }

    @Test(description = "Select a product from sale tab")
    public void productSelection() {
        driver.get("https://envothemes.com/envo-ecommerce");
        Sale sale = new Sale(driver);
        String getText = sale.selectProduct();
        Assert.assertTrue(getText.contains("Bikini"));
    }
}
