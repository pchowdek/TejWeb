package com.tejweb.generics;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import com.tejweb.generics.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class Utility 
{
	ExtentReports reports;
	ExtentTest logger;
	WebDriver Driver;
	
	/**
	 * This method will capture screenshot evertime its called
	 * @param driver
	 * @param screenshotName
	 * @return
	 */
public String captureScreenshot(WebDriver driver, String screenshotName){
	try
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = "./Screenshots/"+screenshotName+".png";
		File destination = new File (dest);
		FileUtils.copyFile(source, destination);
		Log.info("Screenshot successfully taken");
		return dest;
	   
	}catch (Exception e){
		return e.getMessage();
	}
}	

/**
 * This method will switch the control to next active window
 * @param driver
 * @throws InterruptedException
 */


public void switchWindow(WebDriver driver) throws InterruptedException{//Abhijeet Goswami 10/Feb/2016
	
	Thread.sleep(500);
	Set<String> parentWindow= driver.getWindowHandles();
	Log.info("Number of windows : "+ parentWindow.size());
	parentWindow.remove(parentWindow.iterator().next());
	String lastWindow= parentWindow.iterator().next();
	Log.info("WindowHandle for new window : "+ lastWindow);
	driver.switchTo().window(lastWindow);
}

/**
 * This method will generate a unique ID using the current date/time stamps
 * @return
 * @throws InterruptedException
 */


public String generateID() throws InterruptedException{
	try{
		
	Date ndate = new Date();
	SimpleDateFormat nft1 = new SimpleDateFormat("YYYYMMdd");
	SimpleDateFormat nft2 = new SimpleDateFormat("hhmmss");
	nft1.setTimeZone(TimeZone.getTimeZone("GMT"));
	nft2.setTimeZone(TimeZone.getTimeZone("GMT"));
	String uniqueID = nft1.format(ndate)+nft2.format(ndate);
	Thread.sleep(2000);
	return uniqueID;
    
    }catch(Exception e){
    	
		Log.info("Exception occured while generating unique ID");
		return e.getMessage();
	}
}

/**
 * This method will higlight the webelement before execution
 * @param driver
 * @param element
 */

public void highLightElement(WebDriver driver, WebElement element)
{
JavascriptExecutor js=(JavascriptExecutor)driver; 

js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

try 
{
Thread.sleep(500);
} 
catch (InterruptedException e) {

System.out.println(e.getMessage());
} 

js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element); 

}


/**
 * This method will wait for 120 seconds till the webpage is loaded
 * @param driver
 */
public void pageLoadComplete(WebDriver driver) {

try{
	driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	Log.info("Page load complete");
	
	}catch (Exception e){
		
	e.printStackTrace();
	Log.info("Page failed to load after specified wait time");
    }
   }
 }
