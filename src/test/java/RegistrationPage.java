import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class RegistrationPage extends BasePage {
    private WebDriver driver;

    public RegistrationPage() throws Exception {
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void clickRegisterLogin() throws Exception {
        clickElement(By.className("notSigned"));
    }

    public void clickRegister() throws Exception {
        clickElement(By.xpath("//span[@class='text-link theme']"));
    }

    public void fillRegistrationForm() throws Exception {
        sendKeysToElement(By.id("ember1795"), "firstname");
        sendKeysToElement(By.id("ember1802"), BasePage.getEmail());
        sendKeysToElement(By.id("valPass"), BasePage.getPassword());
        sendKeysToElement(By.id("ember1816"), BasePage.getPassword());
    }

    public void assertFields() throws Exception {
        assertEquals(getWebElement(By.id("ember1795")).getAttribute("value"), "firstname");
        assertEquals(getWebElement(By.id("ember1802")).getAttribute("value"), BasePage.getEmail());
    }

    public void clickRegister2() throws Exception {
        clickElement(By.id("ember1822"));
    }
}
