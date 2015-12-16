package org.ihansen.jsmta.utils;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil
{
	private JsonUtil()
	{}

	public static String toJson(Object object,String datePattern)
	{
		Gson gson = new GsonBuilder().setDateFormat(datePattern).create(); 
		String jsonStr = gson.toJson(object);
		return jsonStr;
	}
	public static String toJson(Object object)
	{
		Gson gson = new Gson();
		String jsonStr = gson.toJson(object);
		return jsonStr;
	}
	
	/**
	 * json字符串转成对象
	 * 
	 * @param str
	 * @param type
	 * @return
	 */
	public static <T> T json2Bean(String str, Type type,String datePattern)
	{
		Gson gson = new GsonBuilder().setDateFormat(datePattern).create();
		return gson.fromJson(str, type); 
	}

	/**
	 * json字符串转成对象
	 * 
	 * @param str
	 * @param type
	 * @return
	 */
	public static <T> T json2Bean(String str, Class<T> type,String datePattern)
	{
		Gson gson = new GsonBuilder().setDateFormat(datePattern).create();
		return gson.fromJson(str, type);
	}
	
	public static <T> T json2Bean(String str, Class<T> type)
	{
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(str, type);
	}
	
}
