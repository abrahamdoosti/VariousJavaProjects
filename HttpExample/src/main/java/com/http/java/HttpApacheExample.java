package com.http.java;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpApacheExample {
	
	// one instance, reuse
    private final static CloseableHttpClient httpClient = HttpClients.createDefault();
    
	public static void main(String[] args) throws IOException {
        try {
        	System.out.println("Testing 1 - Send Http GET request");
        	httpGetLoadTest();

            //System.out.println("Testing 2 - Send Http POST request");
            //httpPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
            close();
        }
	}
	
	private static void close() throws IOException {
        httpClient.close();
    }
	
	public static void httpGet() throws IOException {
		String strUrl="http://www.example.com";
		// Here there is no need to set requestType as the HttpGet is specific to GET.
		HttpGet connection=new HttpGet(strUrl);
		
		//add request header
		connection.addHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36");
		
		try (CloseableHttpResponse response = httpClient.execute(connection)) {

			// Get HttpResponse Status
			System.out.println(response.getStatusLine().toString());

			HttpEntity entity = response.getEntity();
			Header headers = entity.getContentType();
			System.out.println(headers);

			if (entity != null) {
				// return it as a String
				String result = EntityUtils.toString(entity);
				System.out.println(result);
			}

		}


	}
	
	public static void httpPost() throws Exception {

        HttpPost post = new HttpPost("https://httpbin.org/post");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("username", "abc"));
        urlParameters.add(new BasicNameValuePair("password", "123"));
        urlParameters.add(new BasicNameValuePair("custom", "secret"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        }

    }
	
	public static void httpGetLoadTest() throws Exception {
		//String command = "curl -X POST https://postman-echo.com/post --data foo1=bar1&foo2=bar2";
		//Process process = Runtime.getRuntime().exec(command);
		
		String strUrl="https://helloworld-y4u35xotha-uc.a.run.app/";
		// Here there is no need to set requestType as the HttpGet is specific to GET.
		HttpGet connection=new HttpGet(strUrl);
		
		//add request header
		connection.addHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36");
		for (int i=0;i<1000;i++) {
			try (CloseableHttpResponse response = httpClient.execute(connection)) {

				// Get HttpResponse Status
				System.out.println(response.getStatusLine().toString());

				HttpEntity entity = response.getEntity();
				Header headers = entity.getContentType();
				System.out.println(headers);

				if (entity != null) {
					// return it as a String
					String result = EntityUtils.toString(entity);
					System.out.println(result);
				}

			}
		}

	}
}
