package com.bluestack.base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import com.bluestack.utility.LoggingManager;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseSelenium {
	public static WebDriver driver;
	static Logger log = Logger.getLogger(TestBaseSelenium.class);
	public TestBaseSelenium() {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/properties/log4j.properties");
	}
	@BeforeSuite
	public void beforeSuite() {
		
		log.info("-----------------EXECUTION START----------------------");
	}
	
	@BeforeClass
	public void beforeClass() {
		LoggingManager.getInstance().createParentTestNode(getClass().getName());
		log
		.info(" : TesTBase - BeforeClass called " + "Thread-ID : " + Thread.currentThread().getId());
		
		
	}
	
	
	@BeforeMethod
	protected void BeforeMethod(Method method) throws MalformedURLException {
		log.info(" : TestBase - BeforeMethod called");
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--window-size=1580,1280");
		driver = new ChromeDriver(chromeOptions);
		driver.get(" https://weather.com/");
		LoggingManager.getInstance().createChildTestNode(method.getName());
		
	}
	
	@AfterMethod
	protected void AfterMethod(ITestResult result) {
		log.info(" : TestBase - AfterMethod called");
		log.info(" Test Method completed -> " + result.getName());
		driver.quit();
	}
	
	@AfterClass(alwaysRun = true)
	protected void AfterClass() {
		log.info(" : TestBase - AfterClass called");
		LoggingManager.getInstance().clearParentTestNode();
	}
	
	@AfterSuite
	protected void AfterSuite() {
		LoggingManager.getInstance().writeTestReport();
		log.info(" : TestBase - AfterSuite called");
	}
}
