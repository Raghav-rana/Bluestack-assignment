package com.bluestack.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bluestack.base.TestBaseAppium;
import com.bluestack.keywords.AppiumKeywords;

import io.appium.java_client.MobileBy;

public class HomePageGameTv extends TestBaseAppium {
	private static String twitterButtonAccessabiltyId = "AuthoriseWithTwitter_593";
	private static String twitterEmailTextboxXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[1]/android.widget.EditText";
	private static String twitterPasswordTextboxXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[2]/android.widget.EditText";
	private static String loginButtonXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View[2]/android.widget.Button[1]";
	private static String titleAfterLoginXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText";

	public static boolean getPresenceOfTwitterButton() throws Exception {
		WebDriverWait wait = new WebDriverWait(appiumDriver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(twitterButtonAccessabiltyId)));
		return AppiumKeywords.getPresenceOfElement(twitterButtonAccessabiltyId, "accessibilityId");
	}
	public static void clickOnTwitterButton() throws Exception {
		AppiumKeywords.clickOnElement(twitterButtonAccessabiltyId, "accessibilityId");
		
	}
	public static void setEmail(String email) throws Exception {
		WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(twitterEmailTextboxXpath)));
		AppiumKeywords.setText(twitterEmailTextboxXpath, "xpath", email);
	}
	
	public static void setPassword(String password) throws Exception {
		AppiumKeywords.setText(twitterPasswordTextboxXpath, "xpath", password);
	}
	
	public static void clickOnLoginButton() throws Exception {
		AppiumKeywords.clickOnElement(loginButtonXpath, "xpath");
	}
	
	public static boolean getPresenceOfEnterYourNameField() throws Exception {
	    WebDriverWait wait = new WebDriverWait(appiumDriver, 20);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(titleAfterLoginXpath)));
		return AppiumKeywords.getPresenceOfElement(titleAfterLoginXpath, "xpath");
	}
}
