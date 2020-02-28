package app.service.impl;

import app.service.HelloService;

public class HelloServiceImpl implements HelloService{

	@Override
	public void sayHello(String name) {
		if(name == null || name.trim() == "") throw new RuntimeException("Parameter is null.");
		System.out.println(name + " is saying something.");
	}
	
}
