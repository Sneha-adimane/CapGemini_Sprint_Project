package ecomSwagLabsCart;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.CartPage;
import Pom_utilities.HomePage;

public class Cart_Functional extends BaseClass {

    // TC01: Verify that the product added to the cart is displayed on the cart page
    @Test(groups = {"functional"})
    public void verifyProductInCartTest() throws Exception {
        login();
        HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.getCart();
        CartPage c = new CartPage(d);
        c.getCarttitle();
    }

    // TC02: Verify that the products added to the cart are displayed correctly on the cart page
    @Test(groups = {"functional"})
	   public void ProductsInCartPage() throws Exception {
		   login();
		   HomePage h = new HomePage(d);
		   h.getAddItemToCart();
	       h.getCart();
		   CartPage c = new CartPage(d);
		   c.verifyProductsInCart();
	   }

    // TC03: Verify that clicking the Continue Shopping button navigates back to the home page
    @Test(groups = {"functional"})
    public void continueShoppingTest() throws Exception {
        login();
        HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.getCart();
        CartPage c = new CartPage(d);
        c.getContinueShopping();
        h.getTitle();
    }

    // TC04: Verify that a product can be removed from the cart successfully
    @Test(groups = {"functional"})
    public void removeTest() throws Exception {
    login();
    HomePage h = new HomePage(d);
    h.getAddItemToCart();
    h.getCart();
    CartPage c = new CartPage(d);
    c.getRemovebtn();
    c.verifyProductRemoved();
    }

    // TC05: Verify that clicking the Checkout button initiates the checkout process
    @Test(groups = {"functional"})
    public void verifyCheckoutbtnTest() throws Exception {
    	login();
    	HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.getCart();
        CartPage c = new CartPage(d);
        c.getCheckoutbtn();
    }

}