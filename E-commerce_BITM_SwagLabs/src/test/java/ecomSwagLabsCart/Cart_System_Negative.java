package ecomSwagLabsCart;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import Pom_utilities.CartPage;
import genric_utilities.ScreenshotUtility;

public class Cart_System_Negative extends BaseClass {

    // SYS01: Verify that the cart cannot be accessed after logout.
    @Test(groups = {"system"})
    public void cartAccessAfterLogoutTest() throws Exception {

        login();
        logout();

        HomePage h = new HomePage(d);
        h.verifyCartRequiresLogin();

        ScreenshotUtility.takeScreenshot(d, "Cart_AfterLogout");
    }

    // SYS02: Verify that a removed product remains absent after refresh.
    @Test(groups = {"system"})
    public void removedProductAfterRefreshTest() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.getCart();

        CartPage c = new CartPage(d);
        c.getRemovebtn();
        c.verifyProductRemoved();
        c.refreshAndVerifyCartEmpty();
    }
}
