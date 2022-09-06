package library;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

    private static final String reportsFolderPATH = "./output-tests/reports/";
    private static final String reportName = "report.html";

    private ExtentSparkReporter report = new ExtentSparkReporter(reportsFolderPATH + reportName);
    private ExtentReports logger = new ExtentReports();
    private ExtentTest test;

    private String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.attachReporter(report);
        String testName = getTestMethodName(iTestResult);
        this.test = logger.createTest(testName);
        this.test.log(Status.INFO, "Test " + testName + " started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        this.test.log(Status.PASS, getTestMethodName(iTestResult) + " test is succeed.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String testName = getTestMethodName(iTestResult);
        String failMessage = iTestResult.getThrowable().getMessage();
        String screenShortPath = Utilities.getScreenShot(testName);
        String projectPath = System.getProperty("user.dir");
        this.test.log(Status.FAIL, failMessage);
        this.test.addScreenCaptureFromPath(projectPath + screenShortPath)
            .fail(MediaEntityBuilder.createScreenCaptureFromPath(projectPath + screenShortPath)
            .build());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        this.test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.flush();
    }
}
