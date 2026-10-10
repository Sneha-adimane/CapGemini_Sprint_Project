package ecomSwagLabsCart;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import genric_utilities.ScreenshotUtility;

public class Cart_Smoke_Negative extends BaseClass {

    // Test verifies that the cart cannot be accessed without login.
    @Test(groups = "smoke")
    public void verifyCartWithoutLogin() throws Exception {

        HomePage h = new HomePage(d);
        h.verifyCartRequiresLogin();

        ScreenshotUtility.takeScreenshot(d, "Cart_WithoutLogin");
    }
}
