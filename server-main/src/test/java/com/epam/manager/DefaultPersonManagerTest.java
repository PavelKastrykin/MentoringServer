package com.epam.manager;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.dao.PersonDAO;
import com.epam.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DefaultPersonManagerTest {

	@InjectMocks private PersonManager test = new DefaultPersonManager();
	@Mock private PersonDAO dao;

	private Person testPerson;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		testPerson = new Person(1L, "Name", "LastName", 10, 100);
	}

	@Test
	public void testGetAll() {

		test.getAll();
		verify(dao).getAll();
	}

	@Test
	public void testGetPerson() {

		when(dao.getPerson(anyLong())).thenReturn(testPerson);

		Person person = test.getPerson(1L);

		assertEquals(1l, person.getId());
	}

	@Test
	public void testUpdate() {
		test.update(testPerson);
		verify(dao).update(testPerson);
	}

	@Test
	public void testAdd() {
		test.add(testPerson);
		verify(dao).add(testPerson);
	}

	@Test
	public void testDelete() {
		test.delete(testPerson.getId());
		verify(dao).delete(1L);
	}
}