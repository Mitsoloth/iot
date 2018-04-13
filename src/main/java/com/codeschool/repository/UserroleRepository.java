package com.codeschool.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codeschool.entities.Userrole;

@Transactional
@Repository("userroleRepository")
public interface UserroleRepository extends JpaRepository<Userrole, Long> 
{
	Userrole findRoleidByName(String name);
	Userrole findNameByRoleid(int id);
	List<Userrole> findAll();
}
