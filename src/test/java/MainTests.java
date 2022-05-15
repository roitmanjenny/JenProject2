import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class MainTests{

    private static ExtentReports extent = ExtentReport.getReporter();
    private static ExtentTest test = extent.createTest("BuyMe Automation Project", "Website Sanity test");

    @BeforeClass
    public void before() throws Exception {
        WebDriver driver = DriverSingleton.getDriverInstance();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(DriverSingleton.getData("URL"));
        test.log(Status.INFO, "before test method");
    }


    @Test
    public void test01_Registration() throws Exception {
        try {
            RegistrationPage registrationPage = new RegistrationPage();
            registrationPage.clickRegisterLogin();
            registrationPage.clickRegister();
            registrationPage.fillRegistrationForm();
            registrationPage.assertFields();
            registrationPage.clickRegister2();
            test.pass("Registration successful");
        }
        catch (Exception e){
            e.printStackTrace();
            test.fail("Registration was not successful! " + e.getMessage());
        }
    }

    @Test
    public void test02_HomePage() throws Exception {
        HomePage homePage = new HomePage();
        homePage.selectPrice();
        homePage.selectRegion();
        homePage.selectCategory();
        homePage.clickSearch();
    }

    @Test
    public void test03_Business() throws Exception {
        BusinessPage businessPage = new BusinessPage();
        businessPage.clickBusiness();
        businessPage.insertPrice("100");
        businessPage.clickChoose();
    }

    @Test
    public void test04_Info() throws Exception {
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
    public static void tearDown() throws Exception {
        extent.flush();
        DriverSingleton.getDriverInstance().quit();
    }

}
