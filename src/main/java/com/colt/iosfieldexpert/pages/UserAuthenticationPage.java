package com.colt.iosfieldexpert.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.iosfieldexpert.base.IOSBase;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/*
 * 
 *@author Mahesh Bhakuni
 */
public class UserAuthenticationPage extends IOSBase  {

	public UserAuthenticationPage(IOSDriver<IOSElement> driver) {
		PageFactory.initElements( new AppiumFieldDecorator(driver, getDuration(30)) , this);
	}

	
	

	
	@iOSXCUITFindBy (xpath ="//XCUIElementTypeStaticText[@name=\"Biometric Usage Authentication\"]")
	private IOSElement bioUsageAuthText;
	

	public IOSElement getBioUsageAuthText() {
		return bioUsageAuthText;
	}
	
	 public String checkBioUsageAuthText() {
		   return this.getBioUsageAuthText().getText();
	   }
}


