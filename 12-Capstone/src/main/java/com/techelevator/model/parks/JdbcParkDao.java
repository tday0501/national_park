package com.techelevator.model.parks;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDao implements ParksDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "select parkname, parkcode, parkdescription, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, entryfee, numberofanimalspecies from park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {

			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}

	private Park mapRowToPark(SqlRowSet row) {
		Park park = new Park();
		park.setCode(row.getString("parkcode"));
		park.setName(row.getString("parkname"));
		park.setState(row.getString("state"));
		park.setAcreage(row.getInt("acreage"));
		park.setElevationInFeet(row.getInt("elevationinfeet"));
		park.setMilesOfTrail(row.getDouble("milesoftrail"));
		park.setNumberOfCampsites(row.getInt("numberofcampsites"));
		park.setClimate(row.getString("climate"));
		park.setYearFounded(row.getInt("yearfounded"));
		park.setAnnualVisitorCount(row.getInt("annualvisitorcount"));
		park.setInspirationalQuote(row.getString("inspirationalquote"));
		park.setQuoteSource(row.getString("inspirationalquotesource"));
		park.setDescription(row.getString("parkdescription"));
		park.setEntryFee(row.getInt("entryfee"));
		park.setNumberOfSpecies(row.getInt("numberofanimalspecies"));
		return park;
	}

	

	@Override
	public Park getParkByCode(String code) {
		Park park = null;
		String sqlSelectParkByCode = "SELECT parkname, parkcode, parkdescription, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, entryfee, numberofanimalspecies FROM park WHERE parkCode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkByCode, code);
		if (results.next()) {
			park = mapRowToPark(results);
		}
		return park;
	}

}

	


