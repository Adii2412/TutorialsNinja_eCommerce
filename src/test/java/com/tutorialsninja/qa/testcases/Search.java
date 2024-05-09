package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class Search extends Base
{
	
	WebDriver driver;
	
	public Search() {
		super();
	}
	
	//------------------------------------------------------------------------
	
	@BeforeMethod
	public void setup() {
		driver =initializeDriver(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	//--------------------Tests----------------------------------------------------
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() 
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("HP");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
	}
	
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() 
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataprop.getProperty("invalidProduct"));
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		String ActualSearchMessage = driver.findElement(By.xpath("//div[@id='content']//h2/following-sibling::p")).getText();
		Assert.assertEquals(ActualSearchMessage, dataprop.getProperty("invalidProductMessage"));
		
	}
	
	@Test(priority=3)
	public void verifySearchWithoutProduct() 
	{
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		String ActualSearchMessage = driver.findElement(By.xpath("//div[@id='content']//h2/following-sibling::p")).getText();
		Assert.assertEquals(ActualSearchMessage, dataprop.getProperty("invalidProductMessage"));
		
	}
	
}
