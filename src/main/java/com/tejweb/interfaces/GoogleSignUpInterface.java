package com.tejweb.interfaces;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

public interface GoogleSignUpInterface {

	public void clickLoginButton()throws InterruptedException;
	public void clickGoogleIcon1()throws InterruptedException;
	public void clickGoogleIcon2()throws InterruptedException;
	public void setGoogleMail(String gusernm)throws InterruptedException;
	public void googleNext()throws InterruptedException;
	public void setGooglePassword(String gpwd)throws InterruptedException;
	public void googleSubmit()throws InterruptedException;
	public void logout()throws InterruptedException;
}
