package genric_utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptUtility {

    JavascriptExecutor js;

    public JavascriptUtility(WebDriver driver) {
        js = (JavascriptExecutor) driver;
    }

    public void scrollDown(int pixels) {
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }
}

