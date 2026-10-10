package ecomSwagLabsHome;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import Pom_utilities.CartPage;
import genric_utilities.ScreenshotUtility;

public class Home_Integration_Negative extends BaseClass {

    // Test verifies that the cart remains empty when no product is added.
    @Test(groups = {"integration"})
    public void verifyCartWithoutAddingProduct() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.verifyCartBadgeNotDisplayed();
        h.getCart();

        CartPage c = new CartPage(d);
        c.verifyProductRemoved();

        ScreenshotUtility.takeScreenshot(d, "Cart_Empty");

        logout();
    }

    // Test verifies that removing a product updates the inventory and cart.
    @Test(groups = {"integration"})
    public void verifyProductRemovalIntegration() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.removeProductFromInventory();
        h.verifyRemoveButtonNotDisplayed();

        h.getCart();

        CartPage c = new CartPage(d);
        c.verifyProductRemoved();

        ScreenshotUtility.takeScreenshot(d, "Product_Removed");

        logout();
    }
}
