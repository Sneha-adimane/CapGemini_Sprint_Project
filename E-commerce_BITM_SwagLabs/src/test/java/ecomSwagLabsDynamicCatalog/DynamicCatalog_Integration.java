package ecomSwagLabsDynamicCatalog;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.DynamicCatalogPage;
import Pom_utilities.HomePage;

public class DynamicCatalog_Integration extends BaseClass {

    // TC01: Verify integration between login, Lazy Load, the menu, and the All Items page.
    @Test(groups = {"integration"})
    public void loginToLazyLoad() throws Exception {
    	login();
        HomePage h = new HomePage(d);
        h.getMenubar();

        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getLazyLoad();
        h.getMenubar();
        dp.getallItems();
        h.getTitle();
    }


    // TC02: Verify integration between login, the Spinner page, product display, and the All Items page.
    @Test(groups = {"integration"})
    public void loginToSpinner() throws Exception {
        login();
        HomePage h = new HomePage(d);
        h.getMenubar();
        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getSpinner();
        dp.verifySpinnerProducts();
        h.getMenubar();
        dp.getallItems();
    }


    // TC03: Verify integration between login, the Slider page, product display, and the All Items page.
    @Test(groups = {"integration"})
    public void loginToSlider() throws Exception {
        login();
        HomePage h = new HomePage(d);
        h.getMenubar();
        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getSlider();
        dp.verifySliderProducts();
        h.getMenubar();
        dp.getallItems();
    }

    // TC04: Verify navigation between Lazy Load, Spinner, and Slider pages through the Dynamic Catalog menu.
    @Test(groups = {"integration"})
    public void DynamicCatalogTOAll() throws Exception {
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
    }
}