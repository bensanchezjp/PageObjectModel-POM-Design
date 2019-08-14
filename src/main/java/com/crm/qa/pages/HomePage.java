package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	//@CacheLookup stores userNamelabel in cache so it can be retrieved faster. 
	//Otherwise, it will retrieve from the DOM (Document Object Model)
	//Applied only to elements where you think element will not change otherwise
	//You'll get an element exception
	@FindBy(xpath="//td[contains(text(),'User: Benjamin Sanchez Murillo')]")
	@CacheLookup
	WebElement userNamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	//Finds the path for New Contact List
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//HomePage constructor will initialize HomePage objects/variables above using WebDriver
		public HomePage(){
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyCorrectUserName() {
			return userNamelabel.isDisplayed();
		}
		
		public ContactsPage clickOnContactsLink() {
			contactsLink.click(); 
			return new ContactsPage();
		}
		
		public DealsPage clickOnDealsLink() {
			dealsLink.click();
			return new DealsPage();
		}
		
		public TaskPage clickOnTasksLink() {
			tasksLink.click();
			return new TaskPage();
		}
		
		public void clickOnNewContactLink() {
			//Hovers over Contacts page
			Actions action = new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			
			//clicks on New Contacts Link
			newContactLink.click();
			
		}
		
}
