package com.codeschool.repository;

import java.util.List;

import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codeschool.entities.Device;
import com.codeschool.entities.DevicesPermissions;
import com.codeschool.entities.Person;

@Transactional
@Repository("devicesPermissionsRepository")
public interface DevicesPermissionsRepository extends JpaRepository<DevicesPermissions, Long> {
	//DevicesPermissions findDevicesPermissionsIdByName(String name);

//	@Query(nativeQuery = true, value = "SELECT d FROM Device as d LEFT JOIN d.deviceID as ud WHERE ud.personID = 1")	
//	List<Device> findByPersonQuery(Integer personid);
	List<DevicesPermissions> findByPerson(Person person);
	DevicesPermissions findByPermissionID(Integer id);
}
