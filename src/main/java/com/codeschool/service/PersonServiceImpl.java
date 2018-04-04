package com.codeschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeschool.entities.Person;
import com.codeschool.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonRepository personRep;

	@Override
	public Person findByEmail(String email) {
		return personRep.findByEmail(email);
	}
	@Override
	public Person findById(int id) {
		return personRep.findById(id);
	}
	@Override
	public void delete(Long id) {
		personRep.deleteById(id);
	}
	@Override
	public Person save(Person p) {
		return personRep.save(p);
	}
	@Override
	public void delete(Person p) {
		personRep.delete(p);
	}
	@Override
	public List<Person> findAll() {		
		return personRep.findAll();
	}
	@Override
	public List<Person> findAllAdmins() {
		return personRep.findAllPersonsByRole(1);
	}
	@Override
	public List<Person> findAllUsers() {
		return personRep.findAllPersonsByRole(2);
	}
}