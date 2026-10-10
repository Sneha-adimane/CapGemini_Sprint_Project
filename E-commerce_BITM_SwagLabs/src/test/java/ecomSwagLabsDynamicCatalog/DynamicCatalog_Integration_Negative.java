package ecomSwagLabsDynamicCatalog;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import Pom_utilities.DynamicCatalogPage;

public class DynamicCatalog_Integration_Negative extends BaseClass {

    // Test verifies that slider elements disappear when navigating to All Items.
    @Test(groups = "integration")
    public void sliderProductsNotRemainInAllItemsTest() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getMenubar();

        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getSlider();

        dp.verifySliderProducts();

        h.getMenubar();
        dp.getallItems();

        dp.verifyAllItemsWithoutSliderDots();
    }
}
