package com.tejweb;//Abhijeet Goswami 07/Feb/2016

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tejweb.RandomStringGenerator;



public class TableReader {//Abhijeet Goswami 07/Feb/2016
	
	WebDriver driver;
	public static int row_count;
	public static RandomStringGenerator generator = new RandomStringGenerator();

	public TableReader(WebDriver driver) {//Abhijeet Goswami 07/Feb/2016
		this.driver = driver;
	}
	
	
	public static void  deleteTableFiles(String tableLOcator,WebDriver driver) throws InterruptedException{//Abhijeet Goswami 07/Feb/2016
		System.out.println("Fetching tables in Web Page..");
		
		WebElement table = driver.findElement(By.xpath(tableLOcator));
		WebElement delete= driver.findElement(By.xpath("//*[@id='contextMenuContainer']/li[8]/a"));
		WebElement DELETE= driver.findElement(By.xpath("//*[@id='deletefilemodal']/div/div/div/div/div[4]/a[1]"));
		System.out.println("Landed on Web table..");
		ArrayList<WebElement> table_rows = new ArrayList<WebElement>();
		table_rows= (ArrayList<WebElement>) table.findElements(By.tagName("tr"));
		row_count = table_rows.size();
		System.out.println("A total of "+row_count+" files are found in the table..");  
		for(int row=1;row<=row_count;row_count--){
		Actions action= new Actions(driver);
		WebElement act =  driver.findElement(By.xpath(tableLOcator+"/tr[" + row+ "]/td["+row+"]"));
		action.contextClick(act).build().perform();
		Thread.sleep(1000);
		delete.click();
		Thread.sleep(1000);
		DELETE.click();
		Thread.sleep(1000);
		System.out.println("Performed action on file in row :" +row);
		}
		System.out.println(+(row_count--)+ "files remaining on the table..");
		
		
	}
	
	public static void  renameTableFiles(String tableLOcator,WebDriver driver2) throws InterruptedException{//Abhijeet Goswami 07/Feb/2016
		System.out.println("Fetching tables in Web Page..");
		
		WebElement table = driver2.findElement(By.xpath(tableLOcator));
		WebElement rename= driver2.findElement(By.xpath("//*[@id='contextMenuContainer']/li[6]/a"));
		WebElement name_field= driver2.findElement(By.name("new_object_name"));
		WebElement rename_OK= driver2.findElement(By.className("icon-Check"));
		WebElement File_Info= driver2.findElement(By.id("file_info"));
		//WebElement Close_Info= driver2.findElement(By.className("file_info_close"));
		System.out.println("Landed on Web table..");
		ArrayList<WebElement> table_rows = new ArrayList<WebElement>();
		table_rows= (ArrayList<WebElement>) table.findElements(By.tagName("tr"));
		row_count = table_rows.size();
		System.out.println("A total of "+row_count+" files are found in the table..");  
		for(int row=1;row==1;row++){
		Actions action= new Actions(driver2);
		WebElement act =  driver2.findElement(By.xpath(tableLOcator+"/tr[" + row+ "]/td["+row+"]"));
		action.contextClick(act).build().perform();
		File_Info.click();
		Thread.sleep(2000);
		action.contextClick(act).build().perform();
		Thread.sleep(500);
		rename.click();
		Thread.sleep(500);
		name_field.clear();
		Thread.sleep(500);
		//name_field.sendKeys(generator.generator());
		name_field.sendKeys("Zebra File");
		Thread.sleep(1000);
		rename_OK.click();
		Thread.sleep(2000);
		System.out.println("Performed action on file in row :" +row);
		}
		System.out.println(+(row_count--)+ " files remaining on the table..");
		
		
	}
	
}
