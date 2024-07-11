package testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import utils.AppiumUtils;

public class BaseTest2 extends AppiumUtils {
	
	public AndroidDriver driver;
	
//	public BaseTest2(AndroidDriver driver)
	//{
		// super(driver);
		//  this.driver=driver;  
//}
	
	
	
	

	public URL  appiumServerURL;
	public AppiumDriverLocalService service;
	//public AppiumDriver driver ;
	//public AndroidDriver driver;
	
	
	@BeforeClass(alwaysRun =true)
	public void appiumConfigure() throws IOException {
      //URL   appiumServerURL;
		//**********  Use Global Properties from data.properties ****************//
		
		Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties")	;
		prop.load(fis);
	String AndroidDeviceName =prop.getProperty("AndroidDeviceName");
	 String AppiumServerURL =  prop.getProperty("AppiumServerURL");  
		
   		
        try {
        appiumServerURL = new URL(AppiumServerURL);
    } catch (MalformedURLException e) {
        e.printStackTrace();
        return;
    }
		
		
		
		
		//(1) Desired capabalities set
        
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	     desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	     desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,AndroidDeviceName ); // Replace with your emulator/device name
	     desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore"); // Replace with the target app's package name
	     desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.MainActivity"); // Replace with the target app's main activity
	     desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true); // Preserve App data between sessions
	     desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // Set the automationName to UiAutomator2
	     // Set the path to your APK file
	     desiredCapabilities.setCapability(MobileCapabilityType.APP,(System.getProperty("user.dir")+"//src//test//java//resources//General-Store.apk")); // Replace with the path to your APK file
	     desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
	     
	  // desiredCapabilities.setCapability("adbExecTimeout", "60000");
		
		
		
		
		// (2)  Start Appium server with default options
         service = AppiumDriverLocalService.buildDefaultService();
         service.start();
          // Get the Appium server URL
        System.out.println("Appium Server URL: " + service.getUrl());
        
        // (3) Create an instance of the AndroidDriver
         driver = new AndroidDriver(appiumServerURL, desiredCapabilities);
       
        
         // (4) test code here:
        driver.manage().timeouts().implicitlyWait(20, java.util.concurrent.TimeUnit.SECONDS);
        
		
	}
	// Reusable method for scroll//
	
	    public void mobileScroll(String targettext) {
	    String scrollableList = "new UiScrollable(new UiSelector().scrollable(true))";
	    String selector = ".scrollIntoView(text(\"targettext\"))";
	    
	 // Construct the full scroll script
        String scrollScript = scrollableList+selector ;
	     driver.findElement(AppiumBy.androidUIAutomator(scrollScript)).click();	
	    	
	    }
	    
	    public Double getFormattedprice(String amount) {
	  Double price =  Double.parseDouble(amount.substring(1));
	     return price;
	    	
	    	
	    }
	    
	
	    @AfterClass(alwaysRun =true)
	    public void teardown() {
	       driver.quit();
	       service.stop();
			
 }
	
	
	
	
	
	
}
