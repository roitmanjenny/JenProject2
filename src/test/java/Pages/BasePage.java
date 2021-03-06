package Pages;

import Utils.Constants;
import Utils.DriverSingleton;
import Utils.ExtentReport;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;

public class BasePage {
    public static String email = "jenny34@email.com";
    private static String password = "Q1w2e3r4";


    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    //click element by received locator
    public void clickElement(By locator) throws Exception {
        try {
            getWebElement(locator).click();
            ExtentReport.getTest().pass("Element was clicked successfully!");
        } catch (NoSuchElementException e) {
            ExtentReport.getTest().fail("Element was not found!", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(DriverSingleton.getDriverInstance(), Constants.TIMENOW)).build());
        }
    }

    //send keys to element by received locator and the keys
    public void sendKeysToElement(By locator, String text) throws Exception {
        try {
            getWebElement(locator).sendKeys(text);
            ExtentReport.getTest().pass("Content sent successfully!");
        } catch (NoSuchElementException e) {
            ExtentReport.getTest().fail("Element was not found!", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(DriverSingleton.getDriverInstance(), Constants.TIMENOW)).build());
        }
    }

    //find element by received locator
    public WebElement getWebElement(By locator) throws Exception {
        try {
            ExtentReport.getTest().pass("Element found");
        } catch (NoSuchElementException e) {
            ExtentReport.getTest().fail("Element was not found!", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(DriverSingleton.getDriverInstance(), Constants.TIMENOW)).build());
        }
        return DriverSingleton.getDriverInstance().findElement(locator);
    }

    //take screenshot
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
