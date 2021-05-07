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

	//1.GET method
	
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet httpget = new HttpGet();//http get request
		CloseableHttpResponse closablehttpresponse = httpclient.execute(httpget);//hit the get url
		
		//a.status code
		
		int statuscode = closablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("statuscode------>"+statuscode);
		
		//b.json string
		
		String responsestring = EntityUtils.toString(closablehttpresponse.getEntity(),"UTF-8");
		JSONObject jsonobject = new JSONObject(responsestring);
		System.out.println("responsejson from api----->"+jsonobject);
		
		//all headers
		
		Header [] headerarray = closablehttpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();
		for(Header header:headerarray) {
			allheaders.put(header.getName(),header.getValue());
			System.out.println("Headers array ----->"+allheaders);
			
		}
	}
	
}
