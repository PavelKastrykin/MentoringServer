package com.epam.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import com.epam.entity.Person;
import com.epam.entity.Skill;
import com.epam.manager.PersonManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class SkillControllerTest {

	@InjectMocks private SkillController test;
	@Mock private PersonManager personManager;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddSkill() {
		ModelAndView model = test.addSkill(1L);

		assertEquals("addSkill", model.getViewName());
		assertEquals(1L, model.getModel().get("personID"));
		assertTrue(model.getModel().get("skill") instanceof Skill);
	}

	@Test
	public void testUpdateSkill() {
		long personID = 1L;
		Skill skill = new Skill("language", 1);
		Person person = new Person(1L, "name", "LastName", 10, 100);

		when(personManager.getPerson(personID)).thenReturn(person);

		ModelAndView model = test.updateSkills(skill, personID);

		assertEquals("viewPerson", model.getViewName());
		assertEquals(skill, person.getSkills().get(0));
		assertEquals(person, model.getModelMap().get("person"));
	}
}
