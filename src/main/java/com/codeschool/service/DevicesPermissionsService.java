package com.codeschool.service;

import java.util.List;

import com.codeschool.entities.Device;
import com.codeschool.entities.DevicesPermissions;
import com.codeschool.entities.Person;

public interface DevicesPermissionsService {
	DevicesPermissions findByPermissionID(Integer id);
	List<DevicesPermissions> findByPerson(Person person);
//	List<Device> findByPersonQuery(Integer personid);
	DevicesPermissions save(DevicesPermissions dp);
	void delete(DevicesPermissions dp);
}
