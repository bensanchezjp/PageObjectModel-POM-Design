package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

//Three test cases are run in LoginPage, so browser will be opened three different times
//Test #1: Test that the Page Title is CRMPRO - CRM software for customer relationship management, sales, and support.
//Test #2: Test that the CRM Logo is present
//Test #3: Test that you are able to login
public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	//constructor calls TestBase method
	public LoginPageTest() {
		super();
	}
	
	
	//will call initialization method from TestBase class so all the properties are defined.
	@BeforeMethod
	public void setUp() {
		//sets driver, manages windows, and timeouts
		initialization();
		loginPage = new LoginPage();
	}
	
	//Testing to see if page title matches & explicitly defining test execution priority
	//otherwise it priorities will be run alphabetically.
	@Test(priority=1) 
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	//Testing if Logo matches & explicitly defining test execution priority
	//otherwise it priorities will be run alphabetically.
	@Test(priority=2) 
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	//Tests if login credentials are valid. Taken from config.properties file
	//& explicitly defining test execution priority //otherwise it priorities will be run alphabetically.
	//Access to prop object due because it is inherited from TestBase class.
	@Test(priority=3) 
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
