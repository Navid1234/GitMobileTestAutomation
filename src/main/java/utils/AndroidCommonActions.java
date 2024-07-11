package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidCommonActions extends AppiumUtils {
	
	public AndroidDriver driver;
	public AndroidCommonActions(AndroidDriver driver)
	{
	   
		  this.driver=driver;  
	}


	
	@Test(enabled=false)
	public void mobileLongPress() {
		
		//driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
    WebElement element =  driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
    
         //LongPress action:
         ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
    	    "elementId", ((RemoteWebElement) element).getId(),"duration",2000));
    	
		}
	
	   
	   @Test(enabled=false)
	   public void mobileScrollingDefault() {
		   driver.findElement(AppiumBy.accessibilityId("App")).click();	
	 //driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();	   
	   // Scroll Action:
	 boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		   
		 }
	   
	   @Test
	public void mobileSwipingTest() {
			
			  driver.findElement(AppiumBy.accessibilityId("Views")).click();	   
	       // driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();   	
			driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
			driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		  WebElement	image  = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		 String  actualvalue  =  driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable");        
		        Assert.assertEquals(actualvalue, true);
		     //Swipe Action
		        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", 
		        		((RemoteWebElement)image ).getId(),"duration",2000,
		        	    
		        	    "direction", "left",
		        	    "percent", 0.75
		        	));  
		        
		  Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),true);     
		        
		}  
	
	     public void scrollToText( String text) {
		 String scrollableList = "new UiScrollable(new UiSelector().scrollable(true))";
		 String selector = ".scrollIntoView(text(\""+text+"\"))";
		 driver.findElement(AppiumBy.androidUIAutomator(scrollableList + selector)).click();
		}
	
	
	
}
