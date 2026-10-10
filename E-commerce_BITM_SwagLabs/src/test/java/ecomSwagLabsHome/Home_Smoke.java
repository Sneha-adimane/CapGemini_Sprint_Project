package ecomSwagLabsHome;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;

public class Home_Smoke extends BaseClass {

    // TC01: Verify that the Home page loads successfully after login, the page title and products are displayed, and the URL confirms that the user is on the Home page.
    @Test(groups = {"smoke"})
    public void verifyHomePageLoads() throws Exception {
        login();

        HomePage h = new HomePage(d);

        h.getTitle();
        h.getProducts();
        Assert.assertTrue(d.getCurrentUrl().contains("inventory.html"),"Home page did not load");
        logout();
    }
}