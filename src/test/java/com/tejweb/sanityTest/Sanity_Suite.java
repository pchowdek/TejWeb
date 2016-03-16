package com.tejweb.sanityTest;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tejweb.generics.Log;
import com.tejweb.pages.AllFilesPage;
import com.tejweb.pages.JioDrivePage;
import com.tejweb.pages.TrashPage;


public class Sanity_Suite extends MasterTestNG {
	

	@Test( enabled = true,priority=0,description = "Try Logging using Invalid Username and Invalid Password")
	@Parameters({ "InvalidUserName","InvalidPassword"})
	 public void testTej_InvalidUNInvalidPWD(String InvalidUserName, String InvalidPassword) throws InterruptedException
	 {
		JioDrivePage JioDrivePage = new JioDrivePage(driver);
		Thread.sleep(2000);
		JioDrivePage.clickLoginLink();
		JioDrivePage.enterUserEmail(InvalidUserName);
		JioDrivePage.enterUserPWD(InvalidPassword);
		JioDrivePage.cLickLogin();
		Thread.sleep(1000);
		JioDrivePage.invalidUsernameErrDisplayed();
		Thread.sleep(3000);
	}
	
	@Test( enabled = true,priority=1, description = "Login using valid Username and Invalid PWD")
	@Parameters({ "ValidUserName","InvalidPassword"})
	public void testTej_ValidUNInvalidPWD(String ValidUserName, String InvalidPassword) throws InterruptedException{
		JioDrivePage JioDrivePage = new JioDrivePage(driver);
		Thread.sleep(2000);
		JioDrivePage.enterUserEmail(ValidUserName);
		JioDrivePage.enterUserPWD(InvalidPassword);
		JioDrivePage.cLickLogin();
		Thread.sleep(1000);
		JioDrivePage.invalidUsernameErrDisplayed();
		Thread.sleep(3000);
			
	}
	
	

