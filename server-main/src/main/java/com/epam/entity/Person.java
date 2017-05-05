package com.epam.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Comparable<Person> {

	private long id;
	private String name = "";
	private String lastName = "";
	private List<Skill> skills = new ArrayList<>();
	private int age;
	private int salary;

	public Person(){}

	public Person(long id, String name, String lastName, int age, int salary)
	{
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Person person = (Person) o;
		return id == person.id &&
				age == person.age &&
				salary == person.salary &&
				Objects.equals(name, person.name) &&
				Objects.equals(lastName, person.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, lastName, age, salary);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	public List<Skill> getSkills()
	{
		return skills;
	}

	public void setSkills(List<Skill> skills)
	{
		this.skills = skills;
	}
}
