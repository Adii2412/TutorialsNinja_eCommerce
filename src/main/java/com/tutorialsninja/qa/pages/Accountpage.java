package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage 
{
	WebDriver driver;
	
	public Accountpage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Edit your account information']")
	private WebElement editYourAccountInformationOption;
	
	
	public boolean getDisplayStatusOfEditYourAccountInformationOption() {
		return editYourAccountInformationOption.isDisplayed();
	}
	
}
