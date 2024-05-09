package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	webelements------------------------------------------------------
	
	@FindBy(id="input-email")
	private WebElement emailInputField;
	
	@FindBy(id="input-password")
	private WebElement passwordInputField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
//	methods-----------------------------------------------------------
	public void enterEmailAddress(String email) 
	{
		emailInputField.sendKeys(email);
	}
	
	public void enterPassword(String password) 
	{
		passwordInputField.sendKeys(password);
	}
	
	public void clickOnLoginButton() 
	{
		loginButton.click();
	}
	
	public String getWarningMessage() 
	{
		return warningMessage.getText();
	}
}
