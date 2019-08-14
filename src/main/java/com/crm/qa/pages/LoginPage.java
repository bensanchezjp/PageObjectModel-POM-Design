package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//an alternate way to find elements using @FindBy annotation /page object repositories
	//defining page libraries
	@FindBy(name="username")
	WebElement username;
		
	@FindBy(name="password")
	WebElement password;
	
	//@FindBy(xpath="//input[@type='submit']") //This xpath works also
	@FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div/div/input")
	WebElement loginBtn;
	
	@FindBy(linkText = "Sign Up")
	WebElement signUpBtn;
	
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	
	//LoginPage constructor will initialize LoginPage objects/variables above using WebDriver
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	 
	//returns title of the page
	public String validateLoginPageTitle() {
		return driver.getTitle();	
	}
	
	//verify image
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);	
		loginBtn.submit(); 
		
		return new HomePage();
	}
	
}	