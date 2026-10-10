package ecomSwagLabsHome;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import genric_utilities.ScreenshotUtility;

public class Home_Functional_Negative extends BaseClass {

    // Test verifies that the Remove button is not displayed before adding a product.
    @Test(groups = {"functional"})
    public void verifyRemoveButtonState() throws Exception {

        login();
        HomePage h = new HomePage(d);
        h.verifyRemoveButtonBeforeAdding();
        ScreenshotUtility.takeScreenshot(d, "RemoveButton_NotDisplayed");
        logout();
    }

    // Test verifies that products are displayed on the inventory page.
    @Test(groups = {"functional"})
    public void verifyProductsNotMissing() throws Exception {

        login();
        HomePage h = new HomePage(d);
        h.getProducts();
        ScreenshotUtility.takeScreenshot(d, "Products_Displayed");
        logout();
    }
}
