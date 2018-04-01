package com.codeschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codeschool.entities.Person;

@Transactional
@Repository("personRepository")
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findBypname(String pname);
    Person findByEmail(String email);
    Person findById(Integer id);
    //List<Person> findAll();
}