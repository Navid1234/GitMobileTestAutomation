package MobileTestAutomation.AppiumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import pageobjects.android.FormPage;
import testUtils.BaseTest2;
import org.apache.logging.log4j.*;

public class ProductAddition extends BaseTest2 {
	
	
//	public ProductAddition(AndroidDriver driver) {
	//	      
		// TODO Auto-generated constructor stub
//	}


	@BeforeMethod
	public void setup() {
	 driver.startActivity(new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity" ));	    
	
	}
	
	
     @Test(priority=1)
     public void productSelection() {
    	 
       //  FormPage   fm = new FormPage(driver);
            //  fm.loaderdropdown();
    	   //   fm.scrollToText("Argentina");
    	    //  fm.nameFieldEntry("Test");
    	 //MainActivity
    	 
    Logger log = LogManager.getLogger("LoggerDemo");
 		System.out.println("this is logger demo.");
 		
 		log.info("for info only");
 		log.fatal("fatal msg");

 		log.debug("for debug");
 		log.error("error message");
 		log.warn("warning message");
 		
 		  	 
    	 
    	 
    	 
    	 
   driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();	
  //  driver.findElement(AppiumBy.className("android.widget.Spinner")).click();
String scrollableList = "new UiScrollable(new UiSelector().scrollable(true))";
   String selector = ".scrollIntoView(text(\"Argentina\"))";
   driver.findElement(AppiumBy.androidUIAutomator(scrollableList + selector)).click();
  driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test");   
       driver.hideKeyboard();
	driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
    driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
	driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click(); 
	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    	 
   List<WebElement> productprices  =   driver.findElements(By.id("com.androidsample.generalstore:id/rvCartProductList"));
  // List<WebElement> productprices  = driver.findElements(AppiumBy.className("android.widget.RelativeLayout"));
     int count  = productprices.size();	// $160.47
      System.out.println("the elements size is"+count);
       double sum=0;
     for(int i=0; i<count;i++) {
        String amount  =  productprices.get(i).getText();
        System.out.println("the amount value is" +amount);
        try {
        String amount1  = amount.substring(1);
        System.out.println("the value is" +amount1 );
        double productamount1  = Double.parseDouble(amount1);
           sum =  sum+productamount1; 
           System.out.println("the vaue is" +sum );
        }
          catch (Exception ev) {
        	 // Handle the NoSuchElementException
              System.out.println(" Handle the exception as needed.");
              ev.printStackTrace();   
        	  	   }
    	  }
     String displayedsum  =  driver.findElement(By.xpath("//android.widget.TextView[@text='$ 280.97']")).getText();
     Double dispalyformattedsum  = getFormattedprice(displayedsum); 
     System.out.println("the float price is "+dispalyformattedsum);
       Assert.assertEquals(sum, dispalyformattedsum);	 
    	 
     }
    
    @Test()
    public void webViewTest() {
  //  driver.startActivity(new Activity("com.androidsample.generalstore","com.androidsample.generalstore.CartActivity" ));
     driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();	
    // driver.findElement(AppiumBy.className("android.widget.Spinner")).click();
    String scrollableList = "new UiScrollable(new UiSelector().scrollable(true))";
    String selector = ".scrollIntoView(text(\"Argentina\"))";
       driver.findElement(AppiumBy.androidUIAutomator(scrollableList + selector)).click();
       driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test");   
       driver.hideKeyboard();
    	driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
    	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
    	driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click(); 
    	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    	
    	
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
     // LongPress operation//
   WebElement  longpressmobilelement  = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
    
    ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
    	    "elementId", ((RemoteWebElement)longpressmobilelement ).getId(),"duration",2000));  
        driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        
        
	   
   }
     
 }
