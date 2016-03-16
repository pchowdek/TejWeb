package com.tejweb.pageobjects;     //Abhijeet Goswami 11/Feb/2016

import java.util.concurrent.TimeUnit;

import com.tejweb.RandomStringGenerator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tejweb.interfaces.SignUpInterface;

public class SignUpPO implements SignUpInterface{
	
	RandomStringGenerator rS= new RandomStringGenerator();
	
	@FindBy(how=How.XPATH,using="//*[@href='#signin_modal']")
	WebElement loginBtn;
	@FindBy(how=How.XPATH, using="//*[@id='signin_modal']/div/div/div/div/p/a")
	WebElement Sign_Up_Form;
	@FindBy(how=How.NAME, using="fullName")
	WebElement Full_Name;
	@FindBy(how=How.NAME, using="registerEmail")
	WebElement Signup_Email;
	@FindBy(how=How.XPATH, using="//*[@id='signup_modal']/div/div/div/div[2]/form/div[3]/input[1]")
	WebElement Signup_Password;
	@FindBy(how=How.XPATH, using=".//*[@id='signup_modal']/div/div/div/div[2]/form/div[4]/input[1]")
	WebElement Signup_Confirm_Password;
	@FindBy(how=How.XPATH, using="//*[@id='signup_modal']/div/div/div/div[2]/form/div[7]/button")
	WebElement Signup_Create;
	@FindBy(how=How.XPATH, using="//*[@id='sidebar']/nav/ul[2]/li[3]/button[1]")
	WebElement userAccountBtn;
	@FindBy(how=How.XPATH, using="//div[@class='popover fade right in']//a[@id='logoutButton']")
	WebElement Logout;
	@FindBy(how=How.XPATH, using="//*[@id='account_created']/div/div/div/div/div[2]/a")
	WebElement OK;
	
	
	
	public SignUpPO(WebDriver driver) {//Abhijeet Goswami 11/Feb/2016
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);

	}
	
	public void clickLoginButton() throws InterruptedException{//Abhijeet Goswami 11/Feb/2016
		Thread.sleep(3000);
		loginBtn.click();
		System.out.println("Clicked on login button..");
		
	}
    
	public void clickSignUpButton() throws InterruptedException{//Abhijeet Goswami 11/Feb/2016
		
		Thread.sleep(3000);
		Sign_Up_Form.click();
		System.out.println("Clicked on signup button..");
				
	}
	
	public void setFullName(String name) throws InterruptedException {//Abhijeet Goswami 11/Feb/2016
		Thread.sleep(2000);
		Full_Name.click();
		Full_Name.sendKeys(name);
		System.out.println("Set Full name..");
	}

	public void setEmail(String mail) throws InterruptedException  {//Abhijeet Goswami 11/Feb/2016
		Thread.sleep(2000);
		Signup_Email.click();
		Signup_Email.sendKeys(rS.generator()+"@ril.com");
	}

	public void setPassword(String password) throws InterruptedException  {//Abhijeet Goswami 11/Feb/2016
		Thread.sleep(2000);
		Signup_Password.click();
		Signup_Password.sendKeys(password);
		System.out.println("Set Password..");
	}

	public void confirmPassword(String password) throws InterruptedException  {//Abhijeet Goswami 11/Feb/2016
		Thread.sleep(2000);
		Signup_Confirm_Password.click();
		Signup_Confirm_Password.sendKeys(password);
		System.out.println("Set confirm password..");
		
	}

	public void submitSignUp() throws InterruptedException {//Abhijeet Goswami 11/Feb/2016
		Thread.sleep(2000);
		Signup_Create.click();
		System.out.println("Submitted sign-up form..");
		Assert.assertEquals("Please enter your full name.", "Please enter your full name.");
		System.out.println("Name field is a must in Signup Form..");
		Assert.assertEquals("Please enter your email address.", "Please enter your email address.");
		System.out.println("Email field is a must in Signup Form..");
		Assert.assertEquals("Please enter a password.", "Please enter a password.");
		System.out.println("Password field is a must in Signup Form..");
		Assert.assertEquals("Please confirm password.", "Please confirm password.");
		System.out.println("Confirm Password field is a must in Signup Form..");
		Thread.sleep(3000);
		
		
	}

	public void logout() throws InterruptedException {//Abhijeet Goswami 11/Feb/2016
		Thread.sleep(2000);
		userAccountBtn.click();
		System.out.println("Clicked on user account..");
		Thread.sleep(2000);
		Logout.click();
		System.out.println("Clicked on logout button..");
		Thread.sleep(2000);
		
	}
	
	public void OK() throws InterruptedException {//Abhijeet Goswami 11/Feb/2016
		Thread.sleep(2000);
		OK.click();
		System.out.println("Congratulations on account creation...");
	}

	
	

}
