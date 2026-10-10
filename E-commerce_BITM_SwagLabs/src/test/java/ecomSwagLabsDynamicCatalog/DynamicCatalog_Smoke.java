package ecomSwagLabsDynamicCatalog;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.DynamicCatalogPage;
import Pom_utilities.HomePage;

public class DynamicCatalog_Smoke extends BaseClass {

    // TC01: Verify that the Dynamic Catalog Lazy Load page opens successfully,
    // the All Items page is accessible, and the Home page is displayed correctly.
    @Test
    public void dynamicCatalogSmoke()
            throws Exception {

    	login();
        HomePage h = new HomePage(d);
        h.getMenubar();

        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getLazyLoad();
        h.getMenubar();
        dp.getallItems();
        h.getTitle();
        logout();
    }


    // TC02: Verify that the Spinner page opens successfully,
    // its products are displayed, the All Items page is accessible, and logout works.
    @Test
    public void spinnerSmoke()
            throws Exception {
    	login();
        HomePage h = new HomePage(d);
        h.getMenubar();
        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getSpinner();
        dp.verifySpinnerProducts();
        h.getMenubar();
        dp.getallItems();
        h.getTitle();
        logout();
    }


    // TC03: Verify that the Slider page opens successfully,
    // its products are displayed, the All Items page is accessible, and logout works.
    @Test
    public void sliderSmoke() throws Exception {
    	login();
        HomePage h = new HomePage(d);
        h.getMenubar();
        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getSlider();
        dp.verifySliderProducts();
        h.getMenubar();
        dp.getallItems();
        h.getTitle();
        logout();
    }
}