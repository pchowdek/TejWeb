package com.tejweb.interfaces;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

public interface FilesNFolders {

	public void clickLoginButton() throws InterruptedException;
	public void clickLogin() throws InterruptedException;
	public void enterEmail(String username)throws InterruptedException;
	public void enterPassword(String password)throws InterruptedException;
	public void changeView() throws InterruptedException;
	public void createFolderByRightClick(WebDriver driver) throws InterruptedException;
	public void clickonNewFolder()throws InterruptedException;
	public void setFileName(String fname)throws InterruptedException;
	public void createFile() throws InterruptedException;
	public void renameFolderByRightClick(WebDriver driver)throws InterruptedException;
	public void audioupload(WebDriver driver) throws InterruptedException, AWTException;
	public void documentupload(WebDriver driver) throws InterruptedException, AWTException;
	public void shareURL(WebDriver driver) throws InterruptedException, AWTException;
	public void copyFiles(WebDriver driver)throws InterruptedException;
	public void moveFiles(WebDriver driver)throws InterruptedException;
	public void audioTab() throws InterruptedException;
	public void documentTab() throws InterruptedException;
	public void clickonUserAccount()throws InterruptedException;
	public void logout(WebDriver driver)throws InterruptedException, AWTException;
	
}
