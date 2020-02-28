package app.entity.animal;

import org.springframework.stereotype.Component;

import app.entity.definition.Animal;

@Component
public class Horse implements Animal{
	@Override
	public void use() {
		System.out.println("【" + Horse.class.getSimpleName() + "】 Horse is chasing the carrot.");
	}
	
}
