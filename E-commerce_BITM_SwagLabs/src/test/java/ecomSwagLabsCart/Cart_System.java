package ecomSwagLabsCart;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.CartPage;
import Pom_utilities.HomePage;

public class Cart_System extends BaseClass {

    // TC01: Verify the complete cart workflow, including adding a product, viewing the cart,
    // verifying the product, removing it, continuing shopping, and logging out
    @Test(groups = {"system"})
    public void completeCartFlow() throws Exception {
        login();
        HomePage h = new HomePage(d);
        h.getAddItemToCart();;
        h.getCart();
        CartPage cp = new CartPage(d);
        cp.verifyProductsInCart();
        cp.getRemovebtn();
        cp.verifyProductRemoved();
        cp.getContinueShopping();
        h.getTitle();
        logout();
    }
}