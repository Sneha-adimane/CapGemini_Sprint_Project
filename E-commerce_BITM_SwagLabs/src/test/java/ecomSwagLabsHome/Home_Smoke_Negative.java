package ecomSwagLabsHome;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;

public class Home_Smoke_Negative extends BaseClass {

    // Test verifies that the inventory page cannot be accessed without login.
    @Test(groups = {"smoke"})
    public void verifyInventoryRequiresLogin() {
        HomePage h = new HomePage(d);
        h.verifyInventoryRequiresLogin();
    }
}
