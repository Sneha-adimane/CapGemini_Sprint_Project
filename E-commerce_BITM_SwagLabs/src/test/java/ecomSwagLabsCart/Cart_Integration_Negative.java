package ecomSwagLabsCart;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import Pom_utilities.CartPage;
import Pom_utilities.checkoutPage;
import Pom_utilities.OverviewPage;

public class Cart_Integration_Negative extends BaseClass {

    // Test verifies that a removed product does not reappear during checkout.
    @Test(groups = {"integration"})
    public void removedProductNotInCheckoutTest() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.getCart();

        CartPage c = new CartPage(d);
        String productName = c.getProductName();

        c.getRemovebtn();
        c.verifyProductRemoved();
        c.getCheckoutbtn();

        checkoutPage cop = new checkoutPage(d);
        cop.getFn("Test");
        cop.getLn("User");
        cop.getPCode("560001");
        cop.getContinuebtn();

        OverviewPage op = new OverviewPage(d);
        op.verifyRemovedProductNotInOverview(productName);
    }
}
