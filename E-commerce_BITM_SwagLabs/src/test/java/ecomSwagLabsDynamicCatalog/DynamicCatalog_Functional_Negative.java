package ecomSwagLabsDynamicCatalog;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.DynamicCatalogPage;
import Pom_utilities.HomePage;

public class DynamicCatalog_Functional_Negative extends BaseClass {

    // Test verifies that slider navigation dots are unique and usable.
    @Test(groups = "functional")
    public void sliderDuplicateDotsTest() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getMenubar();

        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getSlider();

        dp.verifySliderDots();
    }
}
