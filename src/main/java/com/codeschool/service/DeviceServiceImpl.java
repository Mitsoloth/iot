package com.codeschool.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeschool.entities.Device;
import com.codeschool.repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	private DeviceRepository deviceRep;
	
	@Override
	public Device findById(Integer id) {
		return deviceRep.findById(id);
	}
	@Override
	public void delete(Long id) {
		deviceRep.deleteById(id);
	}
	@Override
	public Device save(Device d) {
		return deviceRep.save(d);
	}
	@Override
	public void delete(Device d) {
		deviceRep.delete(d);
	}
}
