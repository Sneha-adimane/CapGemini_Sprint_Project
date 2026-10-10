package Pom_utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import genric_utilities.SelectUtility;

public class HomePage {

	WebDriver d;
	SelectUtility s = new SelectUtility();

	public HomePage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d , this);
	}
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menubar;
	
	@FindBy(css = "[class='shopping_cart_link']")
	private WebElement cart;
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	private WebElement additemToCart;
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement filter;
	
	@FindBy(xpath = "//span[@class='title']")
	private WebElement title;
	
	@FindBy(xpath = "//div[@class='inventory_item']")
	private List<WebElement> products;
	
	@FindBy(xpath = "//nav[@class='bm-item-list']")
	private List<WebElement> menuList;
	
	@FindBy(xpath = "//span[@class='title']")
	private WebElement CartTitle;
	
	@FindBy(xpath = "(//div[@class='inventory_item_name '])[2]")
	private WebElement productname;
	
	@FindBy(className = "inventory_item_name")
	private List<WebElement> productNames;
	
	@FindBy(className = "inventory_item_price")
	private List<WebElement> productPrices;
	
	@FindBy(xpath = "//button[starts-with(@id,'add-to-cart-')]")
	private List<WebElement> addToCartbtn;
	
	@FindBy(xpath = "//button[starts-with(@id,'remove-')]")
	private List<WebElement> RemovePrd;
	
	@FindBy(className = "shopping_cart_badge")
	private List<WebElement> cartBadge;

	public void getMenubar() throws InterruptedException {
		menubar.click();
		Thread.sleep(1000);
	}
	
	public void getMenuList() {
		Assert.assertTrue(menuList.size()>0,"Items are not displayed");
		Reporter.log("Home page contains menu items",true);
	}


	public void getCart() throws InterruptedException {
		cart.click();
		Thread.sleep(2000);
		String title = CartTitle.getText();
		Assert.assertTrue(title.contains("Your Cart"),"cart page is not displayed");
		Reporter.log(title , true);
		Reporter.log("Cart page is opened",true);
	}
	
	public void getAddItemToCart() throws InterruptedException {
		additemToCart.click();
		Thread.sleep(2000);
	}
	
	public String getHomeProductName() {
		String Productname = productname.getText();
		return Productname;
	}
	

	public void getFilter() {
		filter.click();
	}
	
	public void getFilter(String option) {
        s.selectByVisibleText(filter, option);
    }
	
	public List<WebElement> getFilterOptions() {
	    return s.getAllOptions(filter);
	}
	
	public void printProductNames(String type) {
	    String result = "";
	    for (int i = 0; i < productNames.size(); i++) {
	        result = result + productNames.get(i).getText();
	        if (i < productNames.size() - 1) {
	            result = result + ", ";
	        }
	    }
	    Reporter.log("Sorted by Name (" + type + "): " + result, true);
	}
	
	public void printProductPrices(String type) {
	    String result = "";
	    for (int i = 0; i < productPrices.size(); i++) {
	        result = result + productPrices.get(i).getText();
	        if (i < productPrices.size() - 1) {
	            result = result + ", ";
	        }
	    }
	    Reporter.log("Sorted by Price (" + type + "): " + result, true);
	}

	public void getTitle() {
		String Title = title.getText();
		Reporter.log("HomePage Title:"+Title,true);
		Assert.assertTrue(Title.contains("Products"),"home page is not displayed");
		Reporter.log("Home Page is displayed",true);
	}
	
	public void getProducts() {
		Assert.assertTrue(products.size()>0,"Product is not visible");
		Reporter.log("Products are visible", true);
	}
	
	public void addAllProductsToCart() {
	    for (WebElement button : addToCartbtn) {
	        button.click();
	    }
	    Reporter.log("Products are added to cart", true);
	}
	
	public void verifyProductsAdded() {
		Assert.assertEquals(cart.getAttribute("aria-label"), "Cart, 6 items","ALl Items arenot added");
		Reporter.log("All Products are added to cart",true);
	}

	public void getRemovePrd()
	{
		for (WebElement removebtn : RemovePrd) {
			removebtn.click();
		}
		Reporter.log("Products are removed from cart");	
	}
	
	public void verifyRemovePrd() {
		Assert.assertEquals(cart.getAttribute("aria-label"), "Cart, empty","All Items are not removed");
		Reporter.log("All Products are removed",true);
	}
	

	public void verifyRemoveButtonBeforeAdding() {
	
	    Assert.assertTrue(RemovePrd.isEmpty(),"Remove buttons should not appear before adding products");
	    Reporter.log("Remove buttons are not displayed before adding products",true);
	}


	public void verifyCartBadgeNotDisplayed() {
	    Assert.assertTrue(cartBadge.isEmpty(),"Cart badge appeared without adding a product");
	    Reporter.log("Cart badge is not displayed", true);
	}
	
	public void removeProductFromInventory() {
	    Assert.assertTrue(RemovePrd.size() > 0,"Remove button is not available after adding the product");
	    RemovePrd.get(0).click();
	    Reporter.log("Product removed from inventory", true);
	}
	
	public void verifyRemoveButtonNotDisplayed() {
	    Assert.assertTrue(RemovePrd.isEmpty(),"Remove button remains after product removal");
	    Reporter.log("Remove button is no longer displayed", true);
	}


	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	public void verifyInventoryRequiresLogin() {
	    d.get("https://www.saucedemo.com/inventory.html");
	    Assert.assertTrue(loginButton.isDisplayed(),"Login page is not displayed for unauthenticated user");
	    Assert.assertFalse(d.getCurrentUrl().contains("inventory.html"),"Inventory is accessible without login");
	    Reporter.log("Inventory access is blocked without login",true);
	}

	public void verifyInventoryAfterLogout() {
	    d.get("https://www.saucedemo.com/inventory.html");
	    Assert.assertTrue(loginButton.isDisplayed(),"Logged-out user can still access the home page");
	    Assert.assertFalse(d.getCurrentUrl().contains("inventory.html"),"Inventory is accessible after logout");
	    Reporter.log("Inventory access is blocked after logout",true);
	}
	

	public void verifyCartRequiresLogin() {
	    d.get("https://www.saucedemo.com/cart.html");
	    Assert.assertTrue(loginButton.isDisplayed(),"Login page is not displayed");
	    Assert.assertFalse(d.getCurrentUrl().contains("cart.html"),"Cart is accessible without login");
	    Reporter.log("Cart is not accessible without login", true);
	}


}


