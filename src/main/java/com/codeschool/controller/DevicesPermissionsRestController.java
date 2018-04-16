package com.codeschool.controller;

import java.util.ArrayList;
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
import com.codeschool.entities.DevicesPermissions;
import com.codeschool.entities.Person;
import com.codeschool.entities.Room;
import com.codeschool.service.DeviceService;
import com.codeschool.service.DevicesPermissionsService;
import com.codeschool.service.PersonService;
import com.codeschool.service.RoomService;

@RestController
public class DevicesPermissionsRestController {
	
	@Autowired
	DevicesPermissionsService devicesPermissionsService;
	@Autowired
	PersonService personService;
	@Autowired
	DeviceService deviceService;

	
	@RequestMapping(value = "/api/getDevicesPermissionsByID/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDevicesPermissionsByID(@PathVariable("id") Integer id) {
		
		//Person p = personService.findById(id);
//		List<Device> dp = devicesPermissionsService.findByPersonQuery(id);
		//List<DevicesPermissions> dps = devicesPermissionsService.findByPerson(p);
		DevicesPermissions dp = devicesPermissionsService.findByPermissionID(id);
		
        if (dp == null) 
        {
            return new ResponseEntity("No permission found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(dp, HttpStatus.OK);
    }	
	
	@RequestMapping(value = "/api/getDevicesPermissionsByPersonID/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDevicesPermissionsByPersonID(@PathVariable("id") Integer id) {
		
		Person p = personService.findById(id);
//		List<Device> dp = devicesPermissionsService.findByPersonQuery(id);
		List<DevicesPermissions> dps = devicesPermissionsService.findByPerson(p);
		
		List<Device> dList = new ArrayList<Device>();
		
		//dps.forEach(dp->System.out.println(dp));
		
		dps.forEach(dp->{
//			System.out.println(dp.getDevice().getDname());
			dList.add(dp.getDevice());
			});
		
        if (dps == null) 
        {
            return new ResponseEntity("No permissions found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Device>>(dList, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/addDevicesPermissions")
	public ResponseEntity<?> addDevicesPermissions(@RequestBody DevicesPermissions devicespermissions, UriComponentsBuilder ucBuilder) 
	{
		
		DevicesPermissions dp = devicespermissions;
		
		Device d1 = deviceService.findById(dp.getDevice().getId());
		
		Person p1 = personService.findById(dp.getPerson().getId());
		
		dp.setDevice(d1);
		dp.setPerson(p1);
		
		devicesPermissionsService.save(dp);
	
		//HttpHeaders headers = new HttpHeaders();
	    //headers.setLocation(ucBuilder.path("/getDevicesPermissionsById/{id}").buildAndExpand(dp.getId()).toUri());
	    return new ResponseEntity<String>(HttpStatus.CREATED);	
	}
	


}
