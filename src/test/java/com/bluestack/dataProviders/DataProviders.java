package com.bluestack.dataProviders;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "testData")
	public static String[][] dataProvider() throws FileNotFoundException, IOException, ParseException {
		Object obj = new JSONParser().parse(new FileReader(System.getProperty("user.dir")+"/testData/testData.json"));
		JSONObject jo = (JSONObject) obj;
		String variance =  ((Long)jo.get("variance")).toString();
		JSONArray ja = (JSONArray) jo.get("city");
		
		List<String[]> dataArr = new ArrayList<String[]>();
		List<String> temp = new ArrayList<String>();
		
	    for(int i = 0; i<ja.size(); i++) {
	    	temp.add(variance);
	    	temp.add(ja.get(i).toString());
	    	dataArr.add(temp.toArray(new String[0]));
	    	temp = new ArrayList<String>();
	    }
	    return dataArr.toArray(new String[0][0]);
		
	}
}
