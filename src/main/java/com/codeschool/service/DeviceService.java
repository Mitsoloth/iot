package com.codeschool.service;

import java.util.List;

import com.codeschool.entities.Device;

public interface DeviceService {
	//List<Device> findByDname(String dname);
	//Device findByEmail(String email);
	Device findById(Integer id);
	void delete(Long id);
	Device save(Device d);
	void delete(Device d);
}
