package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Name:Obed
 * Date created:07/28/2020
 * Date modified:
 * Approved:Shanthosh
 * Email:
 */

public class DriverScript {
	
	public static WebDriver driver;
	public static Properties prop;
	
   
	public DriverScript()
	{
		try
		{
			File file = new File("./config/config.properties");
			FileInputStream fis = new FileInputStream(file);
		    prop = new Properties();
			prop.load(fis);
		}
	    catch(Exception e)
		{
	    	System.out.println("Unable to load the Properties file "+e.getMessage());
	    }
	
	}
		// once you are done with unit testing ensure to remove @test annotation else it will open dual browsers
		
	   public static void initBrowser()
		{
			String browser = prop.getProperty("browser");
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "./browsers/geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else
			{
				System.out.println("No Browser Specified Property");
			}
		
		     driver.manage().window().maximize();
		     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		     driver.manage().deleteAllCookies();
		     
		     
		      String url = prop.getProperty("qaurl");
		     driver.get(url);
		}		
		
}
			
	
		

