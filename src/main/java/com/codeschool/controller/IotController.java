package com.codeschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.codeschool.service.PersonService;

@Controller
public class IotController {
    @Autowired
    private PersonService userService;
	 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        
    	String name="ANONYMOUS";
    	//Get the name of the logged-in user to pass it to a view. If there is no logged in user
    	//the name will be "ANONYMOUS"
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails instanceof UserDetails) {
            name = ((UserDetails)userDetails).getUsername();
        }
    	model.addAttribute("hellomsg", "Hello World from our Controller class. My name is "+name);
    	return "welcome";
    	
    	
    	
//    	model.addAttribute("hellomsg", "Hello World from our Controller class CodingSchool");
//        return "welcome";
    }

    @RequestMapping(value = "/introduction", method = RequestMethod.GET)
    public String introduceYourself(ModelMap model) {
    	model.addAttribute("hellomsg", "Hello World from our Controller class. My name is Mmmmmmitsos");
        return "welcome";
    }
}