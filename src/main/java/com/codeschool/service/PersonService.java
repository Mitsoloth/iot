package com.codeschool.service;

import java.util.List;

import com.codeschool.entities.Person;

public interface PersonService 
{
    Person findByEmail(String email);
    Person findById(int id);
    Person save(Person p);
	void delete(Long id);
	void delete(Person p);
	List<Person> findAll();
	List<Person> findAllAdmins();
	List<Person> findAllUsers();
}
