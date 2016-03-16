package com.tejweb.pages;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tejweb.generics.Log;
import com.tejweb.generics.Utility;

import junit.framework.Assert;


public class AllFilesPage {
	Utility utility = new Utility();
		
	/**
	 * Locators from AllFilesPage
	 */
	
	/**
	 *  Locators from left navigation bar
	 */
		
	
	@FindBy(xpath="//span[text()='Files']")
	private WebElement filesFilter;
	
	@FindBy(xpath="//a[@ng-click='stopAllRequests;goToTrash();']")
	private WebElement trashLink;
	
	@FindBy(xpath="//span[@class='filterOption filterArrow']")
	private WebElement allFilesFilter;
	
	@FindBy(xpath = "//button[@class='profile_btn']")  
	private WebElement profileBTN;
	
	
	/**
	 *  Locators from header of Webpage
	 */
	
	
	@FindBy(xpath="(//span[@class='breadCrumb ng-binding'])[1]")
	private WebElement allFilesBrdCrmb;
	
	@FindBy(xpath="//span[text()=' New Folder']")
	private WebElement newFolderLink;
	
	@FindBy(xpath="//span[@class='icon-ListView']")
	private WebElement listView;
	
	@FindBy(xpath="//span[@class='icon-GridView']")
	private WebElement gridView;
	
	@FindBy(xpath="//button[@id='moreAllPopBt']")
	private WebElement fileMoreOptions;
	
	@FindBy(xpath = "//span[text()=' Upload Files']")  
	private WebElement uploadFilesLink;  
	 
	@FindBy(xpath="(//button[@class='btn btn-default options_btn view'])[2]")  
	private WebElement deleteMenuBTN;
	
	
	/**
	 *  Locators from Table 
	 */
	
		
	@FindBy(xpath="(//span[@class='file_name folderLink ng-binding'])[1]")
	private WebElement firstItem;
	
	@FindBy(xpath="(//td[@class='row_modified ng-binding'])[1]")
	private WebElement firstItemModified;
	
	@FindBy(xpath="(//button[@ng-click='renameObject(new_object_name)'])[1]")
	private WebElement renameCommit;
	
	@FindBy(xpath="//span[@class='icon-File_Cancel']")
	private WebElement renameSkip;
		
	@FindBy(xpath = "//td[@class='row_name']")  
	private List<WebElement> fileFolderItems;
	
	@FindBy(xpath="//div[@id='mainContainerArea']")  
	private WebElement mainConatainerArea;
	
	@FindBy(xpath="//span[@class='dropup']")  
   	private WebElement smallTriangleName;
     
    @FindBy(xpath="//td[2]")  
    private List<WebElement> itemsFileSize;
     
    @FindBy(xpath="//th[@class='row_filesize pointer']")  
    private WebElement fileSizeHeader;
     
    @FindBy(xpath="//th[@class='row_type pointer']")  
    private WebElement fileTypeHeader;
     
    @FindBy(xpath="(//span[@class='caret yellowBottom'])[3]")  
    private WebElement fileTypeHeaderAscending;
     
    @FindBy(xpath="//span[@class='caret yellow']")  
    private WebElement fileTypeHeaderDescending;
		
				
	/**
	 *  Emerging popups/modal dialog boxes
	 */
    
				
	@FindBy(id="create_folder")
	private WebElement createFolderTB;
				
	@FindBy(xpath="//div[@class='modal-body']//button[contains(text(),'Create')]")
	private WebElement createFolderBTN;
	
	@FindBy(name="new_object_name")
	private WebElement renameTB;
	
	
	@FindBy(xpath = "//div[@class='modal-body forgot_password_modal_body']//p[contains(text(),'Congratulations!')]")  
	private WebElement accountCreatedSuccessMSG;
	
	@FindBy(xpath = "//div[@class='modal-body forgot_password_modal_body']//a")  
	private WebElement accountSuccessOKBTN;
	
	@FindBy(xpath = "//span[contains(text(),'Uploading')]")  
	private WebElement uploadingTXT;  
	 
	@FindBy(xpath = "//span[contains(text(),'completed')]")  
	private WebElement uploadCompleteTXT;   
	 
	@FindBy(xpath = "//span[@ng-click='cancelSingleUpload($index)']")  
	private WebElement uploadCancelBTN;
	 
	@FindBy(xpath= "//div[@class='popover fade right in']//a[@id='logoutButton']")  
	private WebElement logoutBTN;
	 
	@FindBy(xpath="//div[@class='modal-body']//button[@ng-click='deleteFilesFolders()']")  
	private WebElement deleteConfirmation;
	 
