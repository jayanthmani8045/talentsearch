package edu.neu.csye6200.models;

import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

public class Person {
	@Id
	protected String id;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	protected String username;
	protected String password;
	protected String type;
	protected long number;
	protected String emailId;
	
	// Constructor
	public Person(String username, String password, String type, long number, String emailId) {
		this.username = username;
		this.password = password;
		this.type = type;
		this.number = number;
		this.emailId = emailId;
	}


	//Setters and Getters
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public long getNumber() {
		return number;
	}


	public void setNumber(long number) {
		this.number = number;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	
}