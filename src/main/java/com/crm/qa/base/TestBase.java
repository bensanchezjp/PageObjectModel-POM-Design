package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	//Placing config.properties contents to ip variable and loading it using Properties variable.
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/eljami/eclipse-workspace/FreeCRMTest/src/main/java/com/crm"
					+ "/qa/config/config.properties"); 
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	//checks config.properites file and verifies which browser is it that I want to use.
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/eljami/Documents/selenium-java-3/chromedriver/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver","/Users/eljami/Documents/selenium-java-3/geckodriver/geckodriver");
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//instead of hard coding the timeouts I'll create a TestUtil class and call the values from there.
		//alternatively timeouts could have been placed in the config.properites file.
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//launches url specified in config.properties file
		driver.get(prop.getProperty("url"));
	}
}

	