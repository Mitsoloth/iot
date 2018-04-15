package com.codeschool.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Userrole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleID;
	private String name;
	
	//@OneToMany(mappedBy = "role")
	//private List<Person> persons;
	
	/**
	 * @return the roleid
	 */
	public int getRoleID() {
		return roleID;
	}
	/**
	 * @param roleid the roleid to set
	 */
	public void setRoleid(int roleid) {
		this.roleID = roleid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
