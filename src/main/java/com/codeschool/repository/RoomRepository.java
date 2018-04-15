package com.codeschool.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codeschool.entities.Room;

@Transactional
@Repository("roomRepository")
public interface RoomRepository extends JpaRepository<Room, Long> 
{
	Room findRoomIDByName(String name);
	Room findNameByRoomID(int id);
	List<Room> findAll();
}
