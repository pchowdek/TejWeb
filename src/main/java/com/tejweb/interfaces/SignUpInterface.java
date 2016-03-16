package com.tejweb.interfaces;

import org.openqa.selenium.WebDriver;

public interface SignUpInterface {

	
	public void clickLoginButton() throws InterruptedException;
	public void clickSignUpButton() throws InterruptedException;
	public void setFullName(String name)throws InterruptedException;
	public void setEmail(String mail)throws InterruptedException;
	public void setPassword(String pwd)throws InterruptedException;
	public void confirmPassword(String pwd)throws InterruptedException;
	public void submitSignUp()throws InterruptedException;
	public void OK() throws InterruptedException;
	public void logout() throws InterruptedException;
	
}
