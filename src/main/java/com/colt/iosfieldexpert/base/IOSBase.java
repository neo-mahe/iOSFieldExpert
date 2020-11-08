package com.colt.iosfieldexpert.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;


/*
 * 
 *@author Mahesh Bhakuni
 */
public class IOSBase {

	public static Properties prop;
	public static String USRDIR = System.getProperty("user.dir");
	public static IOSDriver<IOSElement> driver;
	public static Logger logger = LogManager.getLogger(IOSBase.class);



	public IOSBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(USRDIR+ "/src/main/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static IOSDriver<IOSElement> getDriver() throws MalformedURLException {

		DesiredCapabilities d = new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
		d.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
		d.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
		d.setCapability(MobileCapabilityType.APP, USRDIR + prop.getProperty("appPath"));
		driver = new IOSDriver<IOSElement>(new URL ("http://127.0.0.1:4723/wd/hub"), d);
		logger.info("Desired capability has been set for the iOS driver");

		return driver;
	}

	public static Duration getDuration(long timeInSeconds) {

		return Duration.ofSeconds(timeInSeconds);
	}

	public static void clickWebElement(IOSDriver<IOSElement> driver, WebElement element) {
		try {
			element.click();
			logger.info("Clicked on the :"+element);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clearNType(IOSDriver<IOSElement> driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
		logger.info("Entered the value :"+value);
	}
	
   public static void getElementText(IOSDriver<IOSElement> driver, WebElement element) {
	   element.getText();
	   
   }

}
