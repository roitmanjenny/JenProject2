import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static String email = "jenny6@email.com";
    private static String password = "Q1w2e3r4";

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public void clickElement(By locator) throws Exception {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) throws Exception {
        getWebElement(locator).sendKeys(text);
    }

    public WebElement getWebElement(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }

}
