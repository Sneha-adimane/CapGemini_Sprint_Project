package ecomSwagLabsHome;

import org.testng.annotations.Test;
import org.testng.Assert;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;

public class Home_System extends BaseClass {

    // TC01: Verify the complete Home page workflow, including login, page title and product display,
    // adding all products to the Cart, verifying the added products, opening the Cart, and logging out.
    @Test(groups = {"system"})
    public void verifyCompleteHomeFlow() throws Exception {
        login();

        HomePage h = new HomePage(d);

        h.getTitle();
        h.getProducts();
        h.addAllProductsToCart();
        h.verifyProductsAdded();
        h.getCart();

        Assert.assertTrue(d.getCurrentUrl().contains("cart.html"),"Cart page was not opened");

        logout();
    }
}