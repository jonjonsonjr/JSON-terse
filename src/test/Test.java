package test;

import org.json.terse.JSONArray;
import org.json.terse.JSONObject;
import org.json.terse.parser.JSONParser;
import org.json.terse.parser.ParseException;

public class Test {

	String json = "{\"foo\":[10.2,1,{\"bar\":\"hello\"}]}";
	String twitter = 
		"["
		+ "{"
			+ "\"coordinates\": null,"
			+ "\"favorited\": false,"
			+ "\"truncated\": false,"
			+ "\"created_at\": \"Mon Sep 03 13:24:14 +0000 2012\","
			+ "\"id_str\": \"242613977966850048\","
			+ "\"entities\": {"
				+ "\"urls\": [],"
				+ "\"hashtags\": [],"
				+ "\"user_mentions\": ["
					+ "{"
						+ "\"name\": \"Jason Costa\","
						+ "\"id_str\": \"14927800\","
						+ "\"id\": 14927800,"
						+ "\"indices\": [0,11],"
						+ "\"screen_name\": \"jasoncosta\""
					+ "}"
				+ "]"
			+ "}"
		+ "}" +
		"]";
	
	public static void main(String[] args) {
		try {
			new Test().test();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void test() throws ParseException {
		JSONParser parser = new JSONParser();
		
		JSONObject obj = (JSONObject) parser.parse(json);
		
		System.out.println(obj.arr("foo").obj(2).str("bar"));
		System.out.println(obj.arr("foo").num(0));
		System.out.println(obj.arr("foo").dub(0));
		System.out.println(obj.arr("foo").num(1));
		System.out.println(obj.arr("foo").dub(1));
		
		
		JSONArray t = (JSONArray) parser.parse(twitter);
		
		long a = t.obj(0).obj("entities").arr("user_mentions").obj(0).arr("indices").num(0);
		
		System.out.println(a);
		
		long b = (Long) ((JSONArray) ((JSONObject) ((JSONArray) ((JSONObject) ((JSONObject) t.get(0)).get("entities")).get("user_mentions")).get(0)).get("indices")).get(0);
		
		System.out.println(b);
	}
}
