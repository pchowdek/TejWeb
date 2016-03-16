package com.tejweb.sanityTest;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.log4j.xml.DOMConfigurator;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tejweb.generics.*;


public class MasterTestNG {

 public WebDriver driver;
 public Utility utility = new Utility();
 public ExtentReports reports;
 public ExtentTest logger;
	

 
 @Parameters({"browser","url","timeout","UserMail","UserPassword"})				// parameters from testng.xml
 @BeforeSuite
 public void preCondition(@Optional ("ff")String browser, @Optional ("http://sittej.jiodrive.com/TejWeb") String url, @Optional ("10") String timeout, String UserMail, String UserPassword)   // receiving parameters from testng.xml
 {
	 
	// Provide Log4j configuration settings
	 
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Framework started");
				
	 
	 if (browser.equals("gc"))
	 {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	 }
	 else if (browser.equals("ie"))
	 {
		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	 }
	 else
	 {
		 driver = new FirefoxDriver();
	 }
	 	 
	 driver.get(url);
	 long t = Long.parseLong(timeout);
	 driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
	 driver.manage().window().maximize();
	 
	 
//     Login to the application
//				JioDrivePage JioDrivePage = new JioDrivePage(driver);
//				JioDrivePage.clickLoginLink();
//				JioDrivePage.enterUserEmail(UserMail);
//				JioDrivePage.enterUserPWD(UserPassword);
//				JioDrivePage.cLickLogin();	
//				Log.info("Login successful");
	 
	 
 }


 @AfterMethod
 public void teardown(ITestResult result)	
	{
	 
		if(ITestResult.FAILURE==result.getStatus())
		{
		utility.captureScreenshot(driver, result.getName());
		            
		Log.info("Screenshot captured for " +result.getName()+ " failed step");
		}
	}
 
 
 
 @AfterSuite
 public void postCondition()
 {
	 driver.close();
	 Log.endTestCase("Framework Ended");
 }



}
