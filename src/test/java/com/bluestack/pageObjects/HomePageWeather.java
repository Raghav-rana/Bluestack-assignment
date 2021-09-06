package com.bluestack.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bluestack.base.TestBaseSelenium;
import com.bluestack.keywords.SeleniumKeywords;

public class HomePageWeather extends TestBaseSelenium{
	private static String searchBox = "[id=\"LocationSearch_input\"]";
	private static String firstSuggestion = "[id=\"LocationSearch_listbox\"]>button:nth-child(1)";
	private static String currentTemp = ".CurrentConditions--primary--2SVPh [data-testid=\"TemperatureValue\"]";
	
	public static void setCityName(String city) throws InterruptedException {
		Thread.sleep(6000);
		SeleniumKeywords.setText(searchBox, city);
	}
	public static void clickOnFirstSuggestion() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(firstSuggestion)));
		SeleniumKeywords.click(firstSuggestion);
	}
	public static String getCurrentTemp() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(currentTemp)));
		return SeleniumKeywords.getText(currentTemp);
	}
}
