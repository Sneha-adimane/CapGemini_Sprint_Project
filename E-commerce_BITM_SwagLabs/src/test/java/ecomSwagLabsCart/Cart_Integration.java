package ecomSwagLabsCart;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.CartPage;
import Pom_utilities.DynamicCatalogPage;
import Pom_utilities.HomePage;

public class Cart_Integration extends BaseClass {


	// TC01: Verify that the product name on the Home Page matches the product name displayed in the Cart
	@Test(groups = {"integration"})
	public void ProductInCart() throws Exception {
		login();
	    HomePage h = new HomePage(d);
        String homeProduct = h.getHomeProductName();
        h.getAddItemToCart();
	    h.getCart();
        CartPage c = new CartPage(d);
	    String cartProduct = c.getProductName();
	    Assert.assertEquals(cartProduct,homeProduct,"Home Page product and Cart product are different");
	    Reporter.log("Both product names are same", true);
    }

    // TC02: Verify navigation from the Cart back to the Home Page using the Continue Shopping button
    @Test(groups = {"integration"})
    public void cartToProductTest() throws Exception {
        login();
        HomePage h = new HomePage(d);
        h.getAddItemToCart();;
        h.getCart();
        CartPage cp = new CartPage(d);
        cp.getContinueShopping();;
        h.getTitle();
        logout();
    }

    // TC03: Verify integration between the Cart and the All Items page through the menu
    @Test(groups = {"integration"})
    public void addProductToAllItem() throws Exception
    {
    	login();
        HomePage h = new HomePage(d);
        h.getAddItemToCart();;
        h.getCart();
        CartPage cp = new CartPage(d);
        cp.verifyProductsInCart();
        h.getMenubar();
        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getallItems();
        h.getTitle();
    }

    // TC04: Verify navigation between the Cart and the Dynamic Catalog pages, including Lazy Load, Spinner, and Slider
    @Test(groups = {"integration"})
    public void addproductToDynamicCatalog() throws Exception{
    	login();
        HomePage h = new HomePage(d);
        h.getAddItemToCart();;
        h.getCart();
        CartPage cp = new CartPage(d);
        cp.verifyProductsInCart();
        h.getMenubar();
        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getLazyLoad();
        h.getMenubar();
        dp.getDynamicCatalog();
        dp.getSpinner();
        h.getMenubar();
        dp.getDynamicCatalog();
        dp.getSlider();
    }
}