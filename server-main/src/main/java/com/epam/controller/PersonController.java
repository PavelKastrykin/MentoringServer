package com.epam.controller;

import com.epam.entity.Person;
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
@RequestMapping("/person")
public class PersonController
{

	@Autowired
	private PersonManager personManager;

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable long id) {

		ModelAndView model = new ModelAndView();
		Person person = personManager.getPerson(id);
		model.addObject("person", person);
		model.setViewName("viewPerson");

		return model;
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		personManager.delete(id);
		return "redirect:/home";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Person person) {

		personManager.update(person);

		return "redirect:/home";
	}

	@PostMapping("/new")
	public ModelAndView addNew() {
		ModelAndView model = new ModelAndView();
		model.addObject("person", new Person());
		model.setViewName("addNew");

		return model;
	}

	@PostMapping("/save")
	public ModelAndView saveNew(@ModelAttribute Person person) {
		ModelAndView model = new ModelAndView();
		person = personManager.add(person);
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
