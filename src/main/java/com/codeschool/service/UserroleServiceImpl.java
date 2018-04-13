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
	public Userrole findRoleidByName(String name) {
		return userroleRep.findRoleidByName(name);
	}

	@Override
	public Userrole findNameByRoleid(int id) {
		return userroleRep.findNameByRoleid(id);
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
