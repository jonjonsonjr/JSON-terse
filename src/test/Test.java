package test;

import org.json.terse.JSONArray;
import org.json.terse.JSONObject;
import org.json.terse.parser.JSONParser;
import org.json.terse.parser.ParseException;

public class Test {

	String json = "{\"foo\":[10.2,1,{\"bar\":\"hello\"}]}";
	
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
	}
}
