package com.techelevator.model.survey;

import com.techelevator.model.parks.Park;

public class SurveyResponse {

	private String parkName;
	private int surveyCount;
	private String parkCode;
	
	public SurveyResponse() {
		
	}

	public int getSurveyCount() {
		return surveyCount;
	}

	public void setSurveyCount(int surveyCount) {
		this.surveyCount = surveyCount;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode.toLowerCase();
	}
	
}