	@FindBy(xpath="//label[contains(text(),'deleted')]")  
	private WebElement deleteConfirmationMSG;
	 
	@FindBy(xpath="//div[@class='file_info_container']//p[text()='General']")  
	private WebElement fileInfoGeneral;
		
	 @FindBy(xpath="(//li/span[2])[2]")  
	private WebElement fileInfoKind;
     
    @FindBy(xpath="(//span[@ng-show='selectedObj.objectType=='FR''])[3]")  
	private WebElement fileInfoSize;
     
    @FindBy(xpath="(//li/span[1])[11]")  
	private WebElement fileInfoWhere;
     
    @FindBy(xpath="(//li/span[1])[13]")  
	private WebElement fileInfoUploaded;
             
    @FindBy(xpath="(//li/span[1])[14]")  
   	private WebElement fileInfoModified;
		
		
		
	/**
	 * context click menu options
	 * 
	 */
    
	
	@FindBy(xpath="(//span[@class='icon-Edit'])[3]")
	private WebElement renameOptionMore;
		
	@FindBy(xpath="//a[@class='renameAnchor']")
	private WebElement clickRenameRight;
	
	@FindBy(xpath= "//a[text()='Create new folder']")  
	private WebElement createFolderRight;
	
	@FindBy(xpath="(//span[@class='icon-Remove'])[1]")  
	private WebElement deleteFileRight;
	
	@FindBy(className="icon-Files_Info")  
   	private WebElement folderInfoRight;

		
//  @FindBy(xpath = "//span[@class='file_name folderLink ng-binding']")  
//	private List<WebElement> fileFolderItems;
		
		                    
        /**
         * Lazy initialization -Constructor
         * @param driver
         */
		
		
	public AllFilesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
		
		
		
	/**
	 *  Methods pertaining to AllFilesPage
	 */
		
	public void landOnAllFilesPage(){
		try{
			filesFilter.click();
//			allFilesFilter.click();
			Thread.sleep(2000);
			Log.info("Landed on All Files Page");
		}catch (Exception e){
			Log.info("Exception occured while navigating to All Files Page");
		}
		
	}
		
	
	/**
	 * One line methods -- Self Explanatory
	 */
	
	
	public void clickMoreOptions(){
		fileMoreOptions.click();
	}
	
	public void gotoTrash() throws InterruptedException{
		Thread.sleep(3000);
		trashLink.click();
	}
	
	public void activateFirstItem(){
		firstItemModified.click();
	}
	
	public boolean deleteConfirmartionMSG(){
		 return deleteConfirmationMSG.isDisplayed();
	}
	
	public void clickRenameMoreOptions(){
		renameOptionMore.click();
	}
	
	public void confirmDelete() {
		deleteConfirmation.click();
			
	}
	
	public void contextClickRename(){
		clickRenameRight.click();
	}
	
	public void contextClickFileInfo(){
		folderInfoRight.click();
	}

	
	public void clickContextDelete(){

		deleteFileRight.click();
	}
	
	public void accountSuccessOKBTN(){

		accountSuccessOKBTN.click();
	}
	
	
	public String getTextFirstItem(){
		return firstItem.getText();
	}
	
	public void clickFileSizeHeader(){
		fileSizeHeader.click();
	}
	
	public void clickFileTypeHeader(){
		fileTypeHeader.click();
	}
	
	
	public void typeFirstItem(String Name){
		renameTB.clear();
		renameTB.sendKeys(Name);
		
	}
	
	public void commitRename(){
	renameCommit.click();		
	}
	
	public void verifyFileTypeSortAscendingDisplayed(){
		Assert.assertTrue(fileTypeHeaderAscending.isDisplayed());		
		}
	
	public void verifyFileTypeSortDescendingDisplayed(){
		Assert.assertTrue(fileTypeHeaderDescending.isDisplayed());		
		}
	
	
	public void clickNameTriangle(){
		smallTriangleName.click();		
	}
	
	public void clickMenuDelete(){

		deleteMenuBTN.click();
	}
	
	
	public void switchView(){
		if(listView.isEnabled())
		{
			listView.click();
		}else{
			gridView.click();
		}
	}	
	
	public void clickNewFolderLink() throws InterruptedException{
		newFolderLink.click();
		System.out.println("Clicked on new Folder Link");
		Thread.sleep(2000);
	}
	
	
	/**
	 * This method checks for the popup which is displayed after first time account creation
	 * @return boolean
	 * @throws InterruptedException
	 */
	
