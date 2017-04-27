package com.epam.manager;

import com.epam.entity.Person;

import java.util.List;

public interface PersonManager {

	List<Person> getAll();

	Person getPerson(long id);

	Person update(Person person);

	Person add(Person person);

	void delete(long id);
}
