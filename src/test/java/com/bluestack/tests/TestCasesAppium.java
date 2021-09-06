package com.bluestack.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bluestack.base.TestBaseAppium;
import com.bluestack.pageObjects.HomePageGameTv;

public class TestCasesAppium extends TestBaseAppium {
	@Test
	public void testCase()
			throws Exception {
		SoftAssert assertion = new SoftAssert();
		assertion.assertTrue(HomePageGameTv.getPresenceOfTwitterButton(), "twitter login button not found");
		HomePageGameTv.clickOnTwitterButton();
		HomePageGameTv.setEmail("sxyz@gmail.com");
		HomePageGameTv.setPassword("*****");
		HomePageGameTv.clickOnLoginButton();
		assertion.assertTrue(HomePageGameTv.getPresenceOfEnterYourNameField(), "Enter you name field is not present");
	    assertion.assertAll();

	}
}
