package ecomSwagLabsLogin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.LoginPage;
import genric_utilities.DataProviderClass;

public class Login_with_valid_credentials extends BaseClass {

    // TC01: Verify that the user can log in successfully with valid credentials and that the Products page is displayed with the expected title.
    @Test(groups = {"integration"})
    public void validLoginTest() throws IOException, InterruptedException {
        login();
        Thread.sleep(2000);
        // Verify Products page is displayed
        String title = d.getTitle();
        Reporter.log("Home Page Title: " + title,true);
        Assert.assertTrue(title.contains("Swag Labs"),"Home page is not displayed");
        Reporter.log("Login successful",true);
        Thread.sleep(1000);
    }

    // TC02: Verify that users provided by the DataProvider can log in successfully and are redirected to the Products page.
    @Test(groups = {"functional"},dataProvider = "loginDetailsxlx",dataProviderClass = DataProviderClass.class)
        public void validLoginTest(String username, String password)
                throws InterruptedException {

            LoginPage l = new LoginPage(d);

            l.getUsername(username);
            l.getPassword(password);
            l.getLogin();

            Thread.sleep(2000);

            String title = d.getTitle();
            String currentUrl = d.getCurrentUrl();

            Reporter.log("Username: " + username, true);
            Reporter.log("Home Page Title: " + title, true);
            Reporter.log("Current URL: " + currentUrl, true);

            Assert.assertTrue(title.contains("Swag Labs")&& currentUrl.contains("inventory.html"),"Home page is not displayed for user: " + username);

            Reporter.log("Home page displayed successfully for: " + username,true);
        }
}