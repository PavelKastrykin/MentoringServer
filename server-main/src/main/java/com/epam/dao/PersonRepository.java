package com.epam.dao;

import com.epam.entity.Person;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class PersonRepository {

	private static Map<Long, Person> persons = new ConcurrentHashMap<>();

	static {
		persons.put(1L, new Person(1, "John", "Snow", "Java", 2, 30));
		persons.put(2L, new Person(2, "Bruce", "Dickinson", "HTML", 3, 50));
		persons.put(3L, new Person(3, "Freddie", "Mercury", "C++", 4, 60));
	}

	public static Map<Long, Person> getRepository() {
		return persons;
	}
}
