package com.codeschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IotController {
	 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("hellomsg", "Hello World from our Controller class CodingSchool");
        return "welcome";
    }

    @RequestMapping(value = "/introduction", method = RequestMethod.GET)
    public String introduceYourself(ModelMap model) {
    	model.addAttribute("hellomsg", "Hello World from our Controller class. My name is Mmmmmmitsos");
        return "welcome";
    }
}