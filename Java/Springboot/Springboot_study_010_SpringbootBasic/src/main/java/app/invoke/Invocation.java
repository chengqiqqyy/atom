package app.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lombok.Data;

@Data
public class Invocation {
	private Object[] params;
	private Method method;
	private Object target;
	
	public Invocation(Object[] params, Method method, Object target) {
		this.params = params;
		this.method = method;
		this.target = target;
	}
	
	// n反射方法
	public Object proceed() throws InvocationTargetException, IllegalAccessException{
		return method.invoke(target, params);
	}
}
