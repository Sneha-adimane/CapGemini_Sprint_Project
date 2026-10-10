package ecomSwagLabsCheckout;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import Pom_utilities.CartPage;
import Pom_utilities.checkoutPage;
import genric_utilities.ScreenshotUtility;

public class Checkout_Integration_Negative extends BaseClass {

    // Negative Test 1: Checkout validation must block Overview
    @Test(groups = {"integration"})
    public void invalidCheckoutMustNotOpenOverview() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.getCart();

        CartPage c = new CartPage(d);
        c.getCheckoutbtn();

        checkoutPage cop = new checkoutPage(d);

        // Submit without entering customer information
        cop.getContinuebtn();

        // Verify validation and ensure Overview is not opened
        cop.verifyFirstNameRequired();
        cop.verifyCheckoutInformationPage();

        ScreenshotUtility.takeScreenshot(d, "Checkout_RequiredFields");
    }
}
