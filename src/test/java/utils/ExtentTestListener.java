package utils;

import base.BaseTest;
import org.testng.*;
import com.aventstack.extentreports.*;


public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getReport();

    // Thread-safe ExtentTest (IMPORTANT)
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);

        LoggerUtil.log("STARTED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("✅ Test Passed");
        LoggerUtil.log("PASSED: " + result.getMethod().getMethodName());
    }

@Override
public void onTestFailure(ITestResult result) {

    BaseTest base = (BaseTest) result.getInstance();

    String path = ScreenshotUtils.capture(
            base.driver,
            result.getMethod().getMethodName()
    );

    test.get().fail(result.getThrowable());
    test.get().addScreenCaptureFromPath(path);
    LoggerUtil.log("FAILED: " + result.getMethod().getMethodName());}



    
    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("⚠ Test Skipped");
        LoggerUtil.log("SKIPPED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        LoggerUtil.log("=== TEST SUITE STARTED ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        LoggerUtil.log("=== TEST SUITE FINISHED ===");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
}