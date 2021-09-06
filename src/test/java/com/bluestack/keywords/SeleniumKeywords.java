package com.bluestack.keywords;

import org.openqa.selenium.By;

import com.bluestack.base.TestBaseSelenium;

public class SeleniumKeywords extends TestBaseSelenium {
	public static void click(String css) {
		driver.findElement(By.cssSelector(css)).click();;
	}
	
	public static void setText(String css, String text) {
		driver.findElement(By.cssSelector(css)).sendKeys(text);
	}
	
	public static String getText(String css) {
		return driver.findElement(By.cssSelector(css)).getText();
	}
	
}
