package com.codeschool.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="person")
public class Person {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int personID;
	private String pname;
	private String surname;
	private String email;
	private String ppassword;
	@ManyToOne
	@JoinColumn(name = "roleid")	
	protected Userrole role;
	

	public Person(String pname, String surname, String email, String ppassword, Userrole role) {
		super();
		this.pname = pname;
		this.surname = surname;
		this.email = email;
		this.ppassword = ppassword;
		this.role = role;
	}

	public Person(){
		
	}

	public int getId() {
		return personID;
	}

	public void setId(int id) {
		this.personID = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPpassword() {
		return ppassword;
	}

	public void setPpassword(String ppassword) {
		this.ppassword = ppassword;
	}

	public Userrole getRole() {
		return role;
	}

	public void setRole(Userrole role) {
		this.role = role;
	}

	@Override
	public String toString(){
		return "Person ("+personID+", "+pname+", "+surname+", "+email+", "+ppassword+", "+role+")";
	}
	
}