package com.epam.dao;

import com.epam.entity.Person;
import com.epam.entity.Skill;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class PersonRepository {

	private static Map<Long, Person> persons = new ConcurrentHashMap<>();

	static {
		persons.put(1L, new Person(1, "John", "Snow", 30, 1000));
		persons.put(2L, new Person(2, "Bruce", "Dickinson", 40, 2000));
		persons.put(3L, new Person(3, "Freddie", "Mercury", 50, 3000));

		persons.get(1L).getSkills().add(new Skill("Java", 2));
		persons.get(1L).getSkills().add(new Skill("Html", 2));

		persons.get(2L).getSkills().add(new Skill("C++", 3));
		persons.get(2L).getSkills().add(new Skill("Javascript", 2));
		persons.get(2L).getSkills().add(new Skill("C#", 1));

		persons.get(3L).getSkills().add(new Skill("Javascript", 4));
		persons.get(3L).getSkills().add(new Skill("Angular", 5));
		persons.get(3L).getSkills().add(new Skill("SQL", 3));
		persons.get(3L).getSkills().add(new Skill("Html", 4));
	}

	public static Map<Long, Person> getRepository() {
		return persons;
	}
}
