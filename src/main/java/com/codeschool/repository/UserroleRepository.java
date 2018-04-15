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
	Userrole findRoleIDByName(String name);
	Userrole findNameByRoleID(int id);
	List<Userrole> findAll();
}
