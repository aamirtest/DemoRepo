package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPItest extends TestBase {
	TestBase testbase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	
	
	
	@BeforeMethod
	public void setUP() throws ClientProtocolException, IOException{
		 testbase = new TestBase();
		 serviceUrl = prop.getProperty("URL");
		 apiUrl = prop.getProperty("serviceURL");
		 url= serviceUrl+apiUrl;
		 
		 RestClient restClient = new RestClient();
		 restClient.get(url);
	}
	@Test
	public void getTest() throws ClientProtocolException, IOException{
		
		 System.out.println("git testing");
		
		restClient = new RestClient();
		 restClient.get(url);
		
		
	}

}
