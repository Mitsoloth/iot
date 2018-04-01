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

import com.codeschool.entities.DevicesPermissions;
import com.codeschool.entities.Room;
import com.codeschool.service.DevicesPermissionsService;
import com.codeschool.service.RoomService;

@RestController
public class DevicesPermissionsRestController {
	
	@Autowired
	DevicesPermissionsService devicesPermissionsService;
	
	@RequestMapping(value = "/getDevicesPermissionsByPersonID/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDevicesPermissionsByPersonID(@PathVariable("id") Integer id) {
        List<DevicesPermissions> dp = devicesPermissionsService.findByPersonID(id);
        if (dp == null) 
        {
            return new ResponseEntity("No permissions found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<DevicesPermissions>>(dp, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/addDevicesPermissions")
	public ResponseEntity<?> addDevicesPermissions(@RequestBody DevicesPermissions devicespermissions, UriComponentsBuilder ucBuilder) 
	{
		
		DevicesPermissions dp = devicespermissions;
		
		devicesPermissionsService.save(dp);
	
		//HttpHeaders headers = new HttpHeaders();
	    //headers.setLocation(ucBuilder.path("/getDevicesPermissionsById/{id}").buildAndExpand(dp.getId()).toUri());
	    return new ResponseEntity<String>(HttpStatus.CREATED);
		
		
	}

}
