package testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	 public static  ExtentReports extent ;
	  public  static  ExtentReports getReporterObject() {
		  
	String path = System.getProperty("user.dir"+"//reports//index.html");
	// ExtentReports & ExtentSparkReporter are 2 classes******//
	
	   ExtentSparkReporter  reporter = new ExtentSparkReporter(path);
	   reporter.config().setReportName("MobileAutomationTestResults");
	   reporter.config().setDocumentTitle("TestResults");
	   
	   extent= new ExtentReports();
	   extent.attachReporter(reporter);
	   extent.setSystemInfo("Tester", "Navid Jan");
		  return extent;
	  }
	
	
	
	
	
	
	
}
