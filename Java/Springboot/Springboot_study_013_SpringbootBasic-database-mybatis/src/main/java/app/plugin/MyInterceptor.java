package app.plugin;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.beans.factory.annotation.Autowired;

@Intercepts({ @Signature(type=StatementHandler.class, method="prepare", args= {Connection.class, Integer.class}) })
public class MyInterceptor implements Interceptor{
	@Autowired
	Properties props = null;
	
	// n拦截逻辑方法
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("My Interceptor runs.............");
		System.out.println("【invocation.getArgs】 --- " + invocation.getArgs().length);
		System.out.println("【ClassName】 " + invocation.getArgs()[0].getClass().getSimpleName());
		System.out.println("【ToString】 " + invocation.getArgs()[0].toString());
		return invocation.proceed();
	}
	
	// n生成mybatis拦截对象
	@Override
	public Object plugin(Object target) {
		System.out.println("生成Mybatis拦截对象： " + target.getClass().getSimpleName());
		return Plugin.wrap(target, this);
	}
	
	// n设置插件属性
	@Override
	public void setProperties(Properties properties) {
		this.props = properties;
		System.out.println(properties.getProperty("key1") + " " + properties.getProperty("key2") + " " + properties.getProperty("key3"));
	}
}
