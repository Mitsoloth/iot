package com.codeschool.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.springframework.beans.factory.annotation.Autowired;

//import com.codeschool.service.RoomService;

@Entity
@Table(name="device")
public class Device {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deviceID;
	private String dname;
	private String dtype;
	@ManyToOne
	@JoinColumn(name = "roomid")
	protected Room room;
	private int dstatus;
	
	public Device(int id, String dname, String dtype, Room room, int dstatus) {
		super();
		this.deviceID = id;
		this.dname = dname;
		this.dtype = dtype;
		this.room =  room;
		this.dstatus = dstatus;
	}
	
	public Device(){
		
	}

	public int getId() {
		return deviceID;
	}

	public void setId(int id) {
		this.deviceID = id;
	}
	
	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getDstatus() {
		return dstatus;
	}

	public void setDstatus(int dstatus) {
		this.dstatus = dstatus;
	}

}
