package com.colt.iosfieldexpert.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.Assert;
/*
 * 
 *@author Mahesh Bhakuni
 */
public class TestElements  {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
 
		DesiredCapabilities d = new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11" );
		d.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.1");
		d.setCapability(MobileCapabilityType.APP, "/Users/maheshbhakuni/Desktop/Mahesh/eclipse-workplace/iOSFieldExpert/src/main/resources/Apps/FieldExpert.app");

		
		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL ("http://127.0.0.1:4723/wd/hub"), d);
 
		driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='User ID']")).sendKeys("coldtonlinedcp");
		driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@value='Password']")).sendKeys("Coslt@1234");
		
		System.out.println("Checking if hide password is enabled: "+driver.findElement(By.xpath("//XCUIElementTypeButton[@name='hide password']")).isEnabled());

		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='hide password']")).click();

		System.out.println("After clicking on hide password,Checking with show password element if show password is enabled: "+driver.findElement(By.xpath("//XCUIElementTypeButton[@name='hide password'][@value='1']")).isEnabled());

		System.out.println("checking with remember me unselected element" + driver.findElement(By.xpath("//XCUIElementTypeStaticText[normalize-space(@name)='Remember Me']")).isSelected());

		System.out.println("Text is :"+ driver.findElement(By.xpath("//XCUIElementTypeStaticText[normalize-space(@name)='Remember Me']")).getText());
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[normalize-space(@name)='Remember Me']")).click();
		System.out.println("now user has clicked on remember me");		 

	System.out.println("checking with selected remember me element" + driver.findElement(By.xpath("//XCUIElementTypeButton[normalize-space(@name)='Remember Me'][@value='1']")).isSelected());
driver.findElementByName("Done").click(); 
	
	System.out.println("checking the text for don't have account :"+driver.findElementByXPath("//XCUIElementTypeButton[contains(@name,'Sign up')]").getText());
	 

//		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Login']")).click();
// 		 
//String errorMsg= "Invalid ColtOnline User. Use \"username@internal.colt.net\" to login with internal account(s).";
//		String actMsg = driver.findElement(By.xpath("//XCUIElementTypeStaticText[normalize-space(@name)='Invalid ColtOnline User. Use \"username@internal.colt.net\" to login with internal account(s).'][@name='Alert!']")).getText();
// 		Assert.assertEquals(actMsg, errorMsg);

//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\\\" Remember Me\\")));
 
         
         //Java has AppiumDriver.hideKeyboard().


	


 
	}

}
