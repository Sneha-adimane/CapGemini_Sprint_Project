package ecomSwagLabsCheckout;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.CartPage;
import Pom_utilities.CompletePage;
import Pom_utilities.DynamicCatalogPage;
import Pom_utilities.HomePage;
import Pom_utilities.OverviewPage;
import Pom_utilities.checkoutPage;
import genric_utilities.PropertyFile;

public class Checkout_Integration extends BaseClass {

	// TC01: Verify integration between the Cart and Checkout pages, including product name validation and navigation to the Overview page.
	@Test(groups = {"integration"})
	public void verifyCartToCheckout() throws Exception {

	    login();

	    HomePage h = new HomePage(d);
	    String homeProduct = h.getHomeProductName();
	    h.getAddItemToCart();
	    h.getCart();

	    CartPage c = new CartPage(d);
	    String cartProduct = c.getProductName();
	    Assert.assertEquals(cartProduct,homeProduct,"Home Page product and Cart product are different");
	    Reporter.log("Both product names are same", true);
	    c.getCheckoutbtn();

	    checkoutPage cop = new checkoutPage(d);
	    cop.getFn(PropertyFile.getDataFromProperty("FirstName"));
	    cop.getLn(PropertyFile.getDataFromProperty("LastName"));
	    cop.getPCode(PropertyFile.getDataFromProperty("Zip_code"));
	    cop.getContinuebtn();
	}


	// TC02: Verify that entering valid checkout information and clicking Continue navigates to the Overview page.
	@Test(groups = {"integration"})
	public void verifyCheckoutToOverview() throws Exception {

	    login();

	    HomePage h = new HomePage(d);
	    h.getAddItemToCart();
	    h.getCart();

	    CartPage c = new CartPage(d);
	    c.getCheckoutbtn();

	    checkoutPage cop = new checkoutPage(d);
	    cop.getFn(PropertyFile.getDataFromProperty("FirstName"));
	    cop.getLn(PropertyFile.getDataFromProperty("LastName"));
	    cop.getPCode(PropertyFile.getDataFromProperty("Zip_code"));
	    cop.getContinuebtn();
	}


	// TC03: Verify integration between the Overview and Complete pages by finishing checkout and checking the order confirmation message.
	@Test(groups = {"integration"})
	public void verifyOverviewToComplete() throws Exception {

	    login();

	    HomePage h = new HomePage(d);
	    h.getAddItemToCart();
	    h.getCart();

	    CartPage c = new CartPage(d);
	    c.getCheckoutbtn();

	    checkoutPage cop = new checkoutPage(d);
	    cop.getFn(PropertyFile.getDataFromProperty("FirstName"));
	    cop.getLn(PropertyFile.getDataFromProperty("LastName"));
	    cop.getPCode(PropertyFile.getDataFromProperty("Zip_code"));
	    cop.getContinuebtn();

	    OverviewPage op = new OverviewPage(d);
	    op.getFinishbtn();
	    CompletePage cp = new CompletePage(d);
	    cp.getMessage();
	}


	// TC04: Verify that clicking Back to Home after completing an order navigates to the Home page.
	@Test(groups = {"integration"})
	public void verifyCompleteToHome() throws Exception {

	    login();

	    HomePage h = new HomePage(d);
	    h.getAddItemToCart();
	    h.getCart();

	    CartPage c = new CartPage(d);
	    c.getCheckoutbtn();

	    checkoutPage cop = new checkoutPage(d);
	    cop.getFn(PropertyFile.getDataFromProperty("FirstName"));
	    cop.getLn(PropertyFile.getDataFromProperty("LastName"));
	    cop.getPCode(PropertyFile.getDataFromProperty("Zip_code"));
	    cop.getContinuebtn();

	    OverviewPage op = new OverviewPage(d);
	    op.getFinishbtn();

	    CompletePage cp = new CompletePage(d);
	    cp.getBackToHomebtn();
	}


	// TC05: Verify that the user can log out from the Checkout information page and that the expected URL is displayed.
	@Test(groups = {"integration"})
	public void verifyCheckoutToLogout() throws Exception {

	    login();

	    HomePage h = new HomePage(d);
	    h.getAddItemToCart();
	    h.getCart();

	    CartPage c = new CartPage(d);
	    c.getCheckoutbtn();

	    checkoutPage cop = new checkoutPage(d);
	    cop.getFn(PropertyFile.getDataFromProperty("FirstName"));
	    cop.getLn(PropertyFile.getDataFromProperty("LastName"));
	    cop.getPCode(PropertyFile.getDataFromProperty("Zip_code"));

	    // Logout from the checkout page
	    logout();

	    // Verify that the login page is displayed
	    Assert.assertTrue(d.getCurrentUrl().contains("saucedemo.com"),"Login page URL is incorrect");
	}

