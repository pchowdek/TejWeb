package com.tejweb.pageobjects;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tejweb.BrowserSetUp;

public class FilesNFoldersPOTest extends BrowserSetUp{
	
	ExtentReports reports;
	ExtentTest logger;
	
	@BeforeMethod(description = "Open Browser")
	@Parameters({"browser","URL"})
	public void openBrowser(String browser,String URL) throws IOException {
		
		try {
				
				BrowserSetUp.appSetUp("tej",browser , URL);
			} catch (MalformedURLException e) {
					e.printStackTrace();
			}
			
		
	}
	@Test(groups={"FilesNFolders"},priority=0,description = "TEJ-1136")
	@Parameters({ "username","password","fname" })
	public void uploadfileroperation(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.clickLoginButton();
		po.enterEmail(username);
		po.enterPassword(password);
		po.clickLogin();
		po.changeView();
		po.documentupload(driver);
		po.clickonUserAccount();
		po.logout(driver);
		
		
		
		
	}
	@Test(groups={"FilesNFolders"},priority=1,description = "TEJ-4896")
	@Parameters({ "username","password","fname" })
	public void sharefileroperation(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.clickLoginButton();
		po.enterEmail(username);
		po.enterPassword(password);
		po.clickLogin();
		po.changeView();
		po.shareURL(driver);
		po.clickonUserAccount();
		po.logout(driver);
		
		
		
		
	}
	
	@Test(groups={"FilesNFolders"},priority=2,description = "TEJ-1456 ")
	@Parameters({ "username","password","fname" })
	public void createfolderoperation(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.clickLoginButton();
		po.enterEmail(username);
		po.enterPassword(password);
		po.clickLogin();
		po.changeView();
		po.clickonNewFolder();
		po.setFileName(fname);
		po.createFile();
		po.clickonUserAccount();
		po.logout(driver);
		
		}
	
	@Test(groups={"FilesNFolders"},priority=3,description = " TEJ-1461")
	@Parameters({ "username","password","fname" })
	public void renamefolderoperation(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.clickLoginButton();
		po.enterEmail(username);
		po.enterPassword(password);
		po.clickLogin();
		po.changeView();
		po.renameFolderByRightClick(driver);
		po.clickonUserAccount();
		po.logout(driver);
		
	}
	
	@Test(groups={"FilesNFolders"},priority=4,description = "TEJ-1457(Copy Files)")
	@Parameters({ "username","password","fname" })
	public void copyfileoperation(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.clickLoginButton();
		po.enterEmail(username);
		po.enterPassword(password);
		po.clickLogin();
		po.changeView();
		po.copyFiles(driver);
		po.clickonUserAccount();
		po.logout(driver);
		
		
		
		
	}
	@Test(groups={"FilesNFolders"},priority=5,description = "TEJ-1457(Move Files..)")
	@Parameters({ "username","password","fname" })
	public void movefileoperation(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.clickLoginButton();
		po.enterEmail(username);
		po.enterPassword(password);
		po.clickLogin();
		po.changeView();
		po.moveFiles(driver);
		po.clickonUserAccount();
		po.logout(driver);
		
		
		
		
	}
	@Test(groups={"FilesNFolders"},priority=6,description = "TEJ-3158(Audio Tab)")
	@Parameters({ "username","password" })
	public void audioFiles(String username,String password) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.clickLoginButton();
		po.enterEmail(username);
		po.enterPassword(password);
		po.clickLogin();
		po.audioTab();
		po.changeView();
		po.audioupload(driver);
		po.clickonUserAccount();
		po.logout(driver);
		
		
		
		
	}
	@Test(groups={"FilesNFolders"},priority=7,description = "TEJ-3158(Documents Tab)")
	@Parameters({ "username","password" })
	public void documentFiles(String username,String password) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.clickLoginButton();
		po.enterEmail(username);
		po.enterPassword(password);
		po.clickLogin();
		po.changeView();
		po.documentTab();
		po.documentupload(driver);
		po.clickonUserAccount();
		po.logout(driver);
		
		}
}
