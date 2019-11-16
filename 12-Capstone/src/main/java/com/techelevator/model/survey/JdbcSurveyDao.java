package com.techelevator.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDAO {


	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<SurveyResponse> getSurveyResponses() {
		List<SurveyResponse> allSurveys = new ArrayList<SurveyResponse>();
		String sqlSurvey = "select park.parkname, count(*) as count, survey_result.parkcode from survey_result "
				+ "join park on park.parkcode = survey_result.parkcode "
				+ "where survey_result.parkcode is not null "
				+ "group by park.parkcode, survey_result.parkcode "
				+ "order by count DESC, park.parkname;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSurvey);
		while (results.next()) {
			allSurveys.add(mapRowToSurveyResponses(results));
		}
		return allSurveys;
	}
	
	private SurveyResponse mapRowToSurveyResponses(SqlRowSet row) {
		SurveyResponse response= new SurveyResponse();
		response.setParkCode(row.getString("parkcode"));
		response.setSurveyCount(row.getInt("count"));
		response.setParkName(row.getString("parkname"));
		return response;
	}
	
	@Override
	public void save(Survey review) {
		String sqlInsertReview = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";
		jdbcTemplate.update(sqlInsertReview,review.getFavoriteParkCode(), review.getEmail(), review.getStateOfResidence(), review.getActivity());
	}


}
