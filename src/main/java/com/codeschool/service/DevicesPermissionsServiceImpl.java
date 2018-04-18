package com.codeschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeschool.entities.Device;
import com.codeschool.entities.DevicesPermissions;
import com.codeschool.entities.Person;
import com.codeschool.repository.DevicesPermissionsRepository;

@Service
public class DevicesPermissionsServiceImpl implements DevicesPermissionsService {
	@Autowired
	private DevicesPermissionsRepository devicesPermissionsRep;
	
	@Override
	public DevicesPermissions findByPermissionID(Integer id) {
		return devicesPermissionsRep.findByPermissionID(id);
	}

	@Override
	public List<DevicesPermissions> findByPerson(Person person) {
		return devicesPermissionsRep.findByPerson(person);
	}

	@Override
	public DevicesPermissions save(DevicesPermissions dp) {
		return devicesPermissionsRep.save(dp);
	}

	@Override
	public void delete(DevicesPermissions dp) {
		// TODO Auto-generated method stub

	}

//	@Override
//	public List<Device> findByPersonQuery(Integer personid) {
//		// TODO Auto-generated method stub
//		return devicesPermissionsRep.findByPersonQuery(personid);
//	}

}
