package com.mss.spring.batch.batchcomponents;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import components.Person;
import components.PersonGenerator;

public class BatchItemReader implements ItemReader<Person> {

	private List<Person> personList = new PersonGenerator().generatePerson();

	private int count = 0;

	@Override
	public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (count < personList.size())
			return personList.get(count++);
		else
			count = 0;
		return null;
	}
}
