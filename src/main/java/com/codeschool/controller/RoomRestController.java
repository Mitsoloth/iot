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

import com.codeschool.entities.Person;
import com.codeschool.entities.Room;
import com.codeschool.service.RoomService;

@RestController
public class RoomRestController 
{
	@Autowired
	RoomService roomService;
	
	@RequestMapping(value = "/api/getRoomById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDeviceById(@PathVariable("id") Integer id) {
        Room r = roomService.findRoomNameByID(id);
        if (r == null) 
        {
            return new ResponseEntity("Room not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Room>(r, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.PATCH, value = "/api/patchRoom")
	public ResponseEntity<?> patchRoom(@RequestBody Room room, UriComponentsBuilder ucBuilder) 
	{
		Room r = room;

		roomService.save(r);
	
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/api/getRoomById/{id}").buildAndExpand(r.getRoomID()).toUri());
	    return new ResponseEntity<String>(headers, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/addRoom")
	public ResponseEntity<?> addRoom(@RequestBody Room room, UriComponentsBuilder ucBuilder) 
	{
		Room r = room;
		
		roomService.save(r);
	
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/api/getRoomById/{id}").buildAndExpand(r.getRoomID()).toUri());
	    return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/viewAllRooms")
	public ResponseEntity<?> viewAllRooms() 
	{
		List<Room> dList = roomService.findAll();
		
        if (dList.size() == 0) {
            return new ResponseEntity("No registered rooms", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Room>>(dList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/deleteRoomById/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRoomById(@PathVariable("id") Integer id) 
    {
        Room r = roomService.findRoomNameByID(id);
        if (r == null) {
            return new ResponseEntity("False Room ID", HttpStatus.NOT_FOUND);
        }
        roomService.delete(r);
		return new ResponseEntity("Room with surname: " + r.getName() + " has been deleted.", HttpStatus.OK);
    }
	
}
