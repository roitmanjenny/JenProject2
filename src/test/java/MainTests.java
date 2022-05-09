import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainTests {
    @BeforeClass
    public static void beforeAll() {
        WebDriver driver = DriverSingleton.getDriverInstance();
        driver.get("https://buyme.co.il/");
    }
    @Test
    public void test01(){
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickRegister();
    }

}
