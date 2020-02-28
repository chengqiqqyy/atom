package app.entity.animal;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import app.entity.definition.Animal;

@Component
@Primary
public class Cat implements Animal{
	@Override
	public void use() {
		System.out.println("【" + Cat.class.getSimpleName() + "】 Cat is chasing the laser point.");
	}
}
