package ecomSwagLabsCart;


import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.CartPage;
import Pom_utilities.HomePage;

public class Cart_Smoke extends BaseClass {

    // TC01: Verify that the Cart page is accessible and displays the added product successfully
    @Test(groups = {"smoke"})
    public void cartSmokeTest() throws Exception {
        login();
        HomePage h = new HomePage(d);
        h.getAddItemToCart();;
        h.getCart();
        CartPage cp = new CartPage(d);
        cp.verifyProductsInCart();
        logout();
    }
}