package com.codeschool.service;

import java.util.List;

import com.codeschool.entities.DevicesPermissions;

public interface DevicesPermissionsService {
	DevicesPermissions findById(Integer id);
	List<DevicesPermissions> findByPersonID(Integer id);
	void delete(Long id);
	DevicesPermissions save(DevicesPermissions dp);
	void delete(DevicesPermissions dp);
}
