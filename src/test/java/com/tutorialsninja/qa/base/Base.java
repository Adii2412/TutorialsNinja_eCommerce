package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utilities.Utilities;

public class Base 
{
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public Base() {
		
		prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")+"//src//main//java//com//tutorialsninja//qa//config//config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(propfile);
			prop.load(fis);
		} catch (Throwable e) {
			
			e.printStackTrace();
			
		}
		
		dataprop = new Properties();
		File datapropfile = new File(System.getProperty("user.dir")+"//src//main//java//com//tutorialsninja//qa//testdata//testdata.properties");
		try
		{
			FileInputStream datafis = new FileInputStream(datapropfile);
			dataprop.load(datafis);
			
		}catch(Throwable e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public WebDriver initializeDriver(String BrowserName) {

		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			
			driver= new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
					
		}
		else if(BrowserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		 	driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIMER));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIMER));
			
			return driver;
	}
	
}
