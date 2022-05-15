package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    public static ExtentReports extent;
    public static ExtentSparkReporter htmlReporter;
    public static ExtentTest test;

    //creating and getting test instance once
    public static synchronized void createTest(String name, String description) {
        test = ExtentReport.getReporter().createTest(name, description);
    }

    public static synchronized ExtentTest getTest() {
        return test;
    }

    public static synchronized ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports();
            htmlReporter = new ExtentSparkReporter("/Users/jennyroitman/Library/CloudStorage/OneDrive-IgentifyLtd/JennyR/IdeaProjects/JenProject2/extent.html");
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}
