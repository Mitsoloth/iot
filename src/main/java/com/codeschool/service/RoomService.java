package com.codeschool.service;

import com.codeschool.entities.Room;

public interface RoomService 
{
	Room findRoomIdByName(String name);
	Room findRoomNameByID(int id);
	Room save(Room r);
	void delete(Long id);
	void delete(Room r);
}
