package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.Accountpage;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.pages.Loginpage;
import com.tutorialsninja.qa.utilities.Utilities;

public class Login extends Base
{
	WebDriver driver;
	public Login() {
		super();
	}
	
	@BeforeMethod
	public void setup() 
	{
		
		driver=initializeDriver(prop.getProperty("browser"));
		Homepage homepage=new Homepage(driver);
		homepage.clickOnMyAccountDropMenu();
		homepage.selectLoginOption();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority = 2)
	public void verifyLoginWithValidCredentials() 
	{
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterEmailAddress(prop.getProperty("email"));
		loginpage.enterPassword(prop.getProperty("password"));
		loginpage.clickOnLoginButton();
		
		Accountpage accountpage = new Accountpage(driver);
		Assert.assertTrue(accountpage.getDisplayStatusOfEditYourAccountInformationOption());
		
	}
	
	
	@Test(priority = 1)
	public void verifyLoginWithInvalidCredentials() 
	{
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterEmailAddress(Utilities.generateEmailTimeStamp());
		loginpage.enterPassword(dataprop.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		
		String warningMessage=loginpage.getWarningMessage();
		
		
		Assert.assertEquals(warningMessage, dataprop.getProperty("emailpasswordNomatchWarning") );
		
		
	}
	
	
	@Test(priority=3)
	public void verifyLoginWithValidEmailInvalidPassword()
	{
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterEmailAddress(prop.getProperty("email"));
		loginpage.enterPassword(dataprop.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		
		String warningMessage=loginpage.getWarningMessage();
		Assert.assertEquals(warningMessage, dataprop.getProperty("emailpasswordNomatchWarning"));
	}	
	
	
	@Test(priority=4)
	public void verifyLoginWithInvalidEmailvalidPassword()
	{
		
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterEmailAddress(Utilities.generateEmailTimeStamp());
		loginpage.enterPassword(prop.getProperty("password"));
		loginpage.clickOnLoginButton();
		
		String warningMessage=loginpage.getWarningMessage();
		Assert.assertEquals(warningMessage, dataprop.getProperty("emailpasswordNomatchWarning"));
		

	}

	@Test(priority=5)
	public void verifyLoginWithoutCredentials() 
	{
		Loginpage loginpage = new Loginpage(driver);
		loginpage.clickOnLoginButton();
		
		String warningMessage=loginpage.getWarningMessage();
		Assert.assertEquals(warningMessage, dataprop.getProperty("emailpasswordNomatchWarning"));
		
	}
	
	
	

	
	
	
	
}
