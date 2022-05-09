import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class MainTests {
    @BeforeClass
    public static void beforeAll() {
        WebDriver driver = DriverSingleton.getDriverInstance();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://buyme.co.il/");
    }
    @Test
    public void test01Registration(){
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickRegisterLogin();
        registrationPage.clickRegister();
        registrationPage.fillRegistrationForm();
        registrationPage.assertFields();
        registrationPage.clickRegister2();

    }
    @Test
    public void text02Homescreen(){
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickRegisterLogin();
        registrationPage.login();
    }

    @AfterClass
    public static void tearDown() {
      DriverSingleton.getDriverInstance().quit();
    }

}
