package com.epam.controller;

import com.epam.entity.Person;
import com.epam.entity.Skill;
import com.epam.manager.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private PersonManager personManager;

	@GetMapping("/add/{id}")
	public ModelAndView addSkill(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		model.addObject("personID", id);
		model.addObject("skill", new Skill());
		model.setViewName("addSkill");

		return model;
	}

	@PostMapping("/update/{personID}")
	public ModelAndView updateSkills(@ModelAttribute Skill skill, @PathVariable long personID) {
		Person person = personManager.getPerson(personID);
		person.getSkills().add(skill);

		ModelAndView model = new ModelAndView();
		model.addObject("person", person);
		model.setViewName("viewPerson");

		return model;
	}

	public PersonManager getPersonManager()
	{
		return personManager;
	}

	public void setPersonManager(PersonManager personManager)
	{
		this.personManager = personManager;
	}
}
