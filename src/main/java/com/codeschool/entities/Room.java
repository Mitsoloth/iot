package com.codeschool.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roomID;
	private String name;
	
	public Room(int id, String name) {
		super();
		this.roomID = id;
		this.name = name;
	}

	public Room(){
		
	}
	public int getRoomID() {
		return roomID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setRoomID(int roomid) {
		this.roomID = roomid;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
