import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static String email = "jenny1@email.com";
    private static String password = "Q1w2e3r4";

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    public WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }

}
