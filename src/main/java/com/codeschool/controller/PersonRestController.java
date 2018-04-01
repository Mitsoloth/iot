package com.codeschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.codeschool.entities.Person;
import com.codeschool.service.PersonService;

@RestController
public class PersonRestController {
	@Autowired
	PersonService personService;	
	
	@RequestMapping("/getPersonByMail")
	public Person getPerson(@RequestParam(value = "email", defaultValue = "a@a") String email) {
		Person p = personService.findByEmail(email);
		System.out.println(p);
		return p;
	}
	
    @RequestMapping(value = "/getPersonById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPersonById(@PathVariable("id") Integer id) {
        //logger.info("Fetching User with id {}", id);
        Person p = personService.findById(id);
        if (p == null) {
        	System.out.println("gkouxou!");
            //logger.error("User with id {} not found.", id);
            return new ResponseEntity("Person with dat id not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Person>(p, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/addPerson")
	public ResponseEntity<?> addPerson(@RequestBody Person person, UriComponentsBuilder ucBuilder) {
		
		Person p = person;
		Person personCheck = null;
		System.out.println(p);
		
		personCheck = personService.findByEmail(p.getEmail());
		
		if (personCheck == null){	
			personService.save(p);
	
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/getPersonById/{id}").buildAndExpand(p.getId()).toUri());
	        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		
	}
	
	
}