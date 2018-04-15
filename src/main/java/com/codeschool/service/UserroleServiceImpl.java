package com.codeschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeschool.entities.Userrole;
import com.codeschool.repository.UserroleRepository;

@Service
public class UserroleServiceImpl implements UserroleService {

	@Autowired
	private UserroleRepository userroleRep;
	@Override
	public Userrole findRoleIDByName(String name) {
		return userroleRep.findRoleIDByName(name);
	}

	@Override
	public Userrole findNameByRoleID(int id) {
		return userroleRep.findNameByRoleID(id);
	}

	@Override
	public Userrole save(Userrole r) {
		return userroleRep.save(r);
	}

	@Override
	public void delete(Long id) {
		userroleRep.deleteById(id);
	}

	@Override
	public void delete(Userrole r) {
		userroleRep.delete(r);

	}

	@Override
	public List<Userrole> findAll() {
		return userroleRep.findAll();
	}

}
