package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	WebDriver driver;
	
	
//	objects
	public Homepage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement Loginbutton;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement Registerbutton;
	
//	Actions
	
	public void clickOnMyAccountDropMenu() {
		
		myAccountDropMenu.click();
	}
	
	public void selectLoginOption() {
		Loginbutton.click();
	}
	
	public void selectRegisterOption() {
		Registerbutton.click();
	}
	
	
}