	@Test(enabled = true,  priority=2, description = "Full name, password, email, confirm password are mandatory fields")
	 public void testTEJ_956()
	 {
		Log.info("Running testTEJ_956 ");
		
		try{
			JioDrivePage JioDrivePage = new JioDrivePage(driver);
			Thread.sleep(5000);
//			JioDrivePage.clickLoginLink();
			JioDrivePage.clickSignUp();
			Thread.sleep(2000);
			JioDrivePage.createAccount();
			JioDrivePage.mandatoryFullNameErrMSG();
			JioDrivePage.mandatoryEmailErrMSG();
			JioDrivePage.mandatoryPasswordErrMSG();
			JioDrivePage.mandatoryConfirmPasswordErrMSG();
			JioDrivePage.backToSiginScreen();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	 }
		
	
	
	@Test(enabled = true, priority=3, description = "user can create a new folder so that they can better organize their files")
	@Parameters({ "ValidUserName","UserPassword"})
	 public void testTEJ_1456(String ValidUserName, String UserPassword)
	 {
		Log.info("Running testTEJ_1456 ");
		
		try{
			JioDrivePage JioDrivePage = new JioDrivePage(driver);
			AllFilesPage AllFilesPage = new AllFilesPage(driver);
			Thread.sleep(2000);
//			JioDrivePage.clickLoginLink();
			JioDrivePage.enterUserEmail(ValidUserName);
			JioDrivePage.enterUserPWD(UserPassword);
			JioDrivePage.cLickLogin();
			Thread.sleep(5000);
			AllFilesPage.switchView();
			String folderName= utility.generateID();
			Thread.sleep(2000);
			AllFilesPage.clickNewFolderLink();
			AllFilesPage.createAFolder(folderName);
			Assert.assertTrue(AllFilesPage.isFileFolderExistsInList(driver, folderName));
			Thread.sleep(3000);
			AllFilesPage.rightClickCreateFolder(driver);
			String folderName2= utility.generateID();
			Thread.sleep(2000);
			AllFilesPage.createAFolder(folderName2);
			Assert.assertTrue(AllFilesPage.isFileFolderExistsInList(driver, folderName2));
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	 }
	
	
	
	@Test(enabled = true, priority=4, description = "Verify general info of a file in file info screen")
	 public void testTEJ_1460()
	 {
		Log.info("Running testTEJ_1460");
		
		try{
			AllFilesPage AllFilesPage = new AllFilesPage(driver);
			Thread.sleep(2000);
			AllFilesPage.contextClickFirstItem(driver);
			AllFilesPage.contextClickFileInfo();
			AllFilesPage.fileInfoDetailsMSG();	
			AllFilesPage.landOnAllFilesPage();
			Thread.sleep(2000);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	 }
	
	
	
	@Test(enabled = true, priority=5, description = "Verify that User can rename a file by right click option menu.")
	 public void testTEJ_1461()
	 {
		Log.info("Running testTEJ_1461");
		
		try{
			AllFilesPage AllFilesPage = new AllFilesPage(driver);
			Thread.sleep(2000);
			AllFilesPage.activateFirstItem();
			AllFilesPage.clickMoreOptions();
			AllFilesPage.clickRenameMoreOptions();
			String Rename = utility.generateID();
			AllFilesPage.typeFirstItem(Rename);
			AllFilesPage.commitRename();
			Thread.sleep(2000);
			Assert.assertTrue(AllFilesPage.isFileFolderExistsInList(driver,Rename));
			Log.info("Rename is successful from more options");
			
			AllFilesPage.contextClickFirstItem(driver);
			AllFilesPage.contextClickRename();
			String Rename2 = utility.generateID();
			AllFilesPage.typeFirstItem(Rename2);
			AllFilesPage.commitRename();
			Thread.sleep(2000);
			Assert.assertTrue(AllFilesPage.isFileFolderExistsInList(driver,Rename2));
			Log.info("Rename is successful from right click");
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	 }
	
	
	
	@Test(enabled = true, priority=6, description = "Verify that files are sorted in ascending/descending order in file view screen.")
	 public void testTEJ_1078()
	 {
		Log.info("Running testTEJ_1078");
		
		try{
			
			AllFilesPage AllFilesPage = new AllFilesPage(driver);
			Thread.sleep(2000);
			AllFilesPage.clickFileSizeHeader();
			Thread.sleep(2000);
			boolean a = AllFilesPage.checkAscendingSort(AllFilesPage.KBitemsInFileSizeColumn());
			AllFilesPage.clickFileSizeHeader();
			Thread.sleep(2000);
			boolean b= AllFilesPage.checkDescendingSort(AllFilesPage.KBitemsInFileSizeColumn());
			Assert.assertTrue(a);
			Assert.assertTrue(b);

		}catch(Exception e){
			e.printStackTrace();
			}
		}
	
	
	
	@Test(enabled = true, priority=7, description = "Verify the sorting rule for Name field in ascending.")
	 public void testTEJ_1374()
	 {
		Log.info("Running testTEJ_1374");
		
		try{
			
			AllFilesPage AllFilesPage = new AllFilesPage(driver);
			Thread.sleep(2000);
			AllFilesPage.landOnAllFilesPage();
			Thread.sleep(2000);
//			boolean a = AllFilesPage.checkAscendingSort(AllFilesPage.filesInList());
			boolean b= AllFilesPage.checkAscendingSort(AllFilesPage.foldersInList());
			AllFilesPage.clickNameTriangle();
			Thread.sleep(5000);
//			boolean c = AllFilesPage.checkDescendingSort(AllFilesPage.filesInList());
			boolean d = AllFilesPage.checkDescendingSort(AllFilesPage.foldersInList());
			Assert.assertTrue(b);
			Assert.assertTrue(d);
			
		}catch(Exception e){
			e.printStackTrace();
			}
		}
	
	
	
	@Test(enabled = true, priority=8, description = "Verify that sorting is possible on the Type column.")
	 public void testTEJ_3156()
	 {
		Log.info("Running testTEJ_3156");
		
		try{
			
			AllFilesPage AllFilesPage = new AllFilesPage(driver);
			Thread.sleep(2000);
			AllFilesPage.clickFileTypeHeader();
			AllFilesPage.verifyFileTypeSortAscendingDisplayed();
			AllFilesPage.clickFileTypeHeader();
			AllFilesPage.verifyFileTypeSortDescendingDisplayed();
			
					
		}catch(Exception e){
			e.printStackTrace();
			}
		}
	
	
	
	@Test(enabled = true,  priority=9, description = "user can delete their files if he/she no longer require them.")
	 public void testTEJ_1458()
	 {
		Log.info("Running testTEJ_1458 ");
		
		try{
			boolean result0 = false;
			boolean result1 = false;
			boolean result2 = false;
			AllFilesPage AllFilesPage = new AllFilesPage(driver);
			Thread.sleep(3000);
			AllFilesPage.activateFirstItem();
			AllFilesPage.clickMenuDelete();
			AllFilesPage.confirmDelete();
			Thread.sleep(1000);
			result0 = AllFilesPage.deleteConfirmartionMSG();
			String Name2 = AllFilesPage.getTextFirstItem();
			Thread.sleep(3000);
			AllFilesPage.contextClickFirstItem(driver);
			AllFilesPage.clickContextDelete();
			AllFilesPage.confirmDelete();
			Thread.sleep(1000);
			result1 = AllFilesPage.deleteConfirmartionMSG();
			Thread.sleep(5000);
			result2 = AllFilesPage.isFileFolderExistsInList(driver, Name2);
			if (result1 & result2 & result0){
				Assert.assertTrue(true);
			}else{
				Assert.fail();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	 }
	
	
		
	@Test(enabled = true, priority=10, description = "Verify that deleted files moved to the trash so that user can restore them if required.")
	 public void testTEJ_3168()
	 {
		Log.info("Running testTEJ_3168");
		
		try{
			Boolean result1 = false;
			Boolean result2 = false;
			AllFilesPage AllFilesPage = new AllFilesPage(driver);
			AllFilesPage.landOnAllFilesPage();
			Thread.sleep(2000);
			String Name1 = AllFilesPage.getTextFirstItem();
			Thread.sleep(1000);
			AllFilesPage.activateFirstItem();
			AllFilesPage.clickMenuDelete();
			AllFilesPage.confirmDelete();
			AllFilesPage.deleteConfirmartionMSG();
			System.out.println(Name1);
			String Name2 = AllFilesPage.getTextFirstItem();
			Thread.sleep(3000);
			AllFilesPage.contextClickFirstItem(driver);
			AllFilesPage.clickContextDelete();
			AllFilesPage.confirmDelete();
			AllFilesPage.deleteConfirmartionMSG();
			System.out.println(Name2);
			Thread.sleep(5000);
			AllFilesPage.gotoTrash();
			Thread.sleep(5000);
			result1 = AllFilesPage.isFileFolderExistsInList(driver, Name1);
			result2 = AllFilesPage.isFileFolderExistsInList(driver, Name2);
			if (result1 & result2){
				Assert.assertTrue(true);
			}else{
				Assert.fail();
			}
			
						
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	 }
	
	

	@Test(enabled = true, priority=11, description = "Verify Restore All functionality")
	 public void testTEJ_3168_C()
	 {
		Log.info("Running testTEJ_3168_C");
		
		try{
			
			AllFilesPage AllFilesPage = new AllFilesPage(driver);
			TrashPage TrashPage = new TrashPage(driver);
			ArrayList<String> Name = new ArrayList<String>();
			String e;
			AllFilesPage.landOnAllFilesPage();
			Thread.sleep(2000);
			for (int i = 1; i<=3; i++){
				Thread.sleep(2000);
				e= AllFilesPage.getTextFirstItem();
				Name.add(e);
				AllFilesPage.contextClickFirstItem(driver);
				AllFilesPage.clickContextDelete();
				AllFilesPage.confirmDelete();
			}
				Thread.sleep(2000);
				AllFilesPage.gotoTrash();
				Thread.sleep(5000);
				TrashPage.clickRestoreAll();
				Thread.sleep(2000);
				AllFilesPage.landOnAllFilesPage();
				Thread.sleep(5000);
				Assert.assertTrue(AllFilesPage.isFileFolderExistsInList(driver, Name.get(0)));
				Assert.assertTrue(AllFilesPage.isFileFolderExistsInList(driver, Name.get(1)));
				Assert.assertTrue(AllFilesPage.isFileFolderExistsInList(driver, Name.get(2)));
			
						
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	 }
	
	
	
	@Test(enabled = true, priority=12, description = "Verify functionality of Delete Forever")
	 public void testTEJ_3168_B()
	 {
		Log.info("Running testTEJ_3168_B");
		
		try{
			boolean result = false;
			AllFilesPage AllFilesPage = new AllFilesPage(driver);
			TrashPage TrashPage = new TrashPage(driver);
			AllFilesPage.landOnAllFilesPage();
			Thread.sleep(2000);
			String Name1 = AllFilesPage.getTextFirstItem();
			Thread.sleep(1000);
			AllFilesPage.activateFirstItem();
			AllFilesPage.clickMenuDelete();
			AllFilesPage.confirmDelete();
			AllFilesPage.deleteConfirmartionMSG();
			System.out.println(Name1);
			Thread.sleep(3000);
			AllFilesPage.gotoTrash();
			Thread.sleep(5000);
			WebElement deletedItem = AllFilesPage.getItemFromList(driver, Name1);
			Actions actions = new Actions(driver).contextClick(deletedItem);
			actions.build().perform();
			TrashPage.contextClickDeleteForever();
			TrashPage.confirmDeleteForever();
			Thread.sleep(3000);
			result = AllFilesPage.isFileFolderExistsInList(driver, Name1);
			AllFilesPage.logoutAccount();
			if(result){
				Assert.fail();	
								
			}else{
				Assert.assertTrue(true);
							
			}
						
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	 }

	
	
	@Test( enabled = true, priority=13, description = "Login using google account")
	@Parameters({ "GoogleUserName","GoogleUserPassword"})
	 public void testTEJ_890(String GoogleUserName, String GoogleUserPassword)
	 {
		Log.info("Running testTEJ_890 ");
		
		try{
			boolean result = false;
			JioDrivePage JioDrivePage = new JioDrivePage(driver);
			AllFilesPage AllFilesPage = new AllFilesPage(driver);
			Thread.sleep(2000);
			JioDrivePage.clickLoginLink();
			String parentWindow = JioDrivePage.googleSiginLink(driver);
			Log.info("Clicked on Google sigin link");
			JioDrivePage.googleSigin(GoogleUserName, GoogleUserPassword);
			Thread.sleep(5000);
			driver.switchTo().window(parentWindow);
			Thread.sleep(5000);
			result = AllFilesPage.AllFilesPageDisplayed();
			AllFilesPage.googleLogoutAccount();
			Thread.sleep(3000);
			if (result){
				Assert.assertTrue(true);
			}else{
				Assert.fail();
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
}
	
		
	@Test( enabled = true,priority=14, description = "Verify that the Full Name,Email Address,Password are mandatory and account is created")
	@Parameters({ "FullName","email","PWD","Mobile"})
	public void testTej_956(String FullName, String email, String PWD, String Mobile ) throws InterruptedException {
		JioDrivePage JioDrivePage = new JioDrivePage(driver);
		AllFilesPage AllFilesPage = new AllFilesPage(driver);
		boolean result;
		Thread.sleep(5000);
		JioDrivePage.clickLoginLink();
		JioDrivePage.clickSignUp();
		Thread.sleep(2000);
		String test = utility.generateID();
		JioDrivePage.enterFullName(FullName+test);
		Thread.sleep(1000);
		JioDrivePage.enterRegisterEmail(test+"@gmail.com");
		JioDrivePage.enterRegisterPWD(PWD);
		JioDrivePage.enterRegisterConfirmPWD(PWD);
		Thread.sleep(1000);
		JioDrivePage.enterRegisterMobileNum(Mobile);
		Thread.sleep(2000);
		JioDrivePage.createAccount();
		Thread.sleep(5000);
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("All"));	
		Log.info("Account Created");
		result = AllFilesPage.successAccountCreated();
		if (result){
			AllFilesPage.accountSuccessOKBTN();
			AllFilesPage.logoutAccount();
			Thread.sleep(2000);
		}else{
			AllFilesPage.logoutAccount();
		}
		Assert.assertTrue(result);
	
	}
	
	//end of tests	
	
}
