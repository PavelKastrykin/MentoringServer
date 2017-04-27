package com.epam.entity;

import java.util.Objects;

public class Person implements Comparable<Person> {

	private long id;
	private String name = "";
	private String lastName = "";
	private String skill;
	private int level;
	private int age;

	public Person(){}

	public Person(long id, String name, String lastName, String skill, int level, int age)
	{
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.skill = skill;
		this.level = level;
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Person person = (Person) o;
		return id == person.id &&
				level == person.level &&
				age == person.age &&
				Objects.equals(name, person.name) &&
				Objects.equals(lastName, person.lastName) &&
				Objects.equals(skill, person.skill);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, lastName, skill, level, age);
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", skill='" + skill + '\'' +
				", level=" + level +
				", age=" + age +
				'}';
	}

	@Override
	public int compareTo(Person o) {

		int result = this.getLastName().compareTo(o.getLastName());
		if (result == 0) {
			result = this.getName().compareTo(o.getName());
		}

		return result;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


}
