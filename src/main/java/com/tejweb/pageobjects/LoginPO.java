package com.tejweb.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tejweb.interfaces.LoginInterface;

public class LoginPO implements LoginInterface {

	@FindBy(how = How.XPATH, using = "//a[@href='#signin_modal']")
	WebElement loginBtn;
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	WebElement emailField;
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'LOG IN')]")
	WebElement logIn;
	@FindBy(how = How.XPATH, using = "//button[contains(text(), '×')]")
	WebElement cancel;
	@FindBy(how = How.XPATH, using = "//*[@id='sidebar']/nav/ul[2]/li[3]/button[1]")
	WebElement useraccount;
	@FindBy(how = How.XPATH, using = "//div[@class='popover fade right in']//a[@id='logoutButton']")
	WebElement logout;

	public LoginPO(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);

	}

	public void clickLoginButton() throws InterruptedException {
		Thread.sleep(2000);
		loginBtn.click();
		System.out.println("Clicked login..");
		

	}

	public void enterEmail(String username) {
		try {
			Thread.sleep(1000);
			//emailField.clear();
			emailField.sendKeys(username);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void enterPassword(String password) {
		try {
			Thread.sleep(1000);
			//passwordField.clear();
			passwordField.sendKeys(password);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void clickLogin() throws InterruptedException {
		Thread.sleep(2000);
		logIn.click();

	}

	public void loginValidCredentials(String username, String password) throws InterruptedException {
		// TODO Auto-generated method stub
		this.clickLoginButton();
		this.enterEmail(username);
		this.enterPassword(password);
		this.clickLogin();

	}

	public void loginInvalidCredentials(String username, String wpassword) throws InterruptedException {
		this.clickLoginButton();
		this.enterEmail(username);
		this.enterPassword(wpassword);
		this.clickLogin();
		
	}

	public void cancel() throws InterruptedException {
		Thread.sleep(1000);
		cancel.click();
		
	}

	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		useraccount.click();
		Thread.sleep(2000);
		logout.click();
		
	}
	
	


}
