package com.bluestack.base;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.bluestack.utility.LoggingManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.lang.reflect.Method;



public class TestBaseAppium {
	public static AppiumDriver<MobileElement> appiumDriver;
	static Logger log = Logger.getLogger(TestBaseAppium.class);
	public TestBaseAppium() {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/properties/log4j.properties");
	}
	@BeforeSuite
	public void beforeSuite() throws MalformedURLException {
		log.info("-----------------EXECUTION START----------------------");
	}

	@BeforeClass
	public void beforeClass() {
		log
		.info(" : TesTBase - BeforeClass called " + "Thread-ID : " + Thread.currentThread().getId());
		LoggingManager.getInstance().createParentTestNode(getClass().getName());

	}

	@BeforeMethod
	protected void BeforeMethod(Method method) throws MalformedURLException {
		log.info(" : TestBase - BeforeMethod called");
		LoggingManager.getInstance().createChildTestNode(method.getName());
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Galaxy M11");
		cap.setCapability("udid", "R9ZN80V7R5V");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "tv.game");
		cap.setCapability("appActivity", "tv.game.MainActivity");
		cap.setCapability("uiautomator2ServerLaunchTimeout", 90000);
		appiumDriver = new AppiumDriver<MobileElement>(cap);

	}

	@AfterMethod
	protected void AfterMethod(ITestResult result) {
		log.info(" : TestBase - AfterMethod called");
		log.info(" Test Method completed -> " + result.getName());
	
	}

	@AfterClass(alwaysRun = true)
	protected void AfterClass() {
		log.info(" : TestBase - AfterClass called");
		LoggingManager.getInstance().clearParentTestNode();
		appiumDriver.quit();
		
	}

	@AfterSuite
	protected void AfterSuite() {
		log.info(" : TestBase - AfterSuite called");
		LoggingManager.getInstance().writeTestReport();
	}
}
