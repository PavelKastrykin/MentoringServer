package com.epam.dao;

import com.epam.entity.Person;
import com.epam.exception.DaoException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Repository
public class DefaultPersonDAO implements PersonDAO {

	@Override
	public List<Person> getAll() {
		List<Person> personList = new ArrayList<>(PersonRepository.getRepository().values());
		Collections.sort(personList);
		return personList;
	}

	@Override
	public Person getPerson(long id) {
		return PersonRepository.getRepository().get(id);
	}

	@Override
	public Person update(Person person) {
		if (PersonRepository.getRepository().containsKey(person.getId())) {
			return PersonRepository.getRepository().put(person.getId(), person);
		}
		else {
			throw new DaoException("Person id: " + person.getId() + " doesn't exist");
		}
	}

	@Override
	public Person add(Person person) {
		if (PersonRepository.getRepository().containsKey(person.getId()) || person.getId() != 0) {
			throw new DaoException("Person with such ID already exists.");
		}

		Random random = new Random();
		long newID = random.nextLong();
		person.setId(newID);
		PersonRepository.getRepository().put(newID, person);
		return person;
	}

	@Override
	public void delete(long id) {
		PersonRepository.getRepository().remove(id);
	}
}
