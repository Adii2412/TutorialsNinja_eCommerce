package com.tutorialsninja.qa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	WebDriver driver;
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
		
		
		 	driver.get("https://tutorialsninja.com/demo/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			return driver;
	}
	
	
	
	
}
