package com.mss.spring.batch.batchcomponents;

import org.springframework.batch.item.ItemProcessor;

import components.CompositeData;
import components.NewPerson;
import components.NewPerson2;
import components.Person;

public class BatchItemProcessor implements ItemProcessor<Person, CompositeData> {

	@Override
	public CompositeData process(Person person) throws Exception {
		NewPerson newPerson = null;
		NewPerson2 newPerson2 = null;
		if(person.isNewPerson())
			newPerson = new NewPerson(person.getName() + " " + person.getLastName());
		if(person.isNewPerson2())
			newPerson2 = new NewPerson2(person.getLastName() + " " + person.getName());
		CompositeData data = new CompositeData(newPerson, newPerson2);
		return data;
	}

}
