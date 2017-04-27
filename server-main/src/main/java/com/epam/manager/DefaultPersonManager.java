package com.epam.manager;

import com.epam.dao.PersonDAO;
import com.epam.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPersonManager implements PersonManager {

	@Autowired
	private PersonDAO personDAO;

	@Override
	public List<Person> getAll() {
		return personDAO.getAll();
	}

	@Override
	public Person getPerson(long id) {
		return personDAO.getPerson(id);
	}

	@Override
	public Person update(Person person) {
		return personDAO.update(person);
	}

	@Override
	public Person add(Person person) {
		return personDAO.add(person);
	}

	@Override
	public void delete(long id) {
		personDAO.delete(id);
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
}
