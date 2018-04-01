package com.codeschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeschool.entities.DevicesPermissions;
import com.codeschool.repository.DevicesPermissionsRepository;

@Service
public class DevicesPermissionsServiceImpl implements DevicesPermissionsService {
	@Autowired
	private DevicesPermissionsRepository devicesPermissionsRep;
	
	@Override
	public DevicesPermissions findById(Integer id) {
		return devicesPermissionsRep.findById(id);
	}

	@Override
	public List<DevicesPermissions> findByPersonID(Integer personID) {
		return devicesPermissionsRep.findByPersonID(personID);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public DevicesPermissions save(DevicesPermissions dp) {
		return devicesPermissionsRep.save(dp);
	}

	@Override
	public void delete(DevicesPermissions dp) {
		// TODO Auto-generated method stub

	}

}
