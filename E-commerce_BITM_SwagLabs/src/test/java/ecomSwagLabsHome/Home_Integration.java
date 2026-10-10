package ecomSwagLabsHome;

import org.testng.annotations.Test;
import Base_Utility.BaseClass;
import Pom_utilities.HomePage;

public class Home_Integration extends BaseClass {

    // TC01: Verify integration between the Home page and Cart by checking the Home page title, adding a product to the Cart, opening the Cart, and logging out.
    @Test(groups = {"integration"})
    public void verifyHomeToCart() throws Exception {
        login();

        HomePage h = new HomePage(d);
        h.getTitle();
        h.getAddItemToCart();
        h.getCart();

        logout();
    }

    // TC02: Verify that the Home page product sorting options work correctly for name in ascending and descending order and price in low-to-high and high-to-low order.
    @Test(groups = {"integration"})
    public void verifySortingOptions() throws Exception {
        login();

        HomePage h = new HomePage(d);

        h.getFilter("Name (A to Z)");
        h.printProductNames("A to Z");

        h.getFilter("Name (Z to A)");
        h.printProductNames("Z to A");

        h.getFilter("Price (low to high)");
        h.printProductPrices("Low to high");

        h.getFilter("Price (high to low)");
        h.printProductPrices("High to low");

        logout();
    }
}