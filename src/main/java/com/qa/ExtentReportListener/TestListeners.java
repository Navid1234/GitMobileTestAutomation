package com.qa.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.List;

import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.ExtentReportListener.ExtentReporterNG;

import io.appium.java_client.AppiumDriver;
import utils.AppiumUtils;

public class TestListeners extends AppiumUtils  implements ITestListener {
	
	   //Define these globally//
	          ExtentReports  extent;
	          ExtentTest test;
	          AppiumDriver driver;
	// Invoke Constructor //           
	// public TestListeners(ExtentReports extent) {
	           //   this.extent = extent;
	         //  }
         
	// ExtentReports  extent  =ExtentReporterSample.getReporterObject();
	     	//ExtentTest test;           
           
	
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
        System.out.println("Test Failed: " + result.getName());
          //Initializes test variable//
        try {
        test = extent.createTest("testWithScreenshot");}
          catch(Exception ev) {
      		ev.printStackTrace();
	  
          }
     //   test = extent.createTest(result.getMethod().getMethodName());    
        // You can add additional logic to handle failures, take screenshots, etc.
       Throwable throwable = result.getThrowable();
        if (throwable != null) {
           System.out.println("Exception: " + throwable.getMessage());
        }
       test.fail(result.getThrowable());
  // Using screenshot code & getting attached to extent Report  
       
    try {
		driver	=  (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
	 try {
			test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(),driver),result.getMethod().getMethodName());
		} catch (Exception ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		}
    	   
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
        System.out.println("Test Suite Finished: " + context.getName());
    	  //extent.flush();
    }
}
	


