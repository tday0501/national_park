package com.techelevator.model.survey;

import java.lang.reflect.Array;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.techelevator.model.parks.Park;

public class Survey {

	@NotBlank(message = " Please enter your favorite park. ")
 	private String favoriteParkCode;
	
	@NotBlank @Email(message = "Please enter a valid email. ")
	private String email;
	
	@NotBlank @Length(min=2,max=2, message="Please enter valid state abbreviation")
	private String stateOfResidence;
	
	@NotEmpty
	private String activity;
	
	private String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

	private String[] options = {"Inactive", "Sedentary", "Active", "Extremely Active"};

	
	@AssertTrue(message="Please select a valid state")
	public boolean isStateReal() {
		boolean result = false;
		for(String state : states) {
			if (stateOfResidence.equals(state)){
				result = true;
			}
		}
		return result;
	}
	
	@AssertTrue(message="Please select a valid option")
	public boolean isValidOption() {
		boolean result = false;
		for(String option : options) {
			if (activity.equals(option)){
				result = true;
			}
		}
		return result;
	}
	
	public Survey() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStateOfResidence() {
		return stateOfResidence;
	}

	public void setStateOfResidence(String stateOfResidence) {
		this.stateOfResidence = stateOfResidence;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getFavoriteParkCode() {
		return favoriteParkCode;
	}

	public void setFavoriteParkCode(String favoriteParkCode) {
		this.favoriteParkCode = favoriteParkCode;
	}

	public String[] getStates() {
		return states;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}
	
}