	// TC06: Verify checkout information and confirm that the user can log out from the Checkout information page.
	@Test(groups = {"integration"})
	public void checkoutToLogout() throws Exception
	{
		login();
		HomePage h = new HomePage(d);
		h.getAddItemToCart();
		h.getCart();

		CartPage c = new CartPage(d);
		c.getProductName();
		c.getCheckoutbtn();

		checkoutPage cop = new checkoutPage(d);
		cop.getFn(PropertyFile.getDataFromProperty("FirstName"));
	    cop.getLn(PropertyFile.getDataFromProperty("LastName"));
	    cop.getPCode(PropertyFile.getDataFromProperty("Zip_code"));
	    cop.verifyFirstName(PropertyFile.getDataFromProperty("FirstName"));
	    cop.verifyLastName(PropertyFile.getDataFromProperty("LastName"));
	    cop.verifyPCode(PropertyFile.getDataFromProperty("Zip_code"));
	    logout();
	}


	// TC07: Verify checkout information, navigate to the Overview page, check the order summary, and log out.
	@Test(groups = {"integration"})
	public void OverviewToLogout() throws Exception{
		login();
		HomePage h = new HomePage(d);
		h.getAddItemToCart();
		h.getCart();

		CartPage c = new CartPage(d);
		c.getProductName();
		c.getCheckoutbtn();

		checkoutPage cop = new checkoutPage(d);
		cop.getFn(PropertyFile.getDataFromProperty("FirstName"));
	    cop.getLn(PropertyFile.getDataFromProperty("LastName"));
	    cop.getPCode(PropertyFile.getDataFromProperty("Zip_code"));
	    cop.verifyFirstName(PropertyFile.getDataFromProperty("FirstName"));
	    cop.verifyLastName(PropertyFile.getDataFromProperty("LastName"));
	    cop.verifyPCode(PropertyFile.getDataFromProperty("Zip_code"));
	    cop.getContinuebtn();

	    OverviewPage op = new OverviewPage(d);
	    op.getSummary();
	    logout();
	}

	// TC08: Verify the complete order flow from the Home page to order confirmation, then navigate to All Items and return to the Home page.
	@Test(groups = {"integration"})
	public void OrderToAllItems() throws Exception{
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
		h.getMenubar();

		DynamicCatalogPage dp = new DynamicCatalogPage(d);
		dp.getallItems();
		h.getTitle();
		logout();
	}

	// TC09: Verify the complete order flow and integration with the Dynamic Catalog pages, including Lazy Load, Spinner, Slider, and All Items.
	@Test(groups = {"integration"})
	public void OrderToAllTest() throws Exception
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
		h.getMenubar();

        DynamicCatalogPage dp = new DynamicCatalogPage(d);
        dp.getDynamicCatalog();
        dp.getLazyLoad();
        h.getMenubar();
        dp.getDynamicCatalog();
        dp.getSpinner();
        h.getMenubar();
        dp.getDynamicCatalog();
        dp.getSlider();
        h.getMenubar();
        dp.getallItems();
        logout();
	}

	// TC10: Verify the complete order flow, check the order summary and confirmation message, and log out.
	@Test(groups = {"integration"})
	public void OrderToLaogout() throws Exception
	{
		login();
		HomePage h = new HomePage(d);
		h.getAddItemToCart();
		h.getCart();

		CartPage c = new CartPage(d);
		c.getProductName();
		c.getCheckoutbtn();

		checkoutPage cop = new checkoutPage(d);
		cop.getFn(PropertyFile.getDataFromProperty("FirstName"));
	    cop.getLn(PropertyFile.getDataFromProperty("LastName"));
	    cop.getPCode(PropertyFile.getDataFromProperty("Zip_code"));
	    cop.verifyFirstName(PropertyFile.getDataFromProperty("FirstName"));
	    cop.verifyLastName(PropertyFile.getDataFromProperty("LastName"));
	    cop.verifyPCode(PropertyFile.getDataFromProperty("Zip_code"));
	    cop.getContinuebtn();

	    OverviewPage op = new OverviewPage(d);
	    op.getSummary();
		op.getFinishbtn();

		CompletePage cp = new CompletePage(d);
		cp.getMessage();
		logout();
	}
}