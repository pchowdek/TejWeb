package com.tejweb.pageobjects; //Abhijeet Goswami 15/Feb/2016


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import com.tejweb.RandomStringGenerator;
import com.tejweb.TableReader;
import com.tejweb.interfaces.FilesNFolders;

public class FilesNFoldersPO implements FilesNFolders {
	
	
    WebDriver driver;
	RandomStringGenerator rS= new RandomStringGenerator();
	TableReader read = new TableReader(driver);
	
	@FindBy(how = How.XPATH, using = "//a[@href='#signin_modal']")
	WebElement loginBtn;
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	WebElement emailField;
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'LOG IN')]")
	WebElement logIn;
	@FindBy(how=How.XPATH, using="//*[@id='sidebar']/nav/ul[2]/li[3]/button[1]")
	WebElement userAccountBtn;
	@FindBy(how=How.XPATH, using="//div[@class='popover fade right in']//a[@id='logoutButton']")
	WebElement Logout;
	@FindBy(how=How.XPATH, using="//*[@id='optionContainer']/div[2]/a/span")
	WebElement New_Folder;
	@FindBy(how=How.ID, using="create_folder")
	WebElement Folder_Name;
	@FindBy(how=How.XPATH, using="//*[@id='createfoldermodal']/div/div/div/div/form/div[4]/a")
	WebElement Create_Folder;
	@FindBy(how = How.XPATH, using = "//*[@id='optionContainer']/div[3]/div[5]/a[2]/div/span")
	WebElement viewchanger;
	@FindBy(how = How.XPATH, using = "//*[@id='defaultContextMenu']/li[1]/a")
	WebElement createfolder_contextclick;
	@FindBy(how = How.ID, using = "fileTest")
	WebElement upload_Button;
	@FindBy(how = How.XPATH, using = "//*[@id='imgover']/div[2]/span[5]")
	WebElement share;
	@FindBy(how = How.XPATH, using = "//*[@id='sharemodal']/div/div/div/div/form/div[4]/div[2]/a")
	WebElement link_copy;
	@FindBy(how = How.XPATH, using = "//*[@id='sharemodal']/div/div/div/button")
	WebElement close_share;
	@FindBy(how = How.XPATH, using = "//*[@id='rowselect']/tbody/tr/td[1]/div/a[3]/span")
	WebElement first_file;
	@FindBy(how = How.XPATH, using = "//*[@id='contextMenuContainer']/li[4]/a")
	WebElement copy;
	@FindBy(how = How.XPATH, using = "//*[@id='contextMenuContainer']/li[3]/a")
	WebElement move;
	@FindBy(how = How.XPATH, using = "//*[@id='movemodal']/div/div/div/div/div[2]/div[3]/span")
	WebElement move_to;
	@FindBy(how = How.XPATH, using = "//*[@id='movemodal']/div/div/div/div/div[2]/div[1]/span")
	WebElement copy_to;
	@FindBy(how = How.XPATH, using = "//*[@id='movemodal']/div/div/div/div/div[3]/button[2]")
	WebElement COPY_Button;
	@FindBy(how = How.XPATH, using = "//*[@id='movemodal']/div/div/div/div/div[3]/button[1]")
	WebElement MOVE_Button;
	@FindBy(how = How.XPATH, using = "//*[@id='sidebar']/nav/ul[1]/li[1]/div/ul/li[4]/a/span")
	WebElement Audio_Tab;
	@FindBy(how = How.XPATH, using = "//*[@id='sidebar']/nav/ul[1]/li[1]/div/ul/li[3]/a/span")
	WebElement Documents_Tab;
	String tableLOcator = "//*[@id='rowselect']/tbody";
	String  table_area= "//*[@id='mainContainerArea']" ;
	
	
	
	public FilesNFoldersPO(WebDriver driver) {//Abhijeet Goswami 15/Feb/2016
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	public void clickLoginButton() throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		Thread.sleep(2000);
		loginBtn.click();
		System.out.println("Clicked on login..");
		
		}

	public void clickLogin() throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		Thread.sleep(2000);
		logIn.click();
		System.out.println("Clicked on submit..");
		Thread.sleep(4000);
		
	}

	public void enterEmail(String username)throws InterruptedException  {//Abhijeet Goswami 15/Feb/2016
		
			Thread.sleep(1000);
			emailField.clear();
			Thread.sleep(1000);
			emailField.sendKeys(username);
			System.out.println("Passed username..");
				
	}

	public void enterPassword(String password)throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		
			Thread.sleep(1000);
			passwordField.clear();
			Thread.sleep(1000);
			passwordField.sendKeys(password);
			System.out.println("Passed password..");
		
		
	}

	public void clickonNewFolder() throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		Thread.sleep(2000);
		New_Folder.click();
		System.out.println("Clicked on New Folder button..");
		
	}

	public void setFileName(String fname) throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		Folder_Name.clear();
		Thread.sleep(1000);
		Folder_Name.sendKeys(rS.generator());
		System.out.println("Passed folder name..");
		Thread.sleep(1000);
		
	}
	
	public void createFile() throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		Create_Folder.click();
		System.out.println("Clicked on Create..");
		Thread.sleep(1000);
		
	}

	public void clickonUserAccount() throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		Thread.sleep(2000);
		userAccountBtn.click();
		Thread.sleep(2000);
		System.out.println("Clicked on user account..");
		
	}

	
	public void changeView() throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		Thread.sleep(2000);
		viewchanger.click();
		System.out.println("Landed on list view..");
		Thread.sleep(2000);
		
	}
	
	public void createFolderByRightClick(WebDriver driver) throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		Actions actions = new Actions(driver);
		WebElement act =  driver.findElement(By.xpath(table_area));
		actions.contextClick(act).build().perform();
		Thread.sleep(1000);
		createfolder_contextclick.click();
		System.out.println("Right clicked on table..");
		Thread.sleep(1000);
		
	}
	
	public void renameFolderByRightClick(WebDriver driver)throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		    Thread.sleep(3000);
		    TableReader.renameTableFiles(tableLOcator, driver);
			Thread.sleep(2000);
			System.out.println("Iterated on table.. .");
		
	}

	/*public void fileupload(WebDriver driver) throws InterruptedException, AWTException {
		Thread.sleep(3000);
		upload_Button.click();
		Thread.sleep(2000);
		WebElement a = driver.switchTo().activeElement();
		a.sendKeys("/home/rakshita/Downloads/ABHIJEET GOSWAMI.docx");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}*/

	
	public void shareURL(WebDriver driver) throws InterruptedException, AWTException {//Abhijeet Goswami 15/Feb/2016
		Thread.sleep(2000);
		first_file.click();
		Thread.sleep(1000);
		share.click();
		Thread.sleep(1000);
		link_copy.click();
		Thread.sleep(1000);
		close_share.click();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Opened URL in new tab..");
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_W);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		robot.delay(1000);
		System.out.println("Done with sharing..");
		
		
	}

	public void logout(WebDriver driver) throws InterruptedException,AWTException {//Abhijeet Goswami 15/Feb/2016
		Thread.sleep(2000);
		Logout.click();
		System.out.println("LOgged of the system..");
		Thread.sleep(2000);
		driver.close();
	}

	public void copyFiles(WebDriver driver) throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		Actions actions = new Actions(driver);
		WebElement file= driver.findElement(By.xpath("//*[@id='rowselect']/tbody/tr[2]/td[1]"));
		Thread.sleep(2000);
		actions.contextClick(file).build().perform();
		Thread.sleep(2000);
		copy.click();
		Thread.sleep(2000);
		copy_to.click();
		Thread.sleep(2000);
		COPY_Button.click();
		Thread.sleep(3000);
		System.out.println("Copied folder..");
	}

	public void moveFiles(WebDriver driver) throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		Actions actions = new Actions(driver);
		WebElement file= driver.findElement(By.xpath("//*[@id='rowselect']/tbody/tr[1]/td[1]"));
		Thread.sleep(3000);
		actions.contextClick(file).build().perform();
		Thread.sleep(2000);
		move.click();
        Thread.sleep(2000);
		move_to.click();
		Thread.sleep(2000);
		MOVE_Button.click();
		Thread.sleep(2000);
		System.out.println("Moved Folder..");
		
	}

	public void audioTab() throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		Thread.sleep(3000);
		Audio_Tab.click();
		Thread.sleep(2000);
		System.out.println("Clicked on Audio Tab..");
		
	}

	public void documentTab() throws InterruptedException {//Abhijeet Goswami 15/Feb/2016
		Thread.sleep(3000);
		Documents_Tab.click();
		System.out.println("Clicked on Documents Tab..");
		Thread.sleep(3000);
	}

	public void audioupload(WebDriver driver) throws InterruptedException,AWTException {//Abhijeet Goswami 15/Feb/2016
		Thread.sleep(3000);
		upload_Button.click();
		Thread.sleep(2000);
		WebElement a = driver.switchTo().activeElement();
		a.sendKeys("/home/rakshita/Music/audio.mp3");
		a.sendKeys("/home/rakshita/Music/music.mp3");
		a.sendKeys("/home/rakshita/Music/song.mp3");
		Robot robot = new Robot();
		/*robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);*/
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	public void documentupload(WebDriver driver) throws InterruptedException,AWTException {//Abhijeet Goswami 15/Feb/2016
		Thread.sleep(3000);
		upload_Button.click();
		Thread.sleep(2000);
		WebElement a = driver.switchTo().activeElement();
		a.sendKeys("/home/rakshita/Downloads/ABHIJEET GOSWAMI 1.docx");
		Robot robot = new Robot();
		/*robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_TAB);*/
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	
	}


