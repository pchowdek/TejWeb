package com.tejweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tejweb.generics.Utility;

public class TrashPage extends AllFilesPage {

	Utility utility = new Utility();
	
	/**
	 * Locators from Trash Page
	 */
		
	@FindBy(xpath="//a[contains(text(),'Delete Forever')]")
	private WebElement deleteForeverRight;
	
	@FindBy(xpath="//a[contains(text(),'Restore')]")
	private WebElement restoreRight;
	
	@FindBy(xpath="(//div[@class='modal-body createfolder_modal_body'])[2]//a[1]")
	private WebElement deleteForeverConfirmation;
	
	@FindBy(xpath="//button[@class='RestoreAllBtn']")
	private WebElement restoreAllBTN;
	

	
		
	

	/**
	 * Lazy initialization
	 * @param driver
	 */
		
public TrashPage(WebDriver driver)
{
	super(driver);
	PageFactory.initElements(driver, this);
	
}
					
	
	/**
	 * Methods pertaining to TrashPage
	 */
	
	
	public void contextClickDeleteForever(){
		deleteForeverRight.click();
	}
	
	public void confirmDeleteForever(){
		deleteForeverConfirmation.click();
	}
	
	public void clickRestoreAll(){
		restoreAllBTN.click();
	}
	
	
	
	
}
