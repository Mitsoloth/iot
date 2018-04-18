package com.codeschool.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_device")//,uniqueConstraints={@UniqueConstraint(columnNames={"personid", "deviceid"})})
public class DevicesPermissions{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int permissionID;
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "personid")	
	protected Person person;
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "deviceid")	
	protected Device device;
	
	public DevicesPermissions(int id, Person person, Device device) {
		super();
		this.permissionID = id;
		this.person = person;
		this.device = device;
	}
	
	public DevicesPermissions(){
		
	}
	
	public int getId() {
		return permissionID;
	}

	public void setId(int id) {
		this.permissionID = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

}
