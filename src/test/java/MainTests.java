import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class MainTests {
    @BeforeClass
    public static void beforeAll() {
        WebDriver driver = DriverSingleton.getDriverInstance();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("https://buyme.co.il/");
        driver.get("https://buyme.co.il/money/15287647?price=100");
        driver.manage().window().maximize();
    }

    @Test
    public void test01_Registration() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickRegisterLogin();
        registrationPage.clickRegister();
        registrationPage.fillRegistrationForm();
        registrationPage.assertFields();
        registrationPage.clickRegister2();
    }

    @Test
    public void test02_Homescreen() {
//        RegistrationPage registrationPage = new RegistrationPage();
//        registrationPage.clickRegisterLogin();
//        registrationPage.login();
        HomePage homePage = new HomePage();
        homePage.selectPrice();
        homePage.selectRegion();
        homePage.selectCategory();
        homePage.clickSearch();
    }

    @Test
    public void test03_Business() {
        BusinessPage businessPage = new BusinessPage();
        //businessPage.clickCategory();
        businessPage.clickBusiness();
        businessPage.insertPrice("100");
        businessPage.clickChoose();
    }

    @Test
    public void test04_Info() {
        InfoPage businessPage = new InfoPage();
        businessPage.InsertName();
    }

    @AfterTest
    public static void tearDown() {
        DriverSingleton.getDriverInstance().quit();
    }

}
