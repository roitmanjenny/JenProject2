import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class MainTests {
    @BeforeClass
    public static void beforeAll() {
        WebDriver driver = DriverSingleton.getDriverInstance();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://buyme.co.il/");
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
    public void test02_HomePage() {
        HomePage homePage = new HomePage();
        homePage.selectPrice();
        homePage.selectRegion();
        homePage.selectCategory();
        homePage.clickSearch();
    }

    @Test
    public void test03_Business() {
        BusinessPage businessPage = new BusinessPage();
        businessPage.clickBusiness();
        businessPage.insertPrice("100");
        businessPage.clickChoose();
    }

    @Test
    public void test04_Info() {
        InfoPage infoPage = new InfoPage();
        infoPage.insertName();
        infoPage.pickEvent();
        infoPage.enterBlessing();
        infoPage.uploadPicture();
        infoPage.clickNext();
        infoPage.pickMail();
        infoPage.enterMail();
        infoPage.enterSender();
        infoPage.clickPay();
    }

    @AfterClass
    public static void tearDown() {
        DriverSingleton.getDriverInstance().quit();
    }

}
