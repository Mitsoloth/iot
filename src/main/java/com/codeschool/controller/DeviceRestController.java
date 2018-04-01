package com.codeschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.codeschool.entities.Device;
import com.codeschool.service.DeviceService;

@RestController
public class DeviceRestController {
	
	@Autowired
	DeviceService deviceService;	
	
    @RequestMapping(value = "/getDeviceById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDeviceById(@PathVariable("id") Integer id) {
        //logger.info("Fetching User with id {}", id);
        Device d = deviceService.findById(id);
        if (d == null) {
        	System.out.println("gkouxou!");
            //logger.error("User with id {} not found.", id);
            return new ResponseEntity("Device with dat id not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Device>(d, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/addDevice")
	public ResponseEntity<?> addDevice(@RequestBody Device device, UriComponentsBuilder ucBuilder) {
		
		Device d = device;
		//Person deCheck = null;
		System.out.println(d);
		
		//personCheck = personService.findByEmail(p.getEmail());
		
		deviceService.save(d);
	
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/getDeviceById/{id}").buildAndExpand(d.getId()).toUri());
	    return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		
		
	}

}
