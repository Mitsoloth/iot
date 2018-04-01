package com.codeschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeschool.entities.Room;
import com.codeschool.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRep;
	@Override
	public Room findRoomIdByName(String name) {
		return roomRep.findRoomIdByName(name);
	}

	@Override
	public Room findRoomNameByID(int id) {
		return roomRep.findRoomNameById(id);
	}

	@Override
	public Room save(Room r) {
		return roomRep.save(r);
	}

	@Override
	public void delete(Long id) {
		roomRep.deleteById(id);
	}

	@Override
	public void delete(Room r) {
		roomRep.delete(r);

	}

}
