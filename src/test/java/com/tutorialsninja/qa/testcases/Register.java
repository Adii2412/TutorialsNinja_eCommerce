package com.tutorialsninja.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utilities.Utilities;

public class Register extends Base
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver =initializeDriver("chrome");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	
	@Test(priority=1)
	public void verifyRegisteringAccountWithMandatoryFields() 
	{
		
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Adinath");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Mhetar");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("8928504071");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String successMessage= driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(successMessage, "Your Account Has Been Created!");
		Assert.assertTrue(driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/success"));
	
	}
	
	
	@Test(priority=2)
	public void verifyRegistrateringAccountWithAllFields() 
	{
		 
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Adinath");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Mhetar");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("8928504071");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String successMessage= driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(successMessage, "Your Account Has Been Created!");
		Assert.assertTrue(driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/success"));
		
		
	}
	
	
	@Test(priority=3)
	public void verifyRegistrationAccountWithExistingEmailAddress() 
	{
		 	
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Adinath");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Mhetar");
		driver.findElement(By.id("input-email")).sendKeys("arunmotoori3@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("8928504071");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
		String failureMessge=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());
		Assert.assertEquals(failureMessge, "Warning: E-Mail Address is already registered!");
			
		
	}
	
	@Test(priority=4)
	public void verifyRegisterationWithoutFillingAnyData() 
	{
		
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		

		String actualPrivacyPolicyWarning=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());
		Assert.assertEquals(actualPrivacyPolicyWarning, "Warning: You must agree to the Privacy Policy!");
		
//		Getting all actual warning messages
		String FirstNameWarning =driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
		String LastNameWarning = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
		String EmailWarning= driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
		String TelephoneWarning = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
		String PasswordWarning = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
		
//		verifying all warnings with expected warnings
		Assert.assertEquals(FirstNameWarning, "First Name must be between 1 and 32 characters!");
		Assert.assertEquals(LastNameWarning, "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(EmailWarning, "E-Mail Address does not appear to be valid!");
		Assert.assertEquals(TelephoneWarning,"Telephone must be between 3 and 32 characters!");
		Assert.assertEquals(PasswordWarning, "Password must be between 4 and 20 characters!");
		
	
	}
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
}
