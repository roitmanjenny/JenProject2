import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class RegistrationPage extends BasePage {
    private WebDriver driver;
//private static String email = "jen@email.com";
//private static String password = "Q1w2e3r4";

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
        //fillField(By.id("ember1794"),"firstname");
        sendKeysToElement(By.id("ember1794"), "firstname");
        sendKeysToElement(By.id("ember1801"), BasePage.getEmail());
        sendKeysToElement(By.id("valPass"), BasePage.getPassword());
        sendKeysToElement(By.id("ember1815"), BasePage.getPassword());
    }

    public void login() {
        getWebElement(By.xpath("//input[@placeholder = 'מייל']")).clear();
        sendKeysToElement(By.xpath("//input[@placeholder = 'מייל']"), BasePage.getEmail());

        getWebElement(By.xpath("//input[@placeholder = 'סיסמה']")).clear();
        sendKeysToElement(By.xpath("//input[@placeholder = 'סיסמה']"), BasePage.getPassword());

        clickElement(By.xpath("//button[@type = 'submit']"));
    }

    public void assertFields() {
        assertEquals(getWebElement(By.id("ember1794")).getAttribute("value"), "firstname");
        assertEquals(getWebElement(By.id("ember1801")).getAttribute("value"), BasePage.getEmail());
    }

    public void clickRegister2() {
        clickElement(By.id("ember1821"));
    }

//    public void fillField(By locator, String text){
//        sendKeysToElement(locator,text);
//    }


}
