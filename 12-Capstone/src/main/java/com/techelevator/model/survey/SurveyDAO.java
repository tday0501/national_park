package com.techelevator.model.survey;

import java.util.List;

public interface SurveyDAO {

	public List<SurveyResponse> getSurveyResponses();
	public void save(Survey review);
}
