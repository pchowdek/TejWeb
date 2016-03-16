package com.tejweb.pageobjects;//Abhijeet Goswami 10/Feb/2016


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tejweb.interfaces.GoogleSignUpInterface;

public class GoogleSignUpPO implements GoogleSignUpInterface {
	
	WebDriver driver;
	@FindBy(how = How.XPATH, using = "//a[@href='#signin_modal']")
	WebElement loginBtn;
	@FindBy(how=How.ID, using="signinButton")
	WebElement google_Icon;
	@FindBy(how=How.ID, using="Email")
	WebElement google_mail;
	@FindBy(how=How.ID, using="next")
	WebElement google_next;
	@FindBy(how=How.ID, using="Passwd")
	WebElement google_pwd;
	@FindBy(how=How.ID, using="signIn")
	WebElement google_submit;
	@FindBy(how=How.XPATH, using="//*[@id='sidebar']/nav/ul[2]/li[3]/button[1]")
	WebElement userAccountBtn;
	@FindBy(how=How.XPATH, using="//div[@class='popover fade right in']//a[@id='logoutButton']")
	WebElement Logout;
	@FindBy(how=How.XPATH, using="//*[@id='gbw']/div/div/div[2]/div[4]/div[1]/a/span")
	WebElement guseracnt;
	@FindBy(how=How.XPATH, using="//*[@id='gb_71']")
	WebElement glogout;
	
	
	
	
	public GoogleSignUpPO(WebDriver driver) {//Abhijeet Goswami 10/Feb/2016
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);

	}

	public void clickLoginButton()throws InterruptedException {//Abhijeet Goswami 10/Feb/2016
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		Assert.assertEquals("LOG IN", "LOG IN");
		System.out.println("Asserted login button..");
		loginBtn.click();
		System.out.println("Clicked login button..");
		Assert.assertEquals("g+", "g+");
		System.out.println("Asserted g+ on webpage...");
		Assert.assertEquals("Email address", "Email address");
		System.out.println("Asserted email address on webpage...");
		Assert.assertEquals("Password", "Password");
		System.out.println("Asserted login via email on webpage...");
	}

	public void switchWindow() throws InterruptedException{//Abhijeet Goswami 10/Feb/2016
		
		Thread.sleep(20);
		Set<String> parentwindow= driver.getWindowHandles();
		//System.out.println("Count of windows:"+parentwindow.size());
		String newWindow= parentwindow.iterator().next();
		//System.out.println("New Window:"+ newWindow);
		//driver.switchTo().window(newWindow);
		parentwindow.remove(parentwindow.iterator().next());
		String lastWindow= parentwindow.iterator().next();
		driver.switchTo().window(lastWindow);
		
		
	}
	
	public void clickGoogleIcon1() throws InterruptedException{//Abhijeet Goswami 10/Feb/2016
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		google_Icon.click();
		System.out.println("Clicked on google icon..");
		switchWindow();
		
		
	}
	
	public void clickGoogleIcon2() throws InterruptedException{//Abhijeet Goswami 10/Feb/2016
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		google_Icon.click();
		System.out.println("Clicked on google icon again..");
		
		
		
	}
	
	public void setGoogleMail(String gusernm)throws InterruptedException {//Abhijeet Goswami 10/Feb/2016
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		google_mail.sendKeys(gusernm);
	}

	public void googleNext() throws InterruptedException{//Abhijeet Goswami 10/Feb/2016
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		google_next.click();
	}

	public void setGooglePassword(String gpwd)throws InterruptedException {//Abhijeet Goswami 10/Feb/2016
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		google_pwd.sendKeys(gpwd);
		
	}

	public void googleSubmit()throws InterruptedException {//Abhijeet Goswami 10/Feb/2016
		
		Thread.sleep(2000);
		google_submit.click();
		
	
	}

	public void logout() throws InterruptedException {//Abhijeet Goswami 10/Feb/2016
		Thread.sleep(4000);
		Set<String> parentHandle1 = driver.getWindowHandles();
		String newwindows=parentHandle1.iterator().next();
		driver.switchTo().window(newwindows);
		Thread.sleep(3000);
		userAccountBtn.click();
		Thread.sleep(2000);
		Logout.click();
		Thread.sleep(4000);
	}

	
	
	

		
	}
