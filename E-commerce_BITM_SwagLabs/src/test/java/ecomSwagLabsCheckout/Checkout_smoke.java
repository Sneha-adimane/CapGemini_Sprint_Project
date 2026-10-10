package ecomSwagLabsCheckout;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.CartPage;
import Pom_utilities.CompletePage;
import Pom_utilities.HomePage;
import Pom_utilities.OverviewPage;
import Pom_utilities.checkoutPage;
import genric_utilities.PropertyFile;

public class Checkout_smoke extends BaseClass{

	// TC01: Verify the basic end-to-end checkout flow, including login, adding a product to the cart,
	// checkout information entry, order overview, order completion, returning to the Home page, and logout.
	@Test(groups = {"smoke"})
	public void basicTest() throws Exception
	{
		login();
		HomePage h = new HomePage(d);
		h.getTitle();
		h.getAddItemToCart();
		h.getCart();
		CartPage c = new CartPage(d);
		c.getProductName();
		c.getCheckoutbtn();
		checkoutPage cop = new checkoutPage(d);
		cop.getFn(PropertyFile.getDataFromProperty("FirstName"));
	    cop.getLn(PropertyFile.getDataFromProperty("LastName"));
	    cop.getPCode(PropertyFile.getDataFromProperty("Zip_code"));
		cop.getContinuebtn();
		OverviewPage op = new OverviewPage(d);
		op.getSummary();
		op.getFinishbtn();
		CompletePage cp = new CompletePage(d);
		cp.getMessage();
		cp.getBackToHomebtn();
		logout();
	}
}