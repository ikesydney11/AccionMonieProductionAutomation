package Utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;

public class listenerClass implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(STR."Test started: \{result.getMethod().getMethodName()}");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(STR."Test passed: \{result.getMethod().getMethodName()}");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(STR."Test failed: \{result.getThrowable()}");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished.");
        extentreports.getInstance().flush();

    }
}
