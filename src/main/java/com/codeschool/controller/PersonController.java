package com.codeschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codeschool.entities.Person;
import com.codeschool.service.PersonService;

@Controller
public class PersonController {
	@Autowired
	PersonService personService;	
	
	@RequestMapping(value = "/person/view", method = RequestMethod.GET)
	public ModelAndView viewPerson(@ModelAttribute("person") Person p) {
		return new ModelAndView("person/view", "person", p);
	}

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public ModelAndView newPerson() {
        return new ModelAndView("person/form", "person", new Person());
    }

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p, BindingResult result, ModelMap model) {
		if(!p.getEmail().contains("@")) {
			result.rejectValue("email", "invalid", "Person email value is invalid!");
		
		}

		if (result.hasErrors()) {
			return "error/person";
		}

        model.addAttribute("person", p);
        
        personService.save(p);
        
		return "person/view";
	}
}