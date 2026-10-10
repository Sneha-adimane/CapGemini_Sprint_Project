package ecomSwagLabsCheckout;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.HomePage;
import Pom_utilities.CartPage;
import Pom_utilities.checkoutPage;
import genric_utilities.DataProviderClass;
import genric_utilities.ScreenshotUtility;

public class Checkout_Functional_Negative extends BaseClass {

    // Negative Test 1: All fields empty
    @Test(groups = {"functional"},dataProvider = "emptyAllFields",dataProviderClass = DataProviderClass.class)
    public void emptyAllFieldsTest(String firstName, String lastName, String postalCode)throws Exception {
        
    	login();

        HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.getCart();

        CartPage c = new CartPage(d);
        c.getCheckoutbtn();

        checkoutPage cop = new checkoutPage(d);
        cop.getFn(firstName);
        cop.getLn(lastName);
        cop.getPCode(postalCode);
        cop.getContinuebtn();

        cop.verifyFirstNameRequired();
        cop.verifyCheckoutInformationPage();

        ScreenshotUtility.takeScreenshot(d, "emptyAllFields");
    }

    // Negative Test 2: First Name empty
    @Test(groups = {"functional"},dataProvider = "emptyFirstName",dataProviderClass = DataProviderClass.class)
    public void emptyFirstNameTest(String firstName, String lastName, String postalCode)throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.getCart();

        CartPage c = new CartPage(d);
        c.getCheckoutbtn();

        checkoutPage cop = new checkoutPage(d);
        cop.getFn(firstName);
        cop.getLn(lastName);
        cop.getPCode(postalCode);
        cop.getContinuebtn();

        cop.verifyFirstNameRequired();
        cop.verifyCheckoutInformationPage();
    }

    // Negative Test 3: Last Name empty
    @Test(groups = {"functional"},dataProvider = "emptyLastName",dataProviderClass = DataProviderClass.class)
    public void emptyLastNameTest(String firstName, String lastName, String postalCode)throws Exception {

        login();

        HomePage h = new HomePage(d);
        h.getAddItemToCart();
        h.getCart();

        CartPage c = new CartPage(d);
        c.getCheckoutbtn();

        checkoutPage cop = new checkoutPage(d);
        cop.getFn(firstName);
        cop.getLn(lastName);
        cop.getPCode(postalCode);
        cop.getContinuebtn();

        cop.verifyLastNameRequired();
        cop.verifyCheckoutInformationPage();

        ScreenshotUtility.takeScreenshot(d, "Checkout_EmptyLastName");
    }
}
