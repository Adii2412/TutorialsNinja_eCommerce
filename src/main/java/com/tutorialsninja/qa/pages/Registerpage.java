package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage 
{
	
	WebDriver driver;
	
	public Registerpage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastname;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement termsAndpolicycheck;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
//	methods
	
	public void enterFirstName(String FirstName) {
	firstname.sendKeys(FirstName);	
		
	}
	
	public void enterEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void enterLastName(String LastName) {
		lastname.sendKeys(LastName);
	}
	
	public void enterTelephone(String Telephone) {
		telephone.sendKeys(Telephone);
	}
	
	public void enterPassword(String Password)
	{
		password.sendKeys(Password);
	}
	
	public void enterConfirmPassword(String Password)
	{
		confirmPassword.sendKeys(Password);
	}
	
	public void selectPolicyCheckBox()
	{
		termsAndpolicycheck.click();
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	
	
}
