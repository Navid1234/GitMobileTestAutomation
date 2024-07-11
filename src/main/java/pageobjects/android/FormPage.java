package pageobjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidCommonActions;

public class FormPage extends AndroidCommonActions {

	      
	 public AndroidDriver driver;
	 
	public FormPage( AndroidDriver driver) {
	      super(driver);
		this.driver= driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	@AndroidFindBy(className="android.widget.Spinner")
	private static WebElement spinner;
	
	@AndroidBy(id="com.androidsample.generalstore:id/nameField")
	private static WebElement namefield;
	
	@AndroidBy(id="com.androidsample.generalstore:id/radioMale")
	private static WebElement radiobutton;
	
	@AndroidBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private static WebElement textboxletsshop;
	
	
	
	public void textBoxSelection() {
		  textboxletsshop.click();
		}
	
	public void setGender() {
		radiobutton.click(); 
	    }
	
	
	public void loaderdropdown() {
	   spinner.click();
	   }
	
	public void setCountrySelection( String CountryName) {
		//spinner.click();
		   scrollToText(CountryName);
		  //driver.hideKeyboard();
		}
     
	public void nameFieldEntry( String Name) {
	     namefield.sendKeys(Name);	
	      driver.hideKeyboard();
	    	}
	
	
	
	
	
	
	
}
