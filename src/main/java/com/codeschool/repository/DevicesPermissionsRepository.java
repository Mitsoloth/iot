package com.codeschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codeschool.entities.Device;
import com.codeschool.entities.DevicesPermissions;

@Transactional
@Repository("devicesPermissionsRepository")
public interface DevicesPermissionsRepository extends JpaRepository<DevicesPermissions, Long> {
	//DevicesPermissions findDevicesPermissionsIdByName(String name);
	List<DevicesPermissions> findByPersonID(Integer personID);
	DevicesPermissions findById(Integer id);
}
