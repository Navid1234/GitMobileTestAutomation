package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

        public class AppiumUtils  {
	//Invoke Constructor to give life to driver
	
	// public AndroidDriver driver;
	 
	//	public AppiumUtils( AndroidDriver driver) {
		     
		//	this.driver= driver;
	//	}

	// MultiLevel Inheritance--GrandParent(AppiumUtils)-->AndroidCommonActions(Parent)-->FormPage(Child)
	 
	        public Double getFormattedprice(String amount) {
	        	
		  Double price =  Double.parseDouble(amount.substring(1));
		     return price;
		    	}
		    
	       public void waitForElementToAppear(WebElement Ele, AppiumDriver driver) {
 // put Explicit wait//
     WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      wait.until(ExpectedConditions.attributeContains((Ele), "text", "Cart")); 
      
     
		             	}
	       
	       
       // JSON  Based UTility using object Mapper & File Utils class  used for Data Driven Testing 
       //C:\Users\DELL\eclipse-workspace\AppiumFrameworkDesign\src\test\java\testData\Ecommerce.json	
//new File(System.getProperty("user.dir")+"//src//test//java//testData//Ecommerce.json	
	    // Here  Convert   JSON->JSON String , JSON String -->HashMap 
	       
	  public  List<HashMap<String , String>> getJsonData(String JsonFilePath) throws IOException {
		//convert jSON file to JSON String   
String Jsoncontent  = FileUtils.readFileToString(new File(JsonFilePath));	  
              //Initialize ObjectMapper

            ObjectMapper objectMapper = new ObjectMapper();
 List<HashMap<String,String>> data  =  objectMapper.readValue(Jsoncontent,new TypeReference<List<HashMap<String,String>>>() {
					});   
		  
		  return data;
		  
		  }
	  
	  //***********  Screen Shot common utility **********************// 
	  
	public String getScreenShotPath(String testcaseName,AppiumDriver driver) throws IOException {
      File source  =  driver.getScreenshotAs(OutputType.FILE);
     String destinationFile  =   System.getProperty("user.dir")+"//target"+testcaseName+".png";
         FileUtils.copyFile(source, new File(destinationFile)); 
          return destinationFile;
	
	       }
	       
	       
	       
	        
	
}
