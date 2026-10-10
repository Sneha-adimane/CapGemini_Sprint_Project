package ecomSwagLabsDynamicCatalog;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import Pom_utilities.DynamicCatalogPage;

public class DynamicCatalog_Smoke_Negative extends BaseClass {

    // Test verifies that the spinner page does not display more than six product cards.
    @Test(groups = "smoke")
    public void spinnerDuplicateProductsTest() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getMenubar();

        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getSpinner();

        dp.verifySpinnerProductLimit();
    }
}
