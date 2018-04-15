package com.codeschool.service;

import java.util.List;

import com.codeschool.entities.Userrole;;

public interface UserroleService 
{
	Userrole findRoleIDByName(String name);
	Userrole findNameByRoleID(int id);
	Userrole save(Userrole r);
	void delete(Long id);
	void delete(Userrole r);
	List<Userrole> findAll();
}