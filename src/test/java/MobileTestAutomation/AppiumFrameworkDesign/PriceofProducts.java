package MobileTestAutomation.AppiumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import testUtils.BaseTest2;

public class PriceofProducts extends BaseTest2{

	@Test(priority=1, description="Verifying prices of products in decimal value", groups= {"Smoke"})
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description:Verifying the prices of two products in decimal value")
	@Story("MTA_7645 : To check Prices of two Products")
    public void webPriceViewTest() {
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

	
	
	
	
	
	
