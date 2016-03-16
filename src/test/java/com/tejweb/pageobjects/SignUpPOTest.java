package com.tejweb.pageobjects;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tejweb.BrowserSetUp;

public class SignUpPOTest extends BrowserSetUp{
	
	
	
	
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
	
	@Test(groups={"LoginCases"},priority=0,description = "TEJ-956")
	@Parameters({ "name","email","password" })
	public void loginBySignUPform(String name, String email,String password) throws InterruptedException {
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
	

}
