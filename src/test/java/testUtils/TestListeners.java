package testUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListeners implements ITestListener {
	//Define these globally//
	ExtentReports  extent  =ExtentReporterNG.getReporterObject();
	ExtentTest test;
	
	@Override
    public void onTestStart(ITestResult result) {
      //  System.out.println("Test Started: " + result.getName());
	  test =  extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	test.log(Status.PASS, "The test is passed sucessfully");
       //System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
      //  System.out.println("Test Failed: " + result.getName());
        // You can add additional logic to handle failures, take screenshots, etc.
      //  Throwable throwable = result.getThrowable();
       // if (throwable != null) {
           // System.out.println("Exception: " + throwable.getMessage());
    	
    	   test.fail(result.getThrowable());
    	
    	
        }
    

    // Other methods of ITestListener

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Method executed if a test fails but is within success percentage
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
       // System.out.println("Test Suite Finished: " + context.getName());
    	extent.flush();
    }
}
	


