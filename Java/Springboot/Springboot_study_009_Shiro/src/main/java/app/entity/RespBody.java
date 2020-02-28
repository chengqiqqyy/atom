package app.entity;

import java.util.HashMap;
import java.util.Map;

public class RespBody extends HashMap<String, Object>{
	private static final long serialVersionUID = 1L;
	
	public RespBody() {
		put("code",0);
		put("msg","Done!");
	}
	
	public static RespBody error() {
		return error(1,"Operation failed.");
	}
	
	public static RespBody error(String msg) {
		return error(500, msg);
	}
	
	public static RespBody error(int code, String msg) {
		RespBody resb = new RespBody();
		resb.put("code", code);
		resb.put("msg", msg);
		return resb;
	}
	
	public static RespBody ok(String msg) {
		RespBody resb = new RespBody();
		resb.put("msg", msg);
		return resb;
	}
	
	public static RespBody ok(Map<String,Object> map) {
		RespBody resb = new RespBody();
		resb.putAll(map);
		return resb;
	}
	
	public static RespBody ok() {
		return new RespBody();
	}
	
	@Override
	public RespBody put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	
}
