package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utilities.Utilities;

public class Login extends Base
{
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() 
	{
		
		driver=initializeDriver("chrome");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority = 2)
	public void verifyLoginWithValidCredentials() 
	{
		
		driver.findElement(By.id("input-email")).sendKeys("amotooricap3@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']")).isDisplayed());
		
		
	}
	
	
	@Test(priority = 1)
	public void verifyLoginWithInvalidCredentials() 
	{
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("1234560");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String warningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(warningMessage);
		
		Assert.assertEquals(warningMessage, "Warning: No match for E-Mail Address and/or Password.");
		
		
	}
	
	
	@Test(priority=3)
	public void verifyLoginWithValidEmailInvalidPassword()
	{
		
		driver.findElement(By.id("input-email")).sendKeys("amotooricap3@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("1234560");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String warningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(warningMessage);
		
		Assert.assertEquals(warningMessage, "Warning: No match for E-Mail Address and/or Password.");
		

	}
	
	
	@Test(priority=4)
	public void verifyLoginWithInvalidEmailvalidPassword()
	{
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String warningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(warningMessage);
		
		Assert.assertEquals(warningMessage, "Warning: No match for E-Mail Address and/or Password.");
		

	}

	@Test(priority=5)
	public void verifyLoginWithoutCredentials() 
	{
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String warningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(warningMessage);
		
		Assert.assertEquals(warningMessage, "Warning: No match for E-Mail Address and/or Password.");
		
	}
	
	
	

	
	
	
	
}
