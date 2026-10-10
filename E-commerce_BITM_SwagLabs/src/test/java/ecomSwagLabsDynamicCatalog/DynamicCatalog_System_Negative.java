package ecomSwagLabsDynamicCatalog;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import Pom_utilities.DynamicCatalogPage;

public class DynamicCatalog_System_Negative extends BaseClass {

    // SYS01: Verify that products remain available after repeated scrolling.
    @Test(groups = {"system"})
    public void repeatedScrollStabilityTest() throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getMenubar();

        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getLazyLoad();

        dp.verifyRepeatedScrollStability();
    }

    // SYS02: Verify that the catalog cannot be accessed after logout.
    @Test(groups = {"system"})
    public void catalogAccessAfterLogoutTest() throws Exception {

        login();

        logout();

        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.verifyCatalogAccessAfterLogout();
    }
}
