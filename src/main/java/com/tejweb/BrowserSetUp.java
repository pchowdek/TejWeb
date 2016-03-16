package com.tejweb;//Abhijeet Goswami 06/Feb/2016

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserSetUp {
 public static WebDriver driver;
 

 
	//Application setup methods..
	public static WebDriver appSetUp(String product, String browser, String url)
			throws IOException {
		if (product.equalsIgnoreCase("tej")) {
			System.out.println("Tej suite Initialized....");
			} else {
			System.out.println("no product specified..");
		}
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Preferred Chrome....");
			System.out.println("Launching Chrome......");
			/*ChromeOptions options= new ChromeOptions();
			DesiredCapabilities capabilities =DesiredCapabilities.chrome();//Abhijeet Goswami 06/Feb/2016
			Proxy proxy = new Proxy();
			String httpProxy="10.135.80.164:8678";
			proxy.setHttpProxy(httpProxy);
			String ftpProxy="10.135.80.164:8678";
			proxy.setFtpProxy(ftpProxy);
			String sslProxy="10.135.80.164:8678";
			proxy.setSslProxy(sslProxy);
			capabilities.setCapability(httpProxy, httpProxy);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver= new ChromeDriver(capabilities);
			driver.manage().deleteAllCookies();*/
			driver = new ChromeDriver();
			
			
			
		} else if (browser.equalsIgnoreCase("firefox1")) {//Abhijeet Goswami 06/Feb/2016
			System.out.println("Preferred firefox....");
			System.out.println("Launching firefox......");
			/*FirefoxProfile profile= new FirefoxProfile();
			profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.http", "10.135.80.164");
			profile.setPreference("network.proxy.http_port", 8678);
			profile.setPreference("network.proxy.ssl", "10.135.80.164");
			profile.setPreference("network.proxy.ssl_port", 8678);
			profile.setPreference("network.proxy.ftp", "10.135.80.164");
			profile.setPreference("network.proxy.ftp_port", 8678);
			driver = new FirefoxDriver(profile);
			driver.manage().deleteAllCookies();*/
			driver= new FirefoxDriver();
			
			
		}else if (browser.equalsIgnoreCase("firefox")) {//Abhijeet Goswami 06/Feb/2016
			System.out.println("Preferred firefox....");
			System.out.println("Launching firefox......");
			/*FirefoxProfile profile= new FirefoxProfile();
			profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.http", "10.135.80.164");
			profile.setPreference("network.proxy.http_port", 8678);
			profile.setPreference("network.proxy.ssl", "10.135.80.164");
			profile.setPreference("network.proxy.ssl_port", 8678);
			profile.setPreference("network.proxy.ftp", "10.135.80.164");
			profile.setPreference("network.proxy.ftp_port", 8678);
			driver = new FirefoxDriver(profile);
			driver.manage().deleteAllCookies();*/
			driver= new FirefoxDriver();
			
			
		}  
		else if (browser.equalsIgnoreCase("safari")) {//Abhijeet Goswami 06/Feb/2016
			System.out.println("Preferred Safari....");
			System.out.println("Launching Safari......");
			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("Preferred Windows Edge....");
			System.out.println("Launching Windows Edge......");
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.out.println("Preferred IE....");
			System.out.println("Launching IE......");
			System.setProperty("webdriver.ie.driver","\\TejAutomationScripts\\TejWebAutomation\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else {
			System.out.println("Browser malfunction....");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		if (!url.isEmpty()) {
			System.out.println("opening url-->" + url);
			driver.get(url);
		} else
			System.out.println("url is empty");
		driver.manage().window().maximize();
		
	return driver;
	}

	
}
