package app.entity.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import app.entity.definition.Animal;
import app.entity.definition.Person;

@Component
public class DogPerson implements Person{
	@Autowired
	@Qualifier("dog")
	Animal animal;
	
	@Override
	public void service() {
		this.animal.use();
	}

	@Override
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
