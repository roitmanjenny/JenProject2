import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class RegistrationPage extends BasePage {
    private WebDriver driver;

    public RegistrationPage() {
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void clickRegisterLogin() {
        clickElement(By.className("notSigned"));
    }

    public void clickRegister() {
        clickElement(By.xpath("//span[@class='text-link theme']"));
    }

    public void fillRegistrationForm() {
        sendKeysToElement(By.id("ember1795"), "firstname");
        sendKeysToElement(By.id("ember1802"), BasePage.getEmail());
        sendKeysToElement(By.id("valPass"), BasePage.getPassword());
        sendKeysToElement(By.id("ember1816"), BasePage.getPassword());
    }

    public void assertFields() {
        assertEquals(getWebElement(By.id("ember1795")).getAttribute("value"), "firstname");
        assertEquals(getWebElement(By.id("ember1802")).getAttribute("value"), BasePage.getEmail());
    }

    public void clickRegister2() {
        clickElement(By.id("ember1822"));
    }
}
