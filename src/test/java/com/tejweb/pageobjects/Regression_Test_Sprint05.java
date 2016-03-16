package com.tejweb.pageobjects;


import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tejweb.BrowserSetUp;


public class Regression_Test_Sprint05 extends BrowserSetUp{
	
	ExtentReports reports;
	ExtentTest logger;
	
	@BeforeTest(description = "Open Browser")
	@Parameters({"browser","URL"})
	public void openBrowser(String browser,String URL) throws IOException {
			try {
				
				BrowserSetUp.appSetUp("tej",browser , URL);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	@Test(groups={"LoginCases","Chrome","FireFox"},priority=0,description = "TEJ-890,TEJ-952,TEJ-953(I),TEJ-953(II)")
	@Parameters({ "gusernm","gpwd"})
	public void googleSignUp(String gusernm,String gpwd) throws InterruptedException, AWTException {
		GoogleSignUpPO po = new GoogleSignUpPO(driver);
		po.clickLoginButton();
		po.clickGoogleIcon1();
		po.setGoogleMail(gusernm);
		po.googleNext();
		po.setGooglePassword(gpwd);
		po.googleSubmit();
		po.logout();
		po.clickLoginButton();
		po.clickGoogleIcon2();
		po.logout();		
		}
	@Test(groups={"LoginCases","Chrome","FireFox"},priority=1,description = "TEJ-956(I)")
	@Parameters({ "mobileuser","mobilepwd"})
	public void androidaccount(String mobileuser, String mobilepwd) throws InterruptedException{
		LoginPO login = new LoginPO(driver);
		login.clickLoginButton();
		login.enterEmail(mobileuser);
		login.enterPassword(mobilepwd);
		login.clickLogin();
		login.logout();
		}
	@Test(groups={"LoginCases","Chrome","FireFox"},priority=2,description = "TEJ-956(II)")
	@Parameters({ "name","email","password"})
	public void verifySignUpFields(String name, String email,String password) throws InterruptedException{
		SignUpPO signUpPO = new SignUpPO(driver);
		signUpPO.clickLoginButton();
		signUpPO.clickSignUpButton();
		signUpPO.submitSignUp();
		signUpPO.setFullName(name);
		signUpPO.setEmail(email);
		signUpPO.setPassword(password);
		signUpPO.confirmPassword(password);
		signUpPO.submitSignUp();
		signUpPO.OK();
		signUpPO.logout();
		}
	@Test(groups={"LoginCases","Chrome","FireFox"},priority=3,description = "TEJ-954(I)")
	@Parameters({ "invalidusername","invalidpassword"})
	public void incorrectcredentials( String invalidusername,String invalidpassword) throws InterruptedException{
		LoginPO login = new LoginPO(driver);
		login.clickLoginButton();
		login.enterEmail(invalidusername);
		login.enterPassword(invalidpassword);
		login.clickLogin();
		Assert.assertEquals("Email address or Password is incorrect.", "Email address or Password is incorrect.");
		login.cancel();
		}
	@Test(groups={"LoginCases","Chrome","FireFox"},priority=4,description = "TEJ-954(II)")
	public void blankcredentialsErrorVerify( ) throws InterruptedException{
		LoginPO login = new LoginPO(driver);
		login.clickLoginButton();
		login.clickLogin();
		Assert.assertEquals("Please enter your email address and password.", "Please enter your email address and password.");
		login.cancel();
		}
	@Test(groups={"LoginCases","Chrome","FireFox"},priority=5,description = "TEJ-954(III)")
	@Parameters({ "mobilepwd"})
	public void blankEmailField( String mobilepwd) throws InterruptedException{
		LoginPO login = new LoginPO(driver);
		login.clickLoginButton();
		login.enterPassword(mobilepwd);
		login.clickLogin();
		Assert.assertEquals("Please enter your email address.", "Please enter your email address.");
		login.cancel();
		}
	@Test(groups={"LoginCases","Chrome","FireFox"},priority=6,description = "TEJ-954(IV)")
	@Parameters({ "invalidusername"})
	public void blankPasswordField( String invalidusername) throws InterruptedException{
		LoginPO login = new LoginPO(driver);
		login.clickLoginButton();
		login.enterEmail(invalidusername);
		login.clickLogin();
		login.cancel();
		Assert.assertEquals("Please enter your password.", "Please enter your password.");
		}
		

}

