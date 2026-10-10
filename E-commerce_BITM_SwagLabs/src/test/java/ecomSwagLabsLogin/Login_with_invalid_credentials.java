package ecomSwagLabsLogin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base_Utility.BaseClass;
import Pom_utilities.LoginPage;
import genric_utilities.DataProviderClass;
import genric_utilities.ScreenshotUtility;


public class Login_with_invalid_credentials extends BaseClass {

	// Verify that an error message is displayed for invalid login credentials
    @Test(priority = 2,groups = {"functional"},dataProvider = "loginDetails",dataProviderClass = DataProviderClass.class)
    public void invalidLoginTest(String username, String password) throws Exception {

        LoginPage l = new LoginPage(d);
        l.login(username, password);
        l.getErrorMessage();
        Reporter.log("Invalid login validation completed", true);
        ScreenshotUtility.takeScreenshot(d, "InvalidLogin");
    }
}