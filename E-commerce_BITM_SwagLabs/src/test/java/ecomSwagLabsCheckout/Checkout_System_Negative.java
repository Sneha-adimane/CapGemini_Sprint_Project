package ecomSwagLabsCheckout;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import Pom_utilities.CartPage;
import Pom_utilities.checkoutPage;

public class Checkout_System_Negative extends BaseClass {

    // Test verifies that an incomplete order is rejected when Last Name is missing.
    @Test(groups = {"system"})
    public void incompleteOrderMustNotComplete() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.getCart();

        CartPage c = new CartPage(d);
        c.getCheckoutbtn();

        checkoutPage cop = new checkoutPage(d);

        // Enter only First Name; leave other fields empty
        cop.getFn("TestUser");
        cop.getContinuebtn();

        cop.verifyLastNameRequired();
        cop.verifyOrderNotCompleted();
    }
}
