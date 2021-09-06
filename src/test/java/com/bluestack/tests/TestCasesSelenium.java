package com.bluestack.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bluestack.base.TestBaseSelenium;
import com.bluestack.dataProviders.DataProviders;
import com.bluestack.pageObjects.HomePageWeather;
import com.restAssured.requests.Requests;

public class TestCasesSelenium extends TestBaseSelenium {
	private boolean comparatorWithLimit(double number1, double number2, int limit) {
		double temp1 = 100 - limit;
		temp1 = temp1 / 100;
		double temp2 = 100 + limit;
		temp2 = temp2 / 100;

		double lowerLimit = number1 * temp1;
		double upperLimit = number1 * temp2;

		if (number2 >= lowerLimit && number2 <= upperLimit) {
			return true;
		}

		lowerLimit = number2 * temp1;
		upperLimit = number2 * temp2;
		if (number1 >= lowerLimit && number1 <= upperLimit) {
			return true;
		}
		return false;
	}

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testCase(String variance, String city) throws InterruptedException, FileNotFoundException, IOException, ParseException {
		
		
		HomePageWeather.setCityName(city);
		HomePageWeather.clickOnFirstSuggestion();
		Double currentTempInDegreeUI = Double.parseDouble(HomePageWeather.getCurrentTemp().replace("°", ""));
		Double currentTempInKelvinUI = currentTempInDegreeUI + 273;
		Double currentTempInKelvinAPI = Requests.getCurrentWeatherByCity(city).getMain().getTemp();
		SoftAssert assertion = new SoftAssert();
		assertion.assertTrue(comparatorWithLimit(currentTempInKelvinUI, currentTempInKelvinAPI, Integer.parseInt(variance)));
		assertion.assertAll();
		
	}
}
