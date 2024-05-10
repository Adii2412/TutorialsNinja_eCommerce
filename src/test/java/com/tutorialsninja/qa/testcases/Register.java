package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.pages.Registerpage;
import com.tutorialsninja.qa.utilities.Utilities;

public class Register extends Base
{
	WebDriver driver;
	public Register() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driver =initializeDriver(prop.getProperty("browser"));
		Homepage homepage = new Homepage(driver);
		homepage.clickOnMyAccountDropMenu();
		homepage.selectRegisterOption();
		
	}
	
	@Test(priority=1)
	public void verifyRegisteringAccountWithMandatoryFields() 
	{
		Registerpage registerpage = new Registerpage(driver);
		registerpage.enterFirstName(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmail(Utilities.generateEmailTimeStamp());
		registerpage.enterTelephone(dataprop.getProperty("telephone"));
		registerpage.enterPassword(dataprop.getProperty("password"));
		registerpage.enterConfirmPassword(dataprop.getProperty("password"));
		registerpage.selectPolicyCheckBox();
		registerpage.clickOnContinueButton();
		
		
		String successMessage= driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(successMessage, dataprop.getProperty("AccountCreatedSuccessMessage"));
		Assert.assertTrue(driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/success"));
	
	}
	
	
	@Test(priority=2)
	public void verifyRegistrateringAccountWithAllFields() 
	{
		 
		Registerpage registerpage = new Registerpage(driver);
		registerpage.enterFirstName(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmail(Utilities.generateEmailTimeStamp());
		registerpage.enterTelephone(dataprop.getProperty("telephone"));
		registerpage.enterPassword(dataprop.getProperty("password"));
		registerpage.enterConfirmPassword(dataprop.getProperty("password"));
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		registerpage.selectPolicyCheckBox();
		registerpage.clickOnContinueButton();
		
		
		String successMessage= driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(successMessage, dataprop.getProperty("AccountCreatedSuccessMessage"));
		Assert.assertTrue(driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/success"));
		
		
	}
	
	
	@Test(priority=3)
	public void verifyRegistrationAccountWithExistingEmailAddress() 
	{
		 	
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataprop.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataprop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("password"));
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
		String failureMessge=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());
		Assert.assertEquals(failureMessge, dataprop.getProperty("EmailAlreadyExistsWarning"));
		
	}
	
	@Test(priority=4)
	public void verifyRegisterationWithoutFillingAnyData() 
	{
		
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		

		String actualPrivacyPolicyWarning=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());
		Assert.assertEquals(actualPrivacyPolicyWarning, dataprop.getProperty("privacyPolicyWarning"));
		
//		Getting all actual warning messages
		String FirstNameWarning =driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
		String LastNameWarning = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
		String EmailWarning= driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
		String TelephoneWarning = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
		String PasswordWarning = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
		
//		verifying all warnings with expected warnings
		Assert.assertEquals(FirstNameWarning, dataprop.getProperty("firstNameWarning"));
		Assert.assertEquals(LastNameWarning, dataprop.getProperty("lastNameWarning"));
		Assert.assertEquals(EmailWarning, dataprop.getProperty("emailWarning"));
		Assert.assertEquals(TelephoneWarning,dataprop.getProperty("telephoneWarning"));
		Assert.assertEquals(PasswordWarning, dataprop.getProperty("passwordWarning"));
	
	}
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
}
