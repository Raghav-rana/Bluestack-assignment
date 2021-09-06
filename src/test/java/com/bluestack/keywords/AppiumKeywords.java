package com.bluestack.keywords;

import com.bluestack.base.TestBaseAppium;

import io.appium.java_client.MobileElement;

public class AppiumKeywords extends TestBaseAppium{
	
	public static MobileElement getElement(String locator, String locatorType) throws Exception {
		if (locatorType.contains("accessibilityId")) {
			return appiumDriver.findElementByAccessibilityId(locator);
		}
		else if (locatorType.contains("id")) {
			return appiumDriver.findElementById(locator);
		}
		else if (locatorType.contains("xpath")) {
			return appiumDriver.findElementByXPath(locator);
		}
		else {
			throw new Exception("Locator type is incorrect");
		}
		
		
		
	}
	public static boolean getPresenceOfElement(String locator, String locatorType) throws Exception {
		return getElement(locator, locatorType).isDisplayed();
	}
	public static void clickOnElement(String locator, String locatorType) throws Exception {
		getElement(locator, locatorType).click();
	}
	public static void setText(String locator, String locatorType, String text) throws Exception {
		getElement(locator, locatorType).sendKeys(text);
	}
	
	public static String getText(String locator, String locatorType) throws Exception {
		return getElement(locator, locatorType).getText();
	}
}
