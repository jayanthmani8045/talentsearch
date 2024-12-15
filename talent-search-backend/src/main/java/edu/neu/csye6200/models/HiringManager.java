package edu.neu.csye6200.models;

import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="HiringManagers")
public class HiringManager extends Person {

	private String managerId;
	
	private String jobDescription;
	private String jobTitle;
	private String jobLocation;

	
	//Constructor
	public HiringManager(String username, String password, String type, long number, String emailId,
			String jobDescription, String jobTitle, String jobLocation) {
		super(username, password, type, number, emailId);
		this.jobDescription = jobDescription;
		this.jobTitle = jobTitle;
		this.jobLocation = jobLocation;
	}
	
	//Setters and Getters
	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	@Override
	public String toString() {
		return "HiringManager [managerId=" + managerId + ", jobDescription=" + jobDescription + ", jobTitle=" + jobTitle
				+ ", jobLocation=" + jobLocation + ", " + ", username=" + username + ", password=" + password
				+ ", type=" + type + ", number=" + number + ", emailId=" + emailId + "]";
	}
	
	
	
}