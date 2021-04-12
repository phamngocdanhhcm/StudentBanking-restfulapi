package com.giuaki.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {

	private String value;

	public HttpUtils(String value) {
		this.value = value;
	}
	
	public <T> T toModel(Class<T> tClass)
	{
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static HttpUtils of(BufferedReader reader) {
		StringBuffer json = new StringBuffer();
		StringBuilder sb = new StringBuilder();

		String line;
		try {
			while (((line = reader.readLine()) != null)) {
				sb.append(line);
				
			}
		} catch (IOException e) {
			
		}
		return new HttpUtils(sb.toString());

	}
}
