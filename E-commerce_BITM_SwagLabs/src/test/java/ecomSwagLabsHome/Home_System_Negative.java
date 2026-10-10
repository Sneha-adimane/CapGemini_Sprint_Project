package ecomSwagLabsHome;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import genric_utilities.ScreenshotUtility;

public class Home_System_Negative extends BaseClass {

    // Test verifies that inventory cannot be accessed without login.
    @Test(groups = {"system"})
    public void verifyHomeWithoutLogin() {
        HomePage h = new HomePage(d);
        h.verifyInventoryRequiresLogin();
    }

    // Test verifies that inventory cannot be accessed after logout.
    @Test(groups = {"system"})
    public void verifyHomeAfterLogout() throws Exception {

        login();
        logout();

        HomePage h = new HomePage(d);
        h.verifyInventoryAfterLogout();

        ScreenshotUtility.takeScreenshot(d, "InventoryAccess_AfterLogout");
    }
}
