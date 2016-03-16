package com.tejweb.pageobjects;

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

public class GoogleSignUpPOTest extends BrowserSetUp{

	ExtentReports reports;
	ExtentTest logger;
	
	@BeforeTest(description = "Open Browser")
	@Parameters({"browser","protectedURL"})
	public void openBrowser(String browser,String URL) throws IOException {
		
		//String URL = "http://10.135.85.90/TejWeb/#/home";
		
			try {
				
				BrowserSetUp.appSetUp("tej",browser , URL);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	@Test(groups={"LoginCases"},priority=0,description = "TEJ-890")
	@Parameters({ "gusernm","gpwd" })
	public void GoogleSignUP(String gusernm, String gpwd) throws InterruptedException{
	GoogleSignUpPO googleSignUpPO = new GoogleSignUpPO(driver);
	googleSignUpPO.clickLoginButton();
	googleSignUpPO.clickGoogleIcon1();
	googleSignUpPO.setGoogleMail(gusernm);
	googleSignUpPO.googleNext();
	googleSignUpPO.setGooglePassword(gpwd);
	googleSignUpPO.googleSubmit();
	googleSignUpPO.logout();
	googleSignUpPO.clickLoginButton();
	googleSignUpPO.clickGoogleIcon2();
	googleSignUpPO.logout();
	
	}
	
	
	
	
	
	
	
	
  
}
