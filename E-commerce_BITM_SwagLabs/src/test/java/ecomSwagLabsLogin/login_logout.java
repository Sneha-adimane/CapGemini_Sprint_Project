package ecomSwagLabsLogin;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Base_Utility.BaseClass;

public class login_logout extends BaseClass{

	 // Verify that the user can log in and log out successfully
    @Test(groups = {"Smoke"})
    public void loginLogoutTest() throws IOException, InterruptedException {
    	
        login();
        Reporter.log("Login successful", true);
        logout();
        Reporter.log("Logout successful", true);
    }
}
