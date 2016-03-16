package com.tejweb.interfaces;

public interface LoginInterface {

	
	public void clickLoginButton() throws InterruptedException;
	public void clickLogin() throws InterruptedException;
	public void enterEmail(String username);
	public void enterPassword(String password);
	public void cancel() throws InterruptedException;
	public void loginValidCredentials(String username, String password)throws InterruptedException;
	public void loginInvalidCredentials(String username,String password) throws InterruptedException;
	public void logout() throws InterruptedException;
	
}
