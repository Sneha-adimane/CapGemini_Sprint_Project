package ecomSwagLabsCheckout;

import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.CartPage;
import Pom_utilities.CompletePage;
import Pom_utilities.HomePage;
import Pom_utilities.OverviewPage;
import Pom_utilities.checkoutPage;
import genric_utilities.PropertyFile;


public class Checkout_Functional extends BaseClass{

	// TC01: Verify that the user can enter and verify the first name, last name, and postal code on the checkout information page.
	@Test(groups = {"functional"})
	public void InfoTest() throws Exception {
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
	    cop.verifyFirstName(PropertyFile.getDataFromProperty("FirstName"));
	    cop.verifyLastName(PropertyFile.getDataFromProperty("LastName"));
	    cop.verifyPCode(PropertyFile.getDataFromProperty("Zip_code"));
	}

	// TC02: Verify that clicking the Continue button proceeds from the checkout information page.
	@Test(groups = {"functional"})
	public void verifyContinuebtnTest() throws Exception
	{
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
		cop.verifyContinuebtn();
	}

	// TC03: Verify that clicking the Cancel button cancels checkout and returns to the previous page.
	@Test(groups = {"functional"})
	public void verifyCancelbtnTest() throws Exception
	{
		login();
		HomePage h = new HomePage(d);
		h.getAddItemToCart();
		h.getCart();
		CartPage c = new CartPage(d);
		c.getCheckoutbtn();
		checkoutPage cop = new checkoutPage(d);
		cop.getCancelbtn();
		cop.verifyCancelbtn();
	}

	// TC04: Verify that the order summary is displayed after entering checkout information and clicking Continue.
	@Test(groups = {"functional"})
	public void SummaryOfProduct() throws Exception
	{
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
		op.getSummary();
	}

	// TC05: Verify that the title of the checkout overview page is displayed correctly.
	@Test(groups = {"functional"})
	public void verifyTitleOfPageTest() throws Exception
	{
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
		op.getOverviewTitle();
	}

	// TC06: Verify that clicking the Finish button completes the checkout process.
	@Test(groups = {"functional"})
	public void verfiyFinishbtn() throws Exception
	{
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
	}

	// TC07: Verify that clicking the Cancel button on the overview page cancels the order process.
	@Test(groups = {"functional"})
	public void verifyCancelbtn() throws Exception
	{
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
		op.getCancelbtn();
	}

	// TC08: Verify that the order confirmation title is displayed after successfully placing an order.
	@Test(groups = {"functional"})
	public void VerifOrderTitle() throws Exception
	{
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
		cp.getOrderTitle();
	}

	// TC09: Verify that the order confirmation message is displayed after successfully placing an order.
	@Test(groups = {"functional"})
	public void verifyOrdermessage() throws Exception
	{
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

	// TC10: Verify that clicking the Back to Home button navigates to the home page after order completion.
	@Test(groups = {"functional"})
	public void verifyBackToHomeTest() throws Exception
	{
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

	// TC11: Verify that clicking the PDF button initiates the order confirmation PDF action.
	@Test(groups = {"functional"})
	public void verifyPdfBtn() throws Exception
	{
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
		cp.getPdfbtn();
	}
}