package ecomSwagLabsDynamicCatalog;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.DynamicCatalogPage;
import Pom_utilities.HomePage;

public class DynamicCatalog_Functional extends BaseClass {

    // TC01: Verify that Lazy Load products are displayed correctly and additional products load when scrolling.
    @Test
    public void lazyLoadTest() throws Exception {

        login();
        HomePage h = new HomePage(d);
        h.getMenubar();

        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getLazyLoad();
        dp.verifyLazyLoadProducts();
        dp.verifyLazyLoadOnScroll();
    }


    // TC02: Verify that the Spinner page displays its products correctly and allows product interaction.
    @Test(priority=1)
    public void spinnerTest() throws Exception {
        login();
        HomePage h = new HomePage(d);
        h.getMenubar();

        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getSpinner();
        dp.verifySpinnerProducts();
        dp.getProducts_spinner();
    }


    // TC03: Verify that the Slider page displays its products correctly and allows product interaction.
    @Test(priority = 2)
    public void sliderTest() throws Exception {
        login();
        HomePage h = new HomePage(d);
        h.getMenubar();

        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getSlider();
        dp.verifySliderProducts();
        dp.getProducts_slider();
    }
}