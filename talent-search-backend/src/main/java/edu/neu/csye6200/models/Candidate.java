package edu.neu.csye6200.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Candidates")
public class Candidate extends Person {
	String candidateFirstName;
	String candidateLastName;
	String candidateLocation;
	int candidateAge;
	int candidateId;
	double candidateScore;
	String candidateFeedBack;
	int getCandidateId;
	String resumeLocation;
	
	//Constructor
	public Candidate(String username, String password, String type, long number, String emailId,
			String candidateFirstName, String candidateLastName, String candidateLocation, int candidateAge,
			int candidateId, double candidateScore, String candidateFeedBack, int getCandidateId,String resumeLocation) {
		super(username, password, type, number, emailId);
		this.candidateFirstName = candidateFirstName;
		this.candidateLastName = candidateLastName;
		this.candidateLocation = candidateLocation;
		this.candidateAge = candidateAge;
		this.candidateId = candidateId;
		this.candidateScore = candidateScore;
		this.candidateFeedBack = candidateFeedBack;
		this.getCandidateId = getCandidateId;
		this.resumeLocation = resumeLocation;
	}

	
	public int getCandidateId() {
		return candidateId;
	}


	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}


	public int getGetCandidateId() {
		return getCandidateId;
	}


	public void setGetCandidateId(int getCandidateId) {
		this.getCandidateId = getCandidateId;
	}


	public String getResumeLocation() {
		return resumeLocation;
	}


	public void setResumeLocation(String resumeLocation) {
		this.resumeLocation = resumeLocation;
	}


	public void setCandidateFirstName(String candidateFirstName) {
		this.candidateFirstName = candidateFirstName;
	}


	public void setCandidateLastName(String candidateLastName) {
		this.candidateLastName = candidateLastName;
	}


	public void setCandidateLocation(String candidateLocation) {
		this.candidateLocation = candidateLocation;
	}


	public void setCandidateAge(int candidateAge) {
		this.candidateAge = candidateAge;
	}

	//Setters and Getters
	public String getCandidateFirstName() {
		return candidateFirstName;
	}


	public String getCandidateLastName() {
		return candidateLastName;
	}


	public String getCandidateLocation() {
		return candidateLocation;
	}


	public int getCandidateAge() {
		return candidateAge;
	}


	public double getCandidateScore() {
		return candidateScore;
	}


	public String getCandidateFeedBack() {
		return candidateFeedBack;
	}	
	
	public void setCandidateFeedBack(String candidateFeedBack) {
		this.candidateFeedBack = candidateFeedBack;
	}


	public void setCandidateScore(double candidateScore) {
		this.candidateScore = candidateScore;
	}


	@Override
	public String toString() {
		return "Candidate [candidateFirstName=" + candidateFirstName + ", candidateLastName=" + candidateLastName
				+ ", candidateLocation=" + candidateLocation + ", candidateAge=" + candidateAge + ", candidateId="
				+ candidateId + ", candidateScore=" + candidateScore + ", candidateFeedBack=" + candidateFeedBack
				+ ", getCandidateId=" + getCandidateId + ", resumeLocation=" + resumeLocation + ", username=" + username
				+ ", password=" + password + ", type=" + type + ", number=" + number + ", emailId=" + emailId + "]";
	}
	
	
}