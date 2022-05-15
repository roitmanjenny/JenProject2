import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.TakesScreenshot;

public class BasePage {
    public static String email = "jenny12@email.com";
    private static String password = "Q1w2e3r4";

    private static ExtentReports extent = ExtentReport.getReporter();
    private static ExtentTest test = extent.createTest("BuyMe Automation Project", "Website Sanity test");

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public void clickElement(By locator) throws Exception {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) throws Exception {
        getWebElement(locator).sendKeys(text);
    }

    public WebElement getWebElement(By locator) throws Exception {
        try {
            test.pass("Element found");
        } catch (NoSuchElementException e) {
            test.fail("Element was not found!", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(DriverSingleton.getDriverInstance(), Constants.TIMENOW)).build());
        }
        return DriverSingleton.getDriverInstance().findElement(locator);
    }

    private static String takeScreenShot(WebDriver driver, String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }
}
