package ecomSwagLabsCheckout;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import Pom_utilities.CartPage;
import Pom_utilities.checkoutPage;

public class Checkout_Smoke_Negative extends BaseClass {

    // TC01: Verify that checkout rejects empty information fields, displays the required first-name validation message, and prevents navigation to the next checkout page.
    @Test(groups = {"smoke"})
    public void checkoutMustRejectEmptyInformation() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.getCart();

        CartPage c = new CartPage(d);
        c.getCheckoutbtn();

        checkoutPage cop = new checkoutPage(d);

        // Submit with all fields empty
        cop.getContinuebtn();

        // Verify validation and prevent progression
        cop.verifyFirstNameRequired();
        cop.verifyCheckoutInformationPage();
    }
}