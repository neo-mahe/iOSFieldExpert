package com.colt.iosfieldexpert.testcases;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.colt.iosfieldexpert.base.IOSBase;
import com.colt.iosfieldexpert.pages.LoginPage;
import com.colt.iosfieldexpert.pages.UserAuthenticationPage;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

/*
 * 
 *@author Mahesh Bhakuni
 */
public class LoginPageTest extends IOSBase {
	LoginPage loginPage;
	UserAuthenticationPage userAuthenticationPage;
	IOSDriver<IOSElement> driver;
	public static Logger logger = LogManager.getLogger(LoginPageTest.class);
	

	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws MalformedURLException
	{
		driver = getDriver();
		loginPage=new LoginPage(driver);
		userAuthenticationPage=new UserAuthenticationPage(driver);

	}

	@Test(priority=0)
	public void validateLogoTest() {
		logger.info("Test case - Logo validation");
		boolean flag = loginPage.checkLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority=2)
	public void userNameLabelTest() {
		logger.info("Test case - Username label text validation");
		String useridLabel = loginPage.checkUsernameLabel();
		Assert.assertEquals(useridLabel, "Username");
	}
	
	@Test(priority=3)
	public void userIDPlHdTest() {
		logger.info("Test case - UserId inputbox placeholder text validation");
		String useridPlHd = loginPage.checkUsridInbxPlaceholderTxt();
		Assert.assertEquals(useridPlHd, "User ID");
	}
	
	@Test(priority=4)
	public void pwdLabelTest() {
		logger.info("Test case - Password label text validation");
		String pwdLabel = loginPage.checkPasswordLabel();
		Assert.assertEquals(pwdLabel, "Password");
	}
	
	@Test(priority=5)
	public void pwPlHdTest() {
		logger.info("Test case - Password inputbox placeholder text validation");
		String pwPlHd = loginPage.checkPwdInbxPlaceholderTxt();
		Assert.assertEquals(pwPlHd, "Password");
	}
	
	@Test(priority=6)
	public void hidePwdIconTest() {
		logger.info("Test case - Hide password icon validation");
		boolean hidePwd = loginPage.checkHidePasswordIcon();
		Assert.assertTrue(hidePwd);
		
	}
	@Test(priority=7)
	public void rememberMeLabelTest() {
		logger.info("Test case - Remember me label text validation");
		String reMeLbl = loginPage.checkRememberMeText();
		Assert.assertEquals(reMeLbl, "  Remember Me");
	}
	
	@Test(priority=8)
	public void rememberMeUncheckedTest() {
		logger.info("Test case - Remember me check box validation");
		boolean reMeUnchecked = loginPage.isRememberMeChkBxUnchecked();
		Assert.assertFalse(reMeUnchecked);
	}
	
	@Test(priority=9)
	public void loginLabelTest() {
		logger.info("Test case - Login label text validation");
		String loginLbl = loginPage.checkLoginText();
		Assert.assertEquals(loginLbl, "Login");
	}
	
	@Test(priority=10)
	public void termsConditionLabelTest() {
		logger.info("Test case - Terms & conditons label text validation");
		String termsCondLbl = loginPage.checkTermsConditionText();
		Assert.assertEquals(termsCondLbl, "By logging in you agree to the Terms Of Use and to our Privacy and Cookie Policy. You may select to change your browser setting and restrict cookies.");
	}
	
	@Test(priority=11)
	public void signUpLabelTest() {
		logger.info("Test case - Sign up label text validation");
		String signUpLbl = loginPage.checkSignUp();
		Assert.assertEquals(signUpLbl, "Don't have an account? Sign up");
	}
	

	@Test(priority=12)
	public void validCredsLogin() throws InterruptedException {
		logger.info("Test case - Valid user credentials login validation");
		loginPage.validLogin(driver, "cowltonlinedcp", "Cowlt@1234");
		String authTxt = "Biometric Usage Authentication";
		Assert.assertEquals(userAuthenticationPage.checkBioUsageAuthText(), authTxt);

	}


}
