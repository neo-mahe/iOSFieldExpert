package com.colt.iosfieldexpert.base;

import java.io.File;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer extends IOSBase{
	Logger logger = LogManager.getLogger(AppiumServer.class);
	///logs/AppiumLog.txt
	public static String USRDIR = System.getProperty("user.dir");
	public static String nodePath = "/usr/local/bin/node";
	public static String appiumJSPath = "/usr/local/lib/node_modules/appium/build/lib/main.js"; 
	public static AppiumDriverLocalService service;
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
    @BeforeTest
	public void startServer() throws InterruptedException {
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodePath))
				.withAppiumJS(new File(appiumJSPath))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.withLogFile(new File(USRDIR + "/logs/AppiumLog.txt")));
		logger.info("Starting the appium server at :"+df.format(new Date()));

		service.start();
		Thread.sleep(10000);
		
	}
	@Test(priority=0)	
	public void testServer() {
		System.err.println("The url is :"+service.getUrl().toString());
		System.err.println("Is service running :"+service.isRunning());
		

	}
	
	@Test(priority=1)	
	public static void launchDriver() throws MalformedURLException, InterruptedException {
		getDriver();

	}
	
	@AfterTest
	public void stopServer() {
		if (service.isRunning()==true) {
			service.stop();
			logger.info("Stopping the appium server at :"+df.format(new Date()));
			
		}
	}
}
