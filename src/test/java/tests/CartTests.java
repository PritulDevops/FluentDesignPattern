package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.DriverManager;
import pages.CartPage;
import pages.FilterSideBar;
import pages.Homepage;
import pages.ProductDetailPage;

public class CartTests extends BaseTest {

    @Test
	public void ValidateCartPage() {
	Homepage homepage = new Homepage(DriverManager.getDriver());
    FilterSideBar filterBar = homepage.getFilterBar();
    filterBar.selectFilterCategory("Hammer");
    ProductDetailPage ProductDetailPage = homepage.selectProduct(1);
    ProductDetailPage.increaseProductQty(2);
    ProductDetailPage.addToCart();
    CartPage cartpage = ProductDetailPage.goToCart();
    Assert.assertTrue(cartpage.isProceedPresent());
    
    }
}
