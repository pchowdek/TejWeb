package com.tejweb.pageobjects;//Abhijeet Goswami 09/Feb/2016

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.tejweb.TableReader;
import com.tejweb.interfaces.DeleteFilesInterface;

public class DeleteFilesPO implements DeleteFilesInterface {

	public WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[@href='#signin_modal']")
	WebElement loginBtn;
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	WebElement emailField;
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'LOG IN')]")
	WebElement logIn;
	@FindBy(how = How.XPATH, using = "//*[@id='optionContainer']/div[3]/div[5]/a[2]/div/span")
	WebElement viewchanger;
	@FindBy(how = How.XPATH, using = "//*[@id='sidebar']/nav/ul[2]/li[2]/a/div/span[2]")
	WebElement Trash;
	@FindBy(how = How.XPATH, using = "//*[@id='container']/div[3]/div[2]/div/div/div[2]/div/button[1]")
	WebElement Restore_All;
	@FindBy(how = How.XPATH, using = "//*[@id='container']/div[3]/div[2]/div/div/div[2]/div/button[2]")
	WebElement Delete_All;
	@FindBy(how = How.XPATH, using = "//*[@id='deletefilemodal']/div/div/div/div/div[4]/a[1]")
	WebElement Delete_Forever;
	@FindBy(how=How.XPATH, using="//*[@id='sidebar']/nav/ul[2]/li[3]/button[1]")
	WebElement userAccountBtn;
	@FindBy(how=How.XPATH, using="//div[@class='popover fade right in']//a[@id='logoutButton']")
	WebElement Logout;
	@FindBy(how=How.XPATH, using="//*[@id='sidebar']/nav/ul[1]/li[1]/a/div/span[2]")
	WebElement Files;
	String tableLOcator = "//*[@id='rowselect']/tbody";
	
	TableReader read = new TableReader(driver);
	
	
	public DeleteFilesPO(WebDriver driver){//Abhijeet Goswami 09/Feb/2016
		
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickLoginButton() throws InterruptedException {//Abhijeet Goswami 09/Feb/2016
		Thread.sleep(2000);
		loginBtn.click();
		
		}
		
	public void clickLogin() throws InterruptedException {//Abhijeet Goswami 09/Feb/2016
		Thread.sleep(2000);
		logIn.click();
		Thread.sleep(4000);
		
	}

	public void enterEmail(String username)throws InterruptedException  {//Abhijeet Goswami 09/Feb/2016
		
			Thread.sleep(1000);
			emailField.clear();
			Thread.sleep(1000);
			emailField.sendKeys(username);
				
	}

	public void enterPassword(String password)throws InterruptedException {//Abhijeet Goswami 09/Feb/2016
		
			Thread.sleep(1000);
			passwordField.clear();
			Thread.sleep(1000);
			passwordField.sendKeys(password);
		
		
	}

	public void selectfilesToDelete(WebDriver driver) throws InterruptedException {//Abhijeet Goswami 09/Feb/2016
		
			
				Thread.sleep(2000);
				TableReader.deleteTableFiles(tableLOcator, driver);
				System.out.println("Iterated on table..");
			
		}
		
    public void logout() throws InterruptedException {//Abhijeet Goswami 09/Feb/2016
		Thread.sleep(2000);
		userAccountBtn.click();
		Thread.sleep(2000);
		System.out.println("Clicked on user account..");
		Logout.click();
		System.out.println("LOgged of the system..");
		
	}

	public void changeView() throws InterruptedException {//Abhijeet Goswami 09/Feb/2016
		
			//Thread.sleep(2000);
			viewchanger.click();
			System.out.println("Landed on list view..");
			Thread.sleep(2000);	
	}

	public void deleteForever() throws InterruptedException {//Abhijeet Goswami 09/Feb/2016
		Thread.sleep(2000);
		Trash.click();
		Thread.sleep(2000);
		Delete_All.click();
		Thread.sleep(2000);
		Delete_Forever.click();
		System.out.println("Deleted all files forever..");
	}

	public void opentrashtoverify() throws InterruptedException {//Abhijeet Goswami 09/Feb/2016
		Thread.sleep(2000);
		Trash.click();
		Thread.sleep(2000);
		Restore_All.click();
		System.out.println("Restored all files ....");
		
	}

    public void returntoFiles() throws InterruptedException {//Abhijeet Goswami 09/Feb/2016
		Thread.sleep(2000);
		Files.click();
		System.out.println("Returned to file view..");
		Thread.sleep(3000);
		
	}

	
	
	
	
	
}
