package MobileTestAutomation.AppiumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import testUtils.BaseTest2;

public class GeneralStoreTestScenarios extends BaseTest2 {
	
	
	 //public GeneralStoreTestScenarios(AndroidDriver driver) {
//		super(driver);
	//	this.driver=driver;
		// TODO Auto-generated constructor stub
//	}


	@BeforeMethod
	public void setup() {
	 driver.startActivity(new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity" ));	    
	
	}
	
	
    @Test( priority=2,dataProvider="getData")
	public void formFillingTest(HashMap<String,String> input ) {
	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
    //   mobileScroll("Argentina");
    		
	String scrollableList = "new UiScrollable(new UiSelector().scrollable(true))";
	String selector = ".scrollIntoView(text(\""+input.get("CountryName")+"\"))";
    driver.findElement(AppiumBy.androidUIAutomator(scrollableList + selector)).click();

 // driver.findElement(By.xpath("//android.widgdet.TextView[@text='Argentina']")).click();  
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test");
	driver.hideKeyboard();
	driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	//driver.pressKey( new KeyEvent(AndroidKey.HOME));
//String toastmessage	 = driver.findElement(By.xpath("//(android.widgdet.Toast)[1]")).getAttribute("name");
	String toastmessage  = driver.findElement(AppiumBy.className("android.widget.FrameLayout")).getAttribute("name");
	Assert.assertEquals(toastmessage, "Please enter your name");
	System.out.println("The Test passed sucessfully");
	driver.pressKey( new KeyEvent(AndroidKey.HOME));
	}
	
  	@Test(priority=1, dataProvider="getData")
  	public void productListing(HashMap<String,String> input ) {
  		
   //driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();	
          driver.findElement(AppiumBy.className("android.widget.Spinner")).click();
 String scrollableList = "new UiScrollable(new UiSelector().scrollable(true))";
    String selector = ".scrollIntoView(text(\""+input.get("CountryName")+"\"))";
    driver.findElement(AppiumBy.androidUIAutomator(scrollableList + selector)).click();
    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(input.get("Name"));   
    driver.hideKeyboard();
	driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	String scrollablelist = "new UiScrollable(new UiSelector().scrollable(true))";
    String selectorx = ".scrollIntoView(text(\"Jordan 6 Rings\"))";
    driver.findElement(AppiumBy.androidUIAutomator(scrollablelist + selectorx)).click();
    
     int productcount =  driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
       System.out.println("productcount");
           try {
       for(int i=0;i<productcount; i++) {
  String productname = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();    
    	 if(productname.equalsIgnoreCase("Jordan 6 Rings")) {
    		   
    		 driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
    	 }
       }
           }
    	   catch (Exception ev ) {
    		  System.out.println("Handle the Exception as needed");
    		  ev.printStackTrace();
    	  }
    	 
           
       driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click(); 
      // driver.pressKey( new KeyEvent(AndroidKey.HOME)); 
       
      // put Explicit wait//
 //     WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(5));
  //   wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
       
     
   String productname =  driver.findElement(By.xpath("//android.widgdet.TextView[@text='Jordan 6 Rings']")).getText();
           System.out.println("productname");
       Assert.assertEquals("productname", "Jordan 6 Rings");
       
     }
  	
  	
  	
  	// Invoke Data Driven Testing using DataProvider 
  	
      //     @DataProvider
//        public Object[][] getData() {
        	
       //  return   new Object[][]  {{ "Argentina","Test"},{"Argentina","NavidTest"}};   	
        	
    //    }
  	
  	
  // Invoke Method 2 Object Mapper For Data Driven Testing 
           
           @DataProvider
           public Object[][] getData() throws IOException {
        
    List<HashMap<String,String>>  data = getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//General.json");	   
        	   
          return   new Object[][]  {{data.get(0) },{data.get(1)}};   	
           	
           }
     	     
  	
  	
  	
  	
  	
  	
	
}
