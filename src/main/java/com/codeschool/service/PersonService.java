package com.codeschool.service;

import java.util.List;

import com.codeschool.entities.Person;

public interface PersonService {
    //List<Person> findBypname(String pname);
    Person findByEmail(String email);
    Person findById(Integer id);
    Person save(Person p);
	void delete(Long id);
	void delete(Person p);
}
