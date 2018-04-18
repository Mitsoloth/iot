package com.codeschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeschool.entities.Person;
import com.codeschool.repository.PersonRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonRepository personRep;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Person findByEmail(String email) {
		return personRep.findByEmail(email);
	}
	@Override
	public Person findById(int id) {
		return personRep.findByPersonID(id);
	}
	@Override
	public void delete(Long id) {
		personRep.deleteById(id);
	}
	@Override
	public Person save(Person p) {
		if(p.getPpassword().length()>6) {			
			if(!p.getPpassword().substring(0, 7).equals("$2a$10$"))
				p.setPpassword(bCryptPasswordEncoder.encode(p.getPpassword()));
		}
		else p.setPpassword(bCryptPasswordEncoder.encode(p.getPpassword()));
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