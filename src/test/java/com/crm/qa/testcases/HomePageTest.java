package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		//calls super class i.e.TestBase to initialize properties 
		super();
	}
	//will call initialization method from TestBase class so all the properties are defined.
		@BeforeMethod
		public void setUp() {
			//initializes driver, manages windows, and timeouts launches url
			initialization();
			testUtil=new TestUtil();
			contactsPage = new ContactsPage();
			loginPage = new LoginPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		@Test(priority=1)
		public void verifyHomePageTitleTest() {
			String homePageTitle = homePage.verifyHomePageTitle();
			Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
		}
		
		@Test(priority=2)
		public void verifyUserNameTest() {
			//Name is on a Frame so we first need to switch to the frame via testUtil method.
			testUtil.switchToFrame();
			Assert.assertTrue(homePage.verifyCorrectUserName()); 
		}
		
		@Test(priority=3)
		public void verifyContactsLinkTest() {
			testUtil.switchToFrame();
			contactsPage = homePage.clickOnContactsLink();
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
}
