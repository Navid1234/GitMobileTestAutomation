package MobileTestAutomation.AppiumFrameworkDesign;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pageobjects.android.FormPage;
import testUtils.BaseTest2;

public class ProductFormPage extends BaseTest2 {
	
	// public ProductFormPage(AndroidDriver driver) {
	//	super(driver);
		// TODO Auto-generated constructor stub
	//}

	@Test()
    public void productSelection() {
   	 
        FormPage   fm = new FormPage(driver);
          fm.loaderdropdown();
   	      fm.scrollToText("Argentina");
   	      fm.nameFieldEntry("Test");
   	      fm.setGender();
   	      fm.textBoxSelection();
   	      
   	      
	
	}
}
