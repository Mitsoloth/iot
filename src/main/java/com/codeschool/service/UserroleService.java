package com.codeschool.service;

import java.util.List;

import com.codeschool.entities.Userrole;;

public interface UserroleService 
{
	Userrole findRoleidByName(String name);
	Userrole findNameByRoleid(int id);
	Userrole save(Userrole r);
	void delete(Long id);
	void delete(Userrole r);
	List<Userrole> findAll();
}