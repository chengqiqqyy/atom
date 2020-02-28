package app.entity.animal;

import org.springframework.stereotype.Component;

import app.entity.definition.Animal;

@Component
public class Dog implements Animal{
	@Override
	public void use() {
		System.out.println("【" + Dog.class.getSimpleName() + "】" + " Dog is chasing the ball.");
	}
}
