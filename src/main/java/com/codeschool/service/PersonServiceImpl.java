package com.codeschool.service;

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
	public Person findById(Integer id) {
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
}