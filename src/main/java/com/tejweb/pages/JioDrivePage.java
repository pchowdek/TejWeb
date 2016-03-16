package com.tejweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.tejweb.generics.*;

public class JioDrivePage {
	
	Utility utility = new Utility();
	
	/**
	 * Locators from JioDrive Page
	 */
	
	@FindBy(xpath="//a[text()='LOGIN']")
	private WebElement loginLink;
	
	@FindBy(xpath="//span[@class='brandname']")
	private WebElement brandName;
	
	@FindBy(xpath="//h3[contains(text(),'Conduct your')]")
	private WebElement punchLine;
	
	@FindBy(xpath="//img[@alt='logo.png']")
	private WebElement logo;
	
	// selector not working
	@FindBy(xpath="(//div[@class='modal-body signup-modal-body']//button)[1]")
	private WebElement closePopup;
	
	@FindBy(xpath="//p[@class='errorBlock']")
	private WebElement invalidUsernameErrMSG;
	
	@FindBy(xpath="//p[contains(text(),'Password is incorrect')]")
	private WebElement invalidPasswordErrMSG;
	
	@FindBy(id="signinButton")
	private WebElement googleSignin;
	
	@FindBy(xpath="(//input[@ng-model='emailId'])[1]")
	private WebElement emailTB;
	
	@FindBy(xpath="//input[@ng-model='password']")
	private WebElement passwordTB;
	
	@FindBy(xpath="//button[text()='LOGIN']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//a[text()='SIGN UP']")
	private WebElement signUpLink;
	
	@FindBy(className="backToSignIn")
	private WebElement backToSigninLink;
	
	@FindBy(name="fullName")
	private WebElement fullNameTB;
	
	@FindBy(xpath="//p[contains(text(),'full name')]")
	private WebElement fullNameErrMsg;
	
	@FindBy(xpath="(//input[@name='registerEmail'])[1]")
	private WebElement registerMailTB;
	
	@FindBy(xpath="//p[contains(text(),'Enter a valid email')]")
	private WebElement registerMailErrMsg;
	
	@FindBy(xpath="(//p[contains(text(),'Please enter your email address.')])[2]")
	private WebElement registerMailErrMsg2;
		
	@FindBy(xpath="(//input[@ng-model='userDataRegister.password'])[1]")
	private WebElement registerPWDTB;
	
	@FindBy(xpath="//p[text()='Please enter a password.']")
	private WebElement passwordTBErrMsg1;
	
	@FindBy(xpath="//p[text()='Your password must not contain spaces.']")
	private WebElement passwordTBErrMsg2;
	
	@FindBy(xpath="//p[text()='Password must be at least 8 characters long.']")
	private WebElement passwordTBErrMsg3;
	
	@FindBy(xpath="//p[text()='The password you have entered is too long.']")
	private WebElement passwordTBErrMsg4;
	
	@FindBy(xpath="//p[text()='Spaces cannot be used at the beginning or end of your password.']")
	private WebElement passwordTBErrMsg5;
	
	@FindBy(xpath="(//input[@name='confirmPassword'])[1]")
	private WebElement confirmPWDTB;
	
	@FindBy(xpath="//p[text()='Please confirm password.']")
	private WebElement confirmPWDMsg;
	
	@FindBy(xpath="//p[text()='Password not matching.']")
	private WebElement confirmPWDErrMsg;
	
	@FindBy(xpath="//button[@data-toggle='dropdown']")
	private WebElement countryCodeDD;
	
	@FindBy(xpath="(//input[@ng-model='userDataRegister.phoneNumber'])[1]")
	private WebElement mobileNumTB;
	
	@FindBy(xpath="//p[contains(text(),'Enter a valid email')]")
	private WebElement mobileNumErrMsg;
	
	@FindBy(xpath="//button[text()='CREATE']")
	private WebElement createAccountBTN;
	
	@FindBy(id="Email")
	private WebElement googleUNTB;
	
	@FindBy(id="next")
	private WebElement googleNextBTN;
	
	@FindBy(id="Passwd")
	private WebElement googlePassTB;
	
	@FindBy(id="signIn")
	private WebElement googleSiginBTN;
	
	@FindBy(id="submit_approve_access")
	private WebElement googleAccessApproveBTN;
	
	
	/**
	 * Lazy initialization
	 * @param driver
	 */
		
public JioDrivePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}

/**
 * Methods pertaining to JioDrivePage
 */
	

