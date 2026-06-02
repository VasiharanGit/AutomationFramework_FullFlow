package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String reportPath =
                System.getProperty("user.dir")
                + "/Reports/TestReport.html";

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(reportPath);

        reporter.config()
                .setReportName("Automation Report");

        reporter.config()
                .setDocumentTitle("Framework Execution Report");

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo(
                "Tester",
                "Vasiharan");

        return extent;
    }
}