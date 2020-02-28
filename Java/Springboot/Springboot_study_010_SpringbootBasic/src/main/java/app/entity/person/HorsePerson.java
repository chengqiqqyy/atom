package app.entity.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import app.entity.definition.Animal;
import app.entity.definition.Person;

@Component
public class HorsePerson implements Person{
	
	private Animal animal;
	
	public HorsePerson(@Autowired @Qualifier("horse") Animal animal) {
		this.animal = animal;
	}


	@Override
	public void service() {
		this.animal.use();
	}
	
	@Override
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}
