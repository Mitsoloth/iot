package com.codeschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.codeschool.entities.Device;
import com.codeschool.service.DeviceService;

@RestController
public class DevicesRestController {
	
	@Autowired
	DeviceService deviceService;	

	@RequestMapping(method = RequestMethod.POST, value = "/api/addDevice")
	public ResponseEntity<?> addDevice(@RequestBody Device device, UriComponentsBuilder ucBuilder) 
	{
		Device d = device;
		
		deviceService.save(d);
	
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/api/getDeviceById/{id}").buildAndExpand(d.getId()).toUri());
	    return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method = RequestMethod.PATCH, value = "/api/changeStatus")
	public ResponseEntity<?> changeStatus(@RequestBody Device device, UriComponentsBuilder ucBuilder) 
	{
		Device d = device;
		
		Device originalDevice = deviceService.findById(d.getId());
		
		originalDevice.setDstatus(d.getDstatus());
		
		deviceService.save(originalDevice);
	
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/api/getDeviceById/{id}").buildAndExpand(d.getId()).toUri());
	    return new ResponseEntity<String>(headers, HttpStatus.OK);
		
	}
	
}
