import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    public static ExtentReports extent;
    public static ExtentSparkReporter htmlReporter;

    public static synchronized ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports();
            htmlReporter = new ExtentSparkReporter("/Users/jennyroitman/Library/CloudStorage/OneDrive-IgentifyLtd/JennyR/IdeaProjects/JenProject2/extent.html");
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}
