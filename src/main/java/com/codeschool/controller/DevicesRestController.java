package com.codeschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.codeschool.entities.Device;
import com.codeschool.entities.Person;
import com.codeschool.entities.Room;
import com.codeschool.service.DeviceService;

@RestController
public class DevicesRestController {
	
	@Autowired
	DeviceService deviceService;	
	
    @RequestMapping(value = "/api/getDeviceById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDeviceById(@PathVariable("id") Integer id) 
    {
        //logger.info("Fetching User with id {}", id);
        Device d = deviceService.findById(id);
        if (d == null) {
        	System.out.println("gkouxou!");
            //logger.error("User with id {} not found.", id);
            return new ResponseEntity("Device with dat id not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Device>(d, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/viewAllDevices")
	public ResponseEntity<?> viewAllDevices() 
	{
		List<Device> dList = deviceService.findAll();
		
        if (dList.size() == 0) {
            return new ResponseEntity("No registered Devices", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Device>>(dList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/addDevice")
	public ResponseEntity<?> addDevice(@RequestBody Device device, UriComponentsBuilder ucBuilder) 
	{
		Device d = device;
		
		deviceService.save(d);
	
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/api/getDeviceById/{id}").buildAndExpand(d.getId()).toUri());
	    return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method = RequestMethod.PATCH, value = "/api/patchDevice")
	public ResponseEntity<?> patchPerson(@RequestBody Device device, UriComponentsBuilder ucBuilder) 
	{
		Device d = device;
		
		Device originalDevice = deviceService.findById(d.getId());
		
		originalDevice.setDname(d.getDname());
		originalDevice.setDstatus(0);
		originalDevice.setDtype(d.getDtype());
		originalDevice.setRoom(d.getRoom());
		
		deviceService.save(originalDevice);
	
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/api/getDeviceById/{id}").buildAndExpand(d.getId()).toUri());
	    return new ResponseEntity<String>(headers, HttpStatus.OK);
		
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
	
	@RequestMapping(value = "/api/deleteDeviceById/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeviceById(@PathVariable("id") Integer id) 
    {
        Device d = deviceService.findById(id);
        if (d == null) {
            return new ResponseEntity("False Device ID", HttpStatus.NOT_FOUND);
        }
        deviceService.delete(d);
		return new ResponseEntity("Device with name: " + d.getDname() + " has been deleted.", HttpStatus.OK);
    }
	
}
