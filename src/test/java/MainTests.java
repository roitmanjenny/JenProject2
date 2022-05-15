import Pages.BusinessPage;
import Pages.HomePage;
import Pages.InfoPage;
import Pages.RegistrationPage;
import Utils.DriverSingleton;
import Utils.ExtentReport;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class MainTests {

    @BeforeClass
    public void before() throws Exception {
        ExtentReport.createTest("BuyMe Automation Project", "Website Sanity test");
        WebDriver driver = DriverSingleton.getDriverInstance();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(DriverSingleton.getData("URL"));
        ExtentReport.getTest().log(Status.INFO, "Before test prep done");
    }
//Testing registration
    @Test
    public void test01_Registration() throws Exception {
        try {
            RegistrationPage registrationPage = new RegistrationPage();
            registrationPage.clickRegisterLogin();
            registrationPage.clickRegister();
            registrationPage.fillRegistrationForm();
            registrationPage.assertFields();
            registrationPage.clickRegister2();
            ExtentReport.getTest().pass("Registration successful");
        } catch (Exception e) {
            e.printStackTrace();
            ExtentReport.getTest().fail("Registration was not successful! " + e.getMessage());
        }
    }
//Testing the filtering in home page
    @Test
    public void test02_HomePage() throws Exception {
        try {
            HomePage homePage = new HomePage();
            homePage.selectPrice();
            homePage.selectRegion();
            homePage.selectCategory();
            homePage.clickSearch();
            ExtentReport.getTest().pass("Homepage search and filter successful");
        } catch (Exception e) {
            e.printStackTrace();
            ExtentReport.getTest().fail("Homepage search and filter was not successful! " + e.getMessage());
        }
    }
//Testing the selection of the price inside chosen business
    @Test
    public void test03_Business() throws Exception {
        try {
            BusinessPage businessPage = new BusinessPage();
            businessPage.clickBusiness();
            businessPage.insertPrice("100");
            businessPage.clickChoose();
            ExtentReport.getTest().pass("Business selection was successful");
        } catch (Exception e) {
            e.printStackTrace();
            ExtentReport.getTest().fail("Business selection was  not successful! " + e.getMessage());
        }
    }
//Testing the filling of info and greetings
    @Test
    public void test04_Info() throws Exception {
        try {
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
            ExtentReport.getTest().pass("Info inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            ExtentReport.getTest().fail("Info inserted not successfully! " + e.getMessage());
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        ExtentReport.getTest().log(Status.INFO, "All tests finished");
        ExtentReport.getReporter().flush();
        DriverSingleton.getDriverInstance().quit();
    }

}
