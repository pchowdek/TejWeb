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

public class LoginPOTest extends BrowserSetUp {
	
	ExtentReports reports;
	ExtentTest logger;
	
	@BeforeTest(description = "Open Browser")
	@Parameters({"browser","URL"})
	public void openBrowser(String browser,String URL) throws IOException {
			try {
				
				BrowserSetUp.appSetUp("tej",browser , URL);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	@Test(description = "This test is used to validate login page by giving invalid credentials")
	@Parameters({ "invalidusername", "invalidpassword" })
	public void invalidLogin( String invalidusername, String invalidpassword) throws InterruptedException {
		
		LoginPO login = new LoginPO(driver);
		login.clickLoginButton();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Jio Drive");
		login.enterEmail(invalidusername);
		login.enterPassword(invalidpassword);
		login.clickLogin();
		
	}

	@Test(description = "This test is used to validate login page by giving valid credentials")
	@Parameters({ "username", "password" })
	public void validLogin( String username,String password) throws InterruptedException {
		LoginPO login = new LoginPO(driver);
		login.enterEmail(username);
		login.enterPassword(password);
		login.clickLogin();
		//logger.log(LogStatus.PASS, "Test Login With Valid credentails");
	}
	@AfterTest()
	public void tearDown(){
		//reports.flush();
		driver.close();
	}
}
