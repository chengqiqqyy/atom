package app.intercept;

import app.intercept.impl.MyInterceptor;
import app.proxy.ProxyBean;
import app.service.HelloService;
import app.service.impl.HelloServiceImpl;

public class TestAOP {
	public static void main(String[] args) {
		/*
		 * AOP 约定编程
		 * 	将服务织入约定的流程中
		 */
		HelloService helloService = new HelloServiceImpl();
//		ProxyBean pb = new ProxyBean();
//		pb.what(helloService);
//		pb.msg();
		
		HelloService proxy = (HelloService)ProxyBean.getProxyBean(helloService, new MyInterceptor());
		proxy.sayHello("Anna");
		System.out.println("\nThe name is null.\n");
		proxy.sayHello(null);
		
		
	}
	
	
}
