package Pom_utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CartPage {

	WebDriver d;
	
	public CartPage(WebDriver d)
	{
		this.d = d;
		PageFactory.initElements(d , this);
	}
	
	@FindBy(xpath = "//span[@class='title']")
	private WebElement CartTitle;
	
	@FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
	private WebElement removebtn;
	
	@FindBy(id = "continue-shopping")
	private WebElement continueShopping;
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private WebElement CartProductName;
	
	@FindBy(xpath = "//div[@class='cart_list']//div[@class='cart_item']")
	private List<WebElement> cartProducts;
	
	@FindBy(id = "checkout")
	private WebElement checkoutbtn;
	
	@FindBy(xpath = "//span[@class='title']")
	private WebElement checkoutTitle;
	
	
	public void getCarttitle() {
		Reporter.log(CartTitle.getText(),true);
		Assert.assertEquals(CartTitle.getText(), "Your Cart");
		Reporter.log("Verified that product is added to cartpage",true);
	}
	
	public void getRemovebtn() throws InterruptedException
	{
		removebtn.click();
		Thread.sleep(2000);
	}
	
	public void getContinueShopping() throws InterruptedException
	{
		continueShopping.click();
		Thread.sleep(2000);
	}
	
	public String getProductName() {
		String Cartproductname = CartProductName.getText();
		Reporter.log(Cartproductname,true);
		return Cartproductname;
	}
	
	public void verifyProductsInCart() {
	    Assert.assertTrue(cartProducts.size() > 0,"Products are not present in cart");
	    Reporter.log("Products are present in cart", true);
	    Reporter.log("Number of products in cart: " + cartProducts.size(), true);
	}
	
	public void verifyProductRemoved() {
	    Assert.assertEquals(cartProducts.size(),0,"Product is still present in cart");
	    Reporter.log("Product is removed from cart",true);
	}
	
	public void getCheckoutbtn() {
		checkoutbtn.click();
		Reporter.log(checkoutTitle.getText(),true);
		Assert.assertEquals(checkoutTitle.getText(), "Checkout: Your Information", "Checkout page is not opened");
		Reporter.log("Checkout title is displayed", true);
	}
	
	public void verifyCartEmpty() {
	    Assert.assertEquals(cartProducts.size(),0,"Precondition failed: cart is not empty");
	    Reporter.log("Cart is empty", true);
	}

	public void refreshAndVerifyCartEmpty() throws InterruptedException {
	    d.navigate().refresh();
	    Thread.sleep(2000);
	    Assert.assertEquals(cartProducts.size(),0,"Removed product reappeared after refresh");
	    Reporter.log("Removed product did not reappear after refresh",true);
	}

}
