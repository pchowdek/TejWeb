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

public class SanityTest extends BrowserSetUp {

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
	@Test(groups={"LoginCases","Chrome","FireFox"},priority=0,description = "TEJ-")
	@Parameters({ "invalidusername","invalidpassword"})
	public void loginInvalidCredentials(String invalidusername,String invalidpassword) throws InterruptedException {
		LoginPO login = new LoginPO(driver);
		login.clickLoginButton();
		login.enterEmail(invalidusername);
		login.enterPassword(invalidpassword);
		login.clickLogin();
		login.cancel();
		}
	@Test(groups={"LoginCases","Chrome","FireFox"},priority=1,description = "TEJ-")
	@Parameters({ "username","password"})
	public void loginValidCredentials(String username,String password) throws InterruptedException {
		LoginPO login = new LoginPO(driver);
		login.clickLoginButton();
		login.enterEmail(username);
		login.enterPassword(password);
		login.clickLogin();
		login.logout();
		
		}
	
	@Test(groups={"LoginCases","Chrome","FireFox"},priority=2,description = "TEJ-890")
	@Parameters({ "gusernm","gpwd"})
	public void googleSignUp(String gusernm,String gpwd) throws InterruptedException {
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
	
	@Test(groups={"LoginCases","Chrome","FireFox"},priority=3,description = "TEJ-956")
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
		}
	@Test(groups={"FilesNFolders","Chrome","FireFox"},priority=4,description = "TEJ-1136")
	@Parameters({ "username","password","fname" })
	public void uploadfileroperation(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.documentupload(driver);
		po.changeView();
		}
	@Test(groups={"FilesNFolders","Chrome","FireFox"},priority=5,description = "TEJ-1456 ")
	@Parameters({ "username","password","fname" })
	public void createfolderoperation(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.clickonNewFolder();
		po.setFileName(fname);
		po.createFile();
		po.clickonNewFolder();
		po.setFileName(fname);
		po.createFile();
		po.clickonNewFolder();
		po.setFileName(fname);
		po.createFile();
		}
	@Test(groups={"FilesNFolders","Chrome","FireFox"},priority=6,description = " TEJ-1461")
	@Parameters({ "username","password","fname" })
	public void renamefolderoperation(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.renameFolderByRightClick(driver);
		}
	@Test(groups={"FilesNFolders","Chrome","FireFox"},priority=7,description = "TEJ-1457(Copy Files)")
	@Parameters({ "username","password","fname" })
	public void copyfileoperation(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.copyFiles(driver);
		}
	@Test(groups={"FilesNFolders","Chrome","FireFox"},priority=8,description = "TEJ-1457(Move Files..)")
	@Parameters({ "username","password","fname" })
	public void movefileoperation(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.moveFiles(driver);
		}
	@Test(groups={"FilesNFolders","Chrome","FireFox"},priority=9,description = "TEJ-3158(Audio Tab)")
	@Parameters({ "username","password" })
	public void audioFiles(String username,String password) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.audioTab();
		po.audioupload(driver);
		}
	@Test(groups={"FilesNFolders","Chrome","FireFox"},priority=10,description = "TEJ-3158(Documents Tab)")
	@Parameters({ "username","password" })
	public void documentFiles(String username,String password) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.documentTab();
		po.documentupload(driver);
			
		}
	@Test(groups={"FilesNFolders","Chrome","FireFox"},priority=11,description = "TEJ-4896")
	@Parameters({ "username","password","fname" })
	public void sharefileroperation(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.shareURL(driver);
		}
	@Test(groups={"FilesNFolders","Chrome","FireFox"},priority=12,description = "TEJ-3168(delete once), TEJ-3168(delete forever)")
	@Parameters({ "username","password","fname" })
	public void deletefiles(String username,String password,String fname) throws InterruptedException, HeadlessException, AWTException {
		DeleteFilesPO po = new DeleteFilesPO(driver);
		po.selectfilesToDelete(driver);
		po.opentrashtoverify();
		po.returntoFiles();
		po.selectfilesToDelete(driver);
		po.deleteForever();
		}
	
	@Test(groups={"LoginCases","Chrome","FireFox"},priority=13,description = "Logout")
	//@Parameters({ "username","password" })
	public void logout() throws InterruptedException, AWTException{
		FilesNFoldersPO po = new FilesNFoldersPO(driver);
		po.clickonUserAccount();
		po.logout(driver);
		
	}
	
	
}
