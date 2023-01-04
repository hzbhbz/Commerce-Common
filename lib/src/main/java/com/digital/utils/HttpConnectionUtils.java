package com.digital.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpConnectionUtils {
	
	/** HttpURLConnection GET 방식 */
	public static String getRequest(String targetUrl) {

		String response = "";

		try {

			URL url = new URL(targetUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET"); // 전송 방식
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setDoOutput(true);

			Charset charset = Charset.forName("UTF-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

			String inputLine;
			StringBuffer sb = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				sb.append(inputLine);
			}
			br.close();

			response = sb.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
	public static String getRequest(String targetUrl, String token) {

		String response = "";

		try {

			URL url = new URL(targetUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET"); // 전송 방식
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setRequestProperty("Authorization", token);
			conn.setDoOutput(true);

			Charset charset = Charset.forName("UTF-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

			String inputLine;
			StringBuffer sb = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				sb.append(inputLine);
			}
			br.close();

			response = sb.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	/** HttpURLConnection POST 방식 */
	public static String postRequest(String targetUrl, Object obj) {

		String response = "";

		try {

			URL url = new URL(targetUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST"); // 전송 방식
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setDoOutput(true);	// URL 연결을 출력용으로 사용(true)
			
			// 객체를 json으로 변환
			String requestBody = objectToJson(obj);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(requestBody);
			bw.flush();
			bw.close();

			Charset charset = Charset.forName("UTF-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			
			String inputLine;			
			StringBuffer sb = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				sb.append(inputLine);
			}
			br.close();
			
			response = sb.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
	public static String postRequest(String targetUrl, Object obj, String token) {

		String response = "";

		try {

			URL url = new URL(targetUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST"); // 전송 방식
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setRequestProperty("Authorization", token);
			conn.setDoOutput(true);	// URL 연결을 출력용으로 사용(true)
			
			// 객체를 json으로 변환
			String requestBody = objectToJson(obj);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(requestBody);
			bw.flush();
			bw.close();

			Charset charset = Charset.forName("UTF-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			
			String inputLine;			
			StringBuffer sb = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				sb.append(inputLine);
			}
			br.close();
			
			response = sb.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	/** Object -> Json(String) */
	public static String objectToJson(Object obj) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		String json = objectMapper.writeValueAsString(obj);
		
		return json;
	}
	
	/** Json(String) -> Object */
	public static Object jsonToObject(String respons, Class<?> c1) throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		Object obj = objectMapper.readValue(respons, c1);
		
		return obj;
	}

}