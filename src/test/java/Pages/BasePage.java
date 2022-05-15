package Pages;

import Utils.Constants;
import Utils.DriverSingleton;
import Utils.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.TakesScreenshot;

public class BasePage {
    public static String email = "jenny20@email.com";
    private static String password = "Q1w2e3r4";

    private static ExtentReports extent = ExtentReport.getReporter();
    public static ExtentTest test = extent.createTest("BuyMe Automation Project", "Website Sanity test");

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public void clickElement(By locator) throws Exception {
        try {
            getWebElement(locator).click();
            test.pass("Element was clicked successfully!");
        } catch (NoSuchElementException e) {
            test.fail("Element was not found!", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(DriverSingleton.getDriverInstance(), Constants.TIMENOW)).build());
        }
    }

    public void sendKeysToElement(By locator, String text) throws Exception {
        try {
            getWebElement(locator).sendKeys(text);
            test.pass("Content sent successfully!");
        } catch (NoSuchElementException e) {
            test.fail("Element was not found!", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(DriverSingleton.getDriverInstance(), Constants.TIMENOW)).build());
        }
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
