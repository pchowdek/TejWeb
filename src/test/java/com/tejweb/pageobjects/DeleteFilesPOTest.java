package com.tejweb.pageobjects;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tejweb.BrowserSetUp;

public class DeleteFilesPOTest extends BrowserSetUp{


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
	
	@Test(groups={"FilesNFolders"},priority=0,description = "TEJ-3168,TEJ-3168")
	@Parameters({ "username","password" })
	public void deleteFilesfromWeb(String username,String password) throws InterruptedException{
		DeleteFilesPO po = new DeleteFilesPO(driver);
		po.clickLoginButton();
		po.enterEmail(username);
		po.enterPassword(password);
		po.clickLogin();
		po.changeView();
		po.selectfilesToDelete(driver);
		po.opentrashtoverify();
		po.returntoFiles();
		po.selectfilesToDelete(driver);
		po.deleteForever();
		po.logout();
		
		
		  
	}
  
}
