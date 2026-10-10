package Pom_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class checkoutPage {

	WebDriver d;
	
	public checkoutPage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d , this);
	}
	
	@FindBy(id = "first-name")
	private WebElement Fn;
	
	@FindBy(id = "last-name")
	private WebElement Ln;
	
	@FindBy(id = "postal-code")
	private WebElement PCode;
	
	@FindBy(id = "continue")
	private WebElement continuebtn;
	
	@FindBy(id = "cancel")
	private WebElement cancelbtn;

	public void getFn(String value) {
		Fn.sendKeys(value);
	}

	public void getLn(String value) {
		Ln.sendKeys(value);
	}

	public void getPCode(String value) {
		PCode.sendKeys(value);
	}

	public void getContinuebtn() throws InterruptedException {
		continuebtn.click();
		Thread.sleep(3000);
	}

	public void getCancelbtn() throws InterruptedException {
		cancelbtn.click();
		Thread.sleep(3000);
	}
	
	public void verifyFirstName(String expected) {
	    String actual = Fn.getAttribute("value");
	    Assert.assertEquals(actual,expected,"First Name is not entered corretly");
	    Reporter.log("First Name is entered correctly: " + actual,true);
	}
	
	public void verifyLastName(String expected) {
		String actual = Ln.getAttribute("value");
	    Assert.assertEquals(actual,expected,"Last Name is not entered correctly");
	    Reporter.log("Last Name is entered correctly: " + actual,true);
	}
	
	public void verifyPCode(String expected) {
	    String actual = PCode.getAttribute("value");
	    Assert.assertEquals(actual,expected,"Zip Code is not entered correctly");
	    Reporter.log("Zip Code is entered correctly: " + actual,true);
	}
	
	public void verifyContinuebtn() {
		Assert.assertTrue(d.getCurrentUrl().contains("checkout-step-two.html"), "Checkout Overview Page is not Displayed");
		Reporter.log("CheckoutOverview Page is displayed",true);
	}
	
	public void verifyCancelbtn() {
		Assert.assertTrue(d.getCurrentUrl().contains("cart.html"), "Your Cart Page is not Displayed");
		Reporter.log("Your Cart Page is displayed",true);
	}
	

	@FindBy(css = "[data-test='error']")
	private WebElement errorMessage;
	
	public void verifyFirstNameRequired() {
	    Assert.assertTrue(errorMessage.getText().contains("First Name is required"),"First Name validation message was not displayed");
	    Reporter.log("First Name validation message is displayed", true);
	}
	
	public void verifyLastNameRequired() {
	    Assert.assertTrue(errorMessage.getText().contains("Last Name is required"),"Last Name validation message was not displayed");
	    Reporter.log("Last Name validation message is displayed", true);
	}
	
	public void verifyCheckoutInformationPage() {
	    Assert.assertTrue(d.getCurrentUrl().contains("checkout-step-one.html"),"Checkout proceeded despite invalid information");
	    Reporter.log("User remains on Checkout Information page", true);
	}
	
	public void verifyOrderNotCompleted() {
	    Assert.assertFalse(d.getCurrentUrl().contains("checkout-complete.html"),"Incomplete order reached the completion page");
	    Reporter.log("Incomplete order was not completed", true);
	}

}

