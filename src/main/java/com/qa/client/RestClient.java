package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	public void get(String url) throws ClientProtocolException, IOException{
		
		//Get Method
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new  HttpGet(url);
		CloseableHttpResponse closeableHttpResponse =httpClient.execute(httpget);
		
		
		//Status code
		int  statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code----->"+statusCode);
		
		//Json String
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UFT-8");
		
		 JSONObject responseJson = new JSONObject(responseString);
		 System.out.println("Respose JSON from API--->"+responseJson);
		 
		 //All Headers
		 Header[] headerArray = closeableHttpResponse.getAllHeaders();
		 
		 HashMap<String, String> allHeaders = new HashMap<String, String>();
		 
		 for(Header header : headerArray){
			 allHeaders.put(header.getName(), header.getValue());
			 
		 }
		 System.out.println("All Headers-->"+allHeaders);
		
		
	}

}
