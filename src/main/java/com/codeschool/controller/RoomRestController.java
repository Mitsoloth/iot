package com.codeschool.controller;

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
import com.codeschool.entities.Room;
import com.codeschool.service.RoomService;

@RestController
public class RoomRestController 
{
	@Autowired
	RoomService roomService;
	
	@RequestMapping(value = "/getRoomById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDeviceById(@PathVariable("id") Integer id) {
        Room r = roomService.findRoomNameByID(id);
        if (r == null) 
        {
            return new ResponseEntity("Room not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Room>(r, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/addRoom")
	public ResponseEntity<?> addRoom(@RequestBody Room room, UriComponentsBuilder ucBuilder) 
	{
		
		Room r = room;
		
		roomService.save(r);
	
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/getRoomById/{id}").buildAndExpand(r.getId()).toUri());
	    return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		
		
	}

}