/**
 * Clicks on the login link on the top right
 * @throws InterruptedException
 */

	public void clickLoginLink() throws InterruptedException{
		try{loginLink.click();
		Log.info("Clicked on Login Link");
		Thread.sleep(2000);
		}catch (Exception e)		{
			Log.info("Error occured on clicking login link");
			}
		
		
	}
	
	/**
	 * One liner methods self explanatory
	 */
	
	public void clickSignUp(){
		signUpLink.click();
	}
	
	public void backToSiginScreen(){
		backToSigninLink.click();
	}
	
	public void enterFullName(String FullName){
		fullNameTB.clear();
		fullNameTB.sendKeys(FullName);
	}
	
	public void enterRegisterEmail(String email){
		registerMailTB.clear();
		registerMailTB.sendKeys(email);
	}
	
	public void enterRegisterPWD(String PWD){
		registerPWDTB.clear();
		registerPWDTB.sendKeys(PWD);	
	}
	
	public void enterRegisterConfirmPWD(String PWD){
		confirmPWDTB.clear();
		confirmPWDTB.sendKeys(PWD);	
	}
	
	public void enterRegisterMobileNum(String mobile){
		mobileNumTB.clear();
		mobileNumTB.sendKeys(mobile);	
	}
	
public void enterGooglePWD(String GooglePassword) {
		
		googlePassTB.sendKeys(GooglePassword);
	}
	
	public void createAccount(){
		createAccountBTN.click();
	}
	
	public void enterUserEmail(String UserMailID){
		emailTB.clear();
		Log.info("Cleared the TB");
		emailTB.sendKeys(UserMailID);
		Log.info("Entered UserMailID");
	}
	
	public void enterUserPWD(String UserPWD){
		passwordTB.clear();
		Log.info("Cleared the TB");
		passwordTB.sendKeys(UserPWD);
		Log.info("Entered PWD");
	}
	
	public void cLickLogin(){
		loginBTN.click();	
	}
	
	public String googleSiginLink(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		String winHandleBefore = driver.getWindowHandle();
		googleSignin.click();
		Thread.sleep(2000);
		utility.switchWindow(driver);
		return winHandleBefore;
			
	}
	
	
	/**
	 * This Method will signin with google credentials
	 * @param GoogleUsername
	 * @param GooglePassword
	 * @throws InterruptedException
	 */
	
	public void googleSigin(String GoogleUsername,String GooglePassword) throws InterruptedException {
		googleUNTB.clear();
		googleUNTB.sendKeys(GoogleUsername);
		try{
			googlePassTB.clear();
			googlePassTB.sendKeys(GooglePassword);
			googleSiginBTN.click();
			
			
		}catch(Exception e){
			
			googleNextBTN.click();
			Thread.sleep(2000);
			googlePassTB.clear();
			googlePassTB.sendKeys(GooglePassword);
			googleSiginBTN.click();}
			
	}
	
	
	/**
	 * Alternate Google signin method
	 * @param driver
	 * @throws InterruptedException
	 */
	
	public void googleSiginBTNClick(WebDriver driver) throws InterruptedException {
		try{
			googleSiginBTN.click();
		Log.info("Clicked on googleSigninBTN");
		Thread.sleep(2000);
				
//		if (googleAccessApproveBTN.isEnabled()){
//			Log.info("googleAccessApproveBTN is enabled");
//			googleAccessApproveBTN.click();
//			Log.info("Clicked on Access Approve button");
//			Thread.sleep(5000);
//			}
//			else {
//				Log.info("Access approve button not visible");
//			}
			
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
		
		}
	
	/**
	 * Assertion Methods with invalid credentials
	 */
	
public void invalidUsernameErrDisplayed() {
		try{Assert.assertTrue(invalidUsernameErrMSG.isDisplayed());
		Log.info("Verified the UN error message");}
		catch(Exception e){
			Log.info("error message couldnot be read");
		}
	
	}
	
public void invalidPasswordErrDisplayed() {
	
	try{Assert.assertTrue(invalidPasswordErrMSG.isDisplayed());
	Log.info("Verified the UN error message");}
	catch(Exception e){
		Log.info("error message couldnot be read");
	}
	}
	
//locator not working
public void closeLoginPopup() throws InterruptedException {
	Thread.sleep(2000);
	closePopup.click();
	Log.info("Closed the login popup");

	
	}

public void mandatoryFullNameErrMSG() {
	
	Assert.assertTrue(fullNameErrMsg.isDisplayed());
	Log.info("Closed the login popup");

	}


public void mandatoryEmailErrMSG() {
	
	Assert.assertTrue(registerMailErrMsg2.isDisplayed());
	Log.info("Closed the login popup");

	}
	

public void mandatoryPasswordErrMSG() {
	
	Assert.assertTrue(passwordTBErrMsg1.isDisplayed());
	Log.info("Closed the login popup");
	}

public void mandatoryConfirmPasswordErrMSG() {
	
	Assert.assertTrue(confirmPWDMsg.isDisplayed());
	Log.info("Closed the login popup");
	}
		
	}

