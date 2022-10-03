package com.http.java;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

//This is the basic HTTP CLient that is shipped with the JRE
public class HttpURLConnectionExample {
	public static void main(String[] args) {
         try {
			httpGet();
        	 //httpPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void httpGet() throws IOException {
		String strUrl="http://httpbin.org/ip";
		URL url=new URL(strUrl);
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		
		//set the request type
		connection.setRequestMethod("GET");
		
		//add request header
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36");
		
		int responseCode = connection.getResponseCode();

		System.out.println("\nSending 'GET' request to URL : " + strUrl);
		System.out.println("Response Code : " + responseCode);

		//convert the byteStream from connection.getInputStream() to character stream using InputStreamReader
		InputStreamReader inputStreamReader=new InputStreamReader(connection.getInputStream());
		
		//1st way to read.
		//The read method will return the int value of the character or -1 when it reaches the end of the stream.
		
		/* int c=inputStreamReader.read();
		while(c!=-1) {			
			System.out.print((char)c);
			c=inputStreamReader.read();
		}
		*/
		
		//2nd way to read is using BufferedReader		
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}

	}
	
	public static void httpPost() throws Exception {

		// url is missing?
        //String url = "https://selfsolve.apple.com/wcResults.do";
        String url = "https://httpbin.org/post";

        HttpsURLConnection httpClient = (HttpsURLConnection) new URL(url).openConnection();

        //add reuqest header
        httpClient.setRequestMethod("POST");
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpClient.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        httpClient.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
        }

        int responseCode = httpClient.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            //print result
            System.out.println(response.toString());

        }

    }
}
