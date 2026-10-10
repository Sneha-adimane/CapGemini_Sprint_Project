package ecomSwagLabsCart;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.CartPage;
import Pom_utilities.HomePage;
import Pom_utilities.checkoutPage;
import genric_utilities.ScreenshotUtility;

public class Cart_Functional_Negative extends BaseClass {

    // FN01: Verify that a removed product disappears from the cart.
    @Test(groups = {"functional"})
    public void removeProductTest() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.getCart();

        CartPage c = new CartPage(d);
        c.getRemovebtn();
        c.verifyProductRemoved();
    }

    // FN02: Verify checkout behavior when the cart is empty.
    @Test(groups = {"functional"})
    public void emptyCartCheckoutTest() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getCart();

        CartPage c = new CartPage(d);
        c.verifyCartEmpty();
        c.getCheckoutbtn();

        checkoutPage cop = new checkoutPage(d);
        cop.verifyCheckoutInformationPage();

        ScreenshotUtility.takeScreenshot(d, "EmptyCart_Checkout");
    }
}
