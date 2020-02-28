package app.entity;

import java.util.HashMap;

public class RespBody extends HashMap<String, Object>{
	private static final long serialVersionUID = 1L;
	
	@Override
	public RespBody put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	
	public RespBody() {
		put("code",0);
		put("msg","Opreation done.");
	}
	
	public static RespBody ok() {
		RespBody responseBody = new RespBody();
		return responseBody;
	}
	
	public static RespBody error(String msg) {
		RespBody responseBody = new RespBody();
		responseBody.put("msg", msg);
		return responseBody;
	}
}