	public boolean successAccountCreated() throws InterruptedException {
		boolean Result = false;
		if (accountCreatedSuccessMSG.isDisplayed()){
			Result = true;
		}else{
			Result = false;
			System.out.println("Success msg not displayed");
		}
		return Result;
			
	}
	
	/**
	 * This method checks if a particular file/folder is present in the files List
	 * @param driver
	 * @param fileFolderName
	 * @return boolean
	 * @throws InterruptedException
	 */
	
public Boolean isFileFolderExistsInList(WebDriver driver, String fileFolderName) throws InterruptedException{
	Boolean Result = false;
    Log.info("number of elements: " + fileFolderItems.size());
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
    Log.info("Scrolled to the bottom of the page");
    Iterator<WebElement> iterator = fileFolderItems.iterator();
	 
	   while(iterator.hasNext()) {
	     WebElement Element = iterator.next();
	     
	     if (fileFolderName.contains(Element.getText())){
	    	 Log.info("Found the Element");
	    	 return Result = true;
	    	 
	     }
	  	     
	   }
	   return Result;
   }


/**
 * verifies if the All Files Page is displayed
 * @return
 */

public boolean AllFilesPageDisplayed(){
	boolean msg = false;
			if (allFilesBrdCrmb.isDisplayed())
			{
			   return msg = true;
			}
	return msg;
}


/**
 *  Creates a Folder and performs operation on Create folder popup
 * @param folderName
 * @throws InterruptedException
 */


public void createAFolder(String folderName) throws InterruptedException{
	createFolderTB.sendKeys(folderName);
	Log.info("Entered text in create folder text field");
	Thread.sleep(2000);
	createFolderBTN.click();
	Log.info("Clicked on create window button");
			
	}



/**
 * Uploads a File from the given location
 * @throws InterruptedException
 */

public void uploadFile() throws InterruptedException{
	try{
		uploadFilesLink.click();
		Log.info("Clicked on upload files link");
		Thread.sleep(1000);
		Runtime.getRuntime().exec("./exes/FileUpload.exe");
		Thread.sleep(2000);
		
	}catch(Exception e){
		Log.info("Upload Failed");
	}
	}



/**
 *This method will Logout from the Tej application after logging from Google
 * @param driver
 */

public void googleLogoutAccount(){
	try{
//		Set<String> parentHandle1 = driver.getWindowHandles();
//		String newwindows=parentHandle1.iterator().next();
//		driver.switchTo().window(newwindows);
//		System.out.println("shifted to main window");
//		utility.switchWindow(driver);
		    Thread.sleep(3000);
			profileBTN.click();
			Log.info("clicked on profile button");
			Thread.sleep(2000);
			logoutBTN.click();
			Log.info("clicked on Logout button");
					
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
}



/**
 * This method will logout from application
 * @param driver
 * @throws InterruptedException 
 */
public void logoutAccount() throws InterruptedException{
		    Thread.sleep(5000);
			profileBTN.click();
			Log.info("clicked on profile button");
			Thread.sleep(2000);
			logoutBTN.click();
			Log.info("clicked on Logout button");
		
}


/**
 * Right clicks on the webpage and selects Create Folder option
 * @param driver
 */

public void rightClickCreateFolder(WebDriver driver){
	try{
		Actions actions = new Actions(driver).contextClick(newFolderLink);
		actions.build().perform();
		Thread.sleep(1000);
		createFolderRight.click();
		System.out.println("Right clicked on table..");
		
					
	}catch(Exception e)
	{
		e.printStackTrace();
	}

}


/**
 * Right Clicks on the first item in the files list
 * @param driver
 * @throws InterruptedException
 */

public void contextClickFirstItem(WebDriver driver) throws InterruptedException{
	Actions actions = new Actions(driver).contextClick(firstItem);
	actions.build().perform();
	Thread.sleep(1000);
		
}


/**
 * Verifies all the information in the File info Popup
 * @throws InterruptedException
 */


public void fileInfoDetailsMSG() throws InterruptedException{
	
	Thread.sleep(3000);
	Assert.assertTrue(fileInfoGeneral.isDisplayed());
	Assert.assertTrue(fileInfoKind.isDisplayed());
	Assert.assertTrue(fileInfoWhere.isDisplayed());
	Assert.assertTrue(fileInfoUploaded.isDisplayed());
	Assert.assertTrue(fileInfoModified.isDisplayed());
		
}


/**
 *  This method returns the webelement from the list by providing its file name
 * @param driver
 * @param fileFolderName
 * @return WebElement
 * @throws InterruptedException
 */

public WebElement getItemFromList(WebDriver driver, String fileFolderName) throws InterruptedException{
WebElement Result = null;
Log.info("number of elements: " + fileFolderItems.size());
JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
Log.info("Scrolled to the bottom of the page");
Iterator<WebElement> iterator = fileFolderItems.iterator();
 
   while(iterator.hasNext()) {
     WebElement Element = iterator.next();
     
     if (fileFolderName.contains(Element.getText())){
    	 Log.info("Found the Element");
    	 return Result = Element;
    	 
     }
  	     
   }
   return Result;
}



/**
 * This method will return ArrayList of all files
 * @return ArrayList
 */
public ArrayList<String>  filesInList(){ 
	ArrayList<String> Files = new ArrayList<String>();
//	ArrayList<String> Folders = new ArrayList<String>();
	
	for (WebElement e :fileFolderItems ){
		if ((e.getText()).contains(".")){
			Files.add(e.getText());
		}
//		else{
//			Folders.add(e.getText());
//			}
			
		}
	return Files;
}


/**
 * This method will return ArrayList of all KB sized items in the file size column
 * @return ArrayList
 */
public ArrayList<String>  KBitemsInFileSizeColumn(){ 
	ArrayList<String> items   = new ArrayList<String>();
	ArrayList<String> KBitems = new ArrayList<String>();
	ArrayList<String> KBFinalItems = new ArrayList<String>();
	for (WebElement e :itemsFileSize ){
		Log.info(e.getText());
		if ((e.getText()).contains(".")){
			items.add(e.getText());
		}
	}	
		for (String k :items ){
			if ((k).contains("KB")){
				KBitems.add(k);
			}
		}
		String[] words1=KBitems.get(0).split(" ");
		String[] words2=KBitems.get(1).split(" ");
		String[] words3=KBitems.get(2).split(" ");
		KBFinalItems.add(words1[0]);
		KBFinalItems.add(words2[0]);
		KBFinalItems.add(words3[0]);
		return KBFinalItems;
}



/**
 * This method will return ArrayList of all MB sized items in the file size column
 * @return ArrayList
 */
public ArrayList<String>  MBitemsInFileSizeColumn(){ 
	ArrayList<String> items   = new ArrayList<String>();
	ArrayList<String> MBitems = new ArrayList<String>();
	for (WebElement e :itemsFileSize ){
		if ((e.getText()).contains(".")){
			items.add(e.getText());
		}
	}	
		
		for (String k :items ){
			if ((k).contains("MB")){
				MBitems.add(k);
			}
		}
				
		return MBitems;

}



/**
 * This method will return ArrayList of all GB sized items in the file size column
 * @return ArrayList
 */
public ArrayList<String>  GBitemsInFileSizeColumn(){ 
	ArrayList<String> items   = new ArrayList<String>();
	ArrayList<String> GBitems = new ArrayList<String>();
	for (WebElement e :itemsFileSize ){
		if ((e.getText()).contains(".")){
			items.add(e.getText());
		}
	}	
		
		for (String k :items ){
			if ((k).contains("GB")){
				GBitems.add(k);
			}
		}
				
		return GBitems;
}



/**
 * This method will return ArrayList<String> of all folders
 * @return ArrayList
 */
public ArrayList<String>  foldersInList(){ 
	ArrayList<String> Files = new ArrayList<String>();
	ArrayList<String> Folders = new ArrayList<String>();
	
	for (WebElement e :fileFolderItems ){
		if ((e.getText()).contains(".")){
			Files.add(e.getText());
		}else{
			Folders.add(e.getText());
			}
			
		}
	return Folders;
}


/**
 *  This method will take arraylist<String> and return if the array is sorted in ascending order or not
 * @param arraylist
 * @return boolean
 */
 public boolean checkAscendingSort(ArrayList< String > arraylist){
	boolean isSorted=true; 
	for(int i=1;i < arraylist.size();i++){
		if(arraylist.get(i-1).compareTo(arraylist.get(i)) > 0){
			isSorted= false; 
			break; 
			}
		} 
	return isSorted; 
	} 

  
 
 /**
  *  This method will take arraylist<String> and return if the array is sorted in descending order or not
  * @param arraylist
  * @return boolean
  */
  public boolean checkDescendingSort(ArrayList< String > arraylist){
 	boolean isSorted=true; 
 	for(int i=1 ;i<arraylist.size();i++){
 		if(arraylist.get(i-1).compareTo(arraylist.get(i)) < 0){
 			isSorted= false; 
 			break; 
 			}
 		} 
 	return isSorted; 
 	} 
 
 
 
}
