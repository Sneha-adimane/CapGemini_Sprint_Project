package ecomSwagLabsHome;

import org.testng.annotations.Test;
import Base_Utility.BaseClass;
import Pom_utilities.HomePage;

public class Home_Functional extends BaseClass {

    // TC01: Verify the Home page title, product display, menu list, and Cart navigation.
    @Test(groups = {"functional"})
	public void verifyHomePageByMenuList() throws Exception {

		login();
		HomePage h = new HomePage(d);
		h.getTitle();
		h.getProducts();
		h.getMenubar();
		h.getMenuList();
		h.getCart();
	}

    // TC02: Verify that a product can be removed successfully and the removal is verified.
    @Test(groups = {"functional"})
    public void removeProductTest() throws Exception {
        login();
        HomePage h = new HomePage(d);
        h.getRemovePrd();
        h.verifyRemovePrd();
    }

    // TC03: Verify that all products can be added to the Cart and that the added products are verified.
    @Test(groups = {"functional"})
    public void verifyAddAllProducts() throws Exception {
        login();

        HomePage h = new HomePage(d);

        h.addAllProductsToCart();
        h.verifyProductsAdded();

        logout();
    }
}