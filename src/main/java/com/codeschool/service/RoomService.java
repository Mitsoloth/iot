package com.codeschool.service;

import java.util.List;

import com.codeschool.entities.Room;

public interface RoomService 
{
	Room findRoomIdByName(String name);
	Room findRoomNameByID(int id);
	Room save(Room r);
	void delete(Long id);
	void delete(Room r);
	List<Room> findAll();
}
