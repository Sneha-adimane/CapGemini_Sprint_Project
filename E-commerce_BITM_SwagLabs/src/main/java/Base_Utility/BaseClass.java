package Base_Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Pom_utilities.LoginPage;
import Pom_utilities.LogoutPage;
import genric_utilities.PropertyFile;
import genric_utilities.WebdriverUtility;

public class BaseClass {

    public WebDriver d;
    
    @BeforeSuite(alwaysRun = true)
    public void bs() {
        Reporter.log("Open Database", true);
    }

    @AfterSuite(alwaysRun = true)
    public void as() {
        Reporter.log("Close Database connectivity", true);
    }

    @BeforeTest(alwaysRun = true)
    public void bt() {
        Reporter.log("PreCondition", true);
    }

    @AfterTest(alwaysRun = true)
    public void at() {
        Reporter.log("PostCondition", true);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void bm(@Optional("chrome") String browser) throws IOException, InterruptedException {

        Reporter.log("Opening browser", true);
        System.out.println("Browser received: " + browser);
        d = WebdriverUtility.launchbrowser(browser);
        d.get(PropertyFile.getDataFromProperty("url"));
        Thread.sleep(2000);
        Reporter.log("Application launched", true);
    }

    @AfterMethod(alwaysRun = true)
    public void am() {
        Reporter.log("Test completed", true);
        if (d != null) {
            try {
                d.quit();
                Reporter.log("Browser closed successfully", true);
            } catch (Exception e) {
                Reporter.log("Error while closing browser: " + e.getMessage(),true);
            } finally {
                d = null;
            }
        }
    }

    public void login() throws IOException, InterruptedException {
        LoginPage l = new LoginPage(d);
        l.getUsername(PropertyFile.getDataFromProperty("username"));
        l.getPassword(PropertyFile.getDataFromProperty("password"));
        l.getLogin();
        Thread.sleep(3000);
        Reporter.log("Login successful", true);
    }

    public void logout() throws InterruptedException {

        Reporter.log("Logging out", true);
        LogoutPage l = new LogoutPage(d);
        l.getMenu();
        Thread.sleep(2000);
        l.getLogout();
        Reporter.log("Logout successful", true);
    }
}