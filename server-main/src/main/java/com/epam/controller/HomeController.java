package com.epam.controller;

import com.epam.manager.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private PersonManager personManager;

	@GetMapping(value = "/")
	public String index() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.addObject("persons", personManager.getAll());
		model.setViewName("home");
		return model;
	}

	public PersonManager getPersonManager()	{
		return personManager;
	}

	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}
}
