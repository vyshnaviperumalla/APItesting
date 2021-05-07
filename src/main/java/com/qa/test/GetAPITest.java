package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase{

	TestBase testbase;
	String serviceurl;
	  String apiurl;
	  String url ;
		RestClient restclient;
	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException {
		testbase=new TestBase();
		serviceurl = prop.getProperty("URL");
		  apiurl= prop.getProperty("/api/users");
		  //https://reqres.in/api/users
		  url = serviceurl + apiurl;
		  
		  
	}
	@Test
	public void getAPITest() throws ClientProtocolException, IOException {
	restclient = new RestClient();
		  restclient.get(url);
	}
}
