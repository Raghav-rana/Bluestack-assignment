package com.restAssured.requests;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import com.bluestack.models.GetCurrentWeatherByCityResponse;

public class Requests {
	private static String key = "7285cb7e7847c25173c5b0dc928b4a00";
	private static String baseUrl = "http://api.openweathermap.org";

	public static GetCurrentWeatherByCityResponse getCurrentWeatherByCity(String city) {
		String endpoint = baseUrl + "/data/2.5/weather";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Connection", "keep-alive");
		headers.put("User-Agent", "Rest-Assured");
		headers.put("Host", "api.openweathermap.org");
		Map<String, String> params = new HashMap<String, String>();
		params.put("q", city);
		params.put("appid", key);
		
		GetCurrentWeatherByCityResponse response = 
				given()
				.headers(headers)
				.params(params)
				.when().get(endpoint).andReturn()
				.then()
				.statusCode(200).extract().as(GetCurrentWeatherByCityResponse.class);
		return response;

	}
}
