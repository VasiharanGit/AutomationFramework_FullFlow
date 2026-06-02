package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Reports.ExtentManager;
import Utilities.ScreenshotUtil;
public class FrameworkListener implements ITestListener {
	ExtentReports extent =
	        ExtentManager.getReportObject();

	ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Execution Started");
    }

    @Override
    public void onFinish(
            ITestContext context) {

        extent.flush();

        System.out.println(
                "Execution Finished");
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getName());

        System.out.println(
                "Started : "
                + result.getName());
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        test.pass("Test Passed");

        System.out.println(
                "Passed : "
                + result.getName());
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        String path =
                ScreenshotUtil
                .captureScreenshot(
                        result.getName());

        test.fail(result.getThrowable());

        test.addScreenCaptureFromPath(
                path);

        System.out.println(
                "Failed : "
                + result.getName());
    }

    @Override
    public void onTestSkipped(
            ITestResult result) {

        test.skip("Test Skipped");
    }
}