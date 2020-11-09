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
public class LoginPage extends IOSBase {

	public LoginPage(IOSDriver<IOSElement> driver) {
		PageFactory.initElements( new AppiumFieldDecorator(driver, getDuration(30)) , this);
	}



	@iOSXCUITFindBy (xpath ="//XCUIElementTypeImage[@name='LoginScreenBanner']")
	private IOSElement logo;


	@iOSXCUITFindBy (xpath ="//XCUIElementTypeStaticText[@name='Username']")
	private IOSElement usernameLabel;


	@iOSXCUITFindBy (xpath ="//XCUIElementTypeTextField[@value='User ID']")
	private IOSElement userIDPlaceHolder;


	@iOSXCUITFindBy (xpath ="//XCUIElementTypeStaticText[@name='Password']")
	private IOSElement passwordLabel;


	@iOSXCUITFindBy (xpath ="//XCUIElementTypeSecureTextField[@value='Password']")
	private IOSElement passwordPlaceHolder;


		@iOSXCUITFindBy (xpath ="//XCUIElementTypeButton[@name='hide password']")
		private IOSElement hidePasswordIcon;
		

	@iOSXCUITFindBy (xpath ="//XCUIElementTypeButton[@name='hide password'][@value='1']")
	private IOSElement showPasswordIcon;


	@iOSXCUITFindBy (xpath ="//XCUIElementTypeButton[normalize-space(@name)='Remember Me']")
	private IOSElement disabledRememberMeCheckBox;

	@iOSXCUITFindBy (xpath ="//XCUIElementTypeButton[normalize-space(@name)='Remember Me'][@value='1']")
	private IOSElement enabledRememberMeCheckBox;


	@iOSXCUITFindBy (xpath ="//XCUIElementTypeStaticText[normalize-space(@name)='Remember Me']")
	private IOSElement rememberMeButton;


	@iOSXCUITFindBy (xpath ="//XCUIElementTypeButton[@name='Login']")
	private IOSElement logInButton;


	@iOSXCUITFindBy (xpath ="//XCUIElementTypeStaticText[@name='Forgot Password?']")
	private IOSElement forgotPasswordButton;

//	@iOSXCUITFindBy (xpath ="//XCUIElementTypeButton[@name='By logging in you agree to the Terms Of Use and to our Privacy and Cookie Policy. You may select to change your browser setting and restrict cookies.']")
	@iOSXCUITFindBy (xpath ="//XCUIElementTypeButton[contains(@name,'By logging in you agree to the')]")
	private IOSElement termsOfUsenPrivacy;

	@iOSXCUITFindBy (xpath ="//XCUIElementTypeButton[contains(@name,'Sign up')]")
	private IOSElement signUpLabel;
	
	
	public IOSElement getLogo() {
		return logo;
	}

	public IOSElement getUsernameLabel() {
		return usernameLabel;
	}

	public IOSElement getUserIDPlaceHolder() {
		return userIDPlaceHolder;
	}


	public IOSElement getPasswordLabel() {
		return passwordLabel;
	}

	public IOSElement getPasswordPlaceHolder() {
		return passwordPlaceHolder;
	}

		public IOSElement getHidePasswordIcon() {
			return hidePasswordIcon;
		}

	public IOSElement getShowPasswordIcon() {
		return showPasswordIcon;
	}

	public IOSElement getDisabledRememberMeChkBx() {
		return disabledRememberMeCheckBox;
	}

	public IOSElement getEnabledRememberMeChkBx() {
		return enabledRememberMeCheckBox;
	}



	public IOSElement getRememberMeButton() {
		return rememberMeButton;
	}

	public IOSElement getLogInButton() {
		return logInButton;
	}

	public IOSElement getForgotPasswordButton() {
		return forgotPasswordButton;
	}

	public IOSElement getTermsOfUsenPrivacy() {
		return termsOfUsenPrivacy;
	}

	public IOSElement getSignUpLabel() {
		return signUpLabel;
	}



	//Behaviour
	// Get the boolean value for the enabled logo
	public boolean checkLogo() {
		return this.getLogo().isEnabled();
	}

	// Get the text for Username label 

	public String checkUsernameLabel() {
		return this.getUsernameLabel().getText();
	}

	// Get the text for userid inputbox place holder 
	public String checkUsridInbxPlaceholderTxt() {
		return this.getUserIDPlaceHolder().getText();
	}

	// Get the text for password label 
	public String checkPasswordLabel() {
		return this.getPasswordLabel().getText(); 
	}

	// Get the text for password inputbox place holder 
	public String checkPwdInbxPlaceholderTxt() {
		return this.getPasswordPlaceHolder().getText();
	}


	// check if hidepassword icon is enabled
	
	public boolean checkHidePasswordIcon() {
		return this.getHidePasswordIcon().isEnabled();
	}
	
	// check if showpassword icon is enabled
	
	public boolean checkShowPasswordIcon() {
		return this.getShowPasswordIcon().isEnabled();
	}

	// Get the rememberme text
	public String checkRememberMeText() {
		return this.getRememberMeButton().getText();
	}

	// check if rememberme checkbox is checked
	public boolean isRememberMeChkBxChecked() {
		return this.getEnabledRememberMeChkBx().isSelected();

	}
	
	// check if rememberme checkbox is unchecked
	public boolean isRememberMeChkBxUnchecked() {
		return this.getDisabledRememberMeChkBx().isSelected();

	}

	public String checkLoginText() {
		return this.getLogInButton().getText();
	}

	public String checkTermsConditionText() {
		return this.getTermsOfUsenPrivacy().getText();
	}

	public String checkSignUp() {
		return this.getSignUpLabel().getText();
	}

	public UserAuthenticationPage validLogin(IOSDriver<IOSElement> driver, String username, String password ) {
		this.getUserIDPlaceHolder().sendKeys(username);
		this.getPasswordPlaceHolder().sendKeys(password);
		hideKeyboard();
		this.getHidePasswordIcon().click();
		this.getRememberMeButton().click();
		this.getLogInButton().click();
		return new UserAuthenticationPage(driver);

	}



}
