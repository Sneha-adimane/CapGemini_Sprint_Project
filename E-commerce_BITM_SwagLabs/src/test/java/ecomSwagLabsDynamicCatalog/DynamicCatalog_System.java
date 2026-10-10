package ecomSwagLabsDynamicCatalog;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.DynamicCatalogPage;
import Pom_utilities.HomePage;

public class DynamicCatalog_System extends BaseClass {

    // TC01: Verify the complete Dynamic Catalog workflow by navigating through Lazy Load, Spinner, Slider, and All Items pages, verifying the Home page, and logging out successfully.
    @Test(groups = {"system"})
    public void completeDynamicCatalogFlow() throws Exception {
    	login();
        HomePage h = new HomePage(d);
        h.getMenubar();
        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getLazyLoad();
        h.getMenubar();
        dp.getDynamicCatalog();
        dp.getSpinner();
        h.getMenubar();
        dp.getDynamicCatalog();
        dp.getSlider();
        h.getMenubar();
        dp.getallItems();
        h.getTitle();
        logout();
    }
}