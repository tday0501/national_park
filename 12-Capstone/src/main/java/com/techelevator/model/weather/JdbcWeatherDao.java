package com.techelevator.model.weather;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherDao implements  WeatherDAO{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> getWeather(String id) {
		List<Weather> allWeather = new ArrayList<Weather>();
		String sqlSelectWeather = "select parkcode, fivedayforecastvalue, low, high, forecast from weather where parkcode = ? order by fivedayforecastvalue";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeather, id);
		while (results.next()) {

			allWeather.add(mapRowToWeather(results));
		}
		return allWeather;
	}
	
	private Weather mapRowToWeather(SqlRowSet row) {
		Weather weather = new Weather();
		weather.setParkCode(row.getString("parkcode"));
		weather.setFiveDayForecastValue(row.getInt("fivedayforecastvalue"));
		weather.setLow(row.getInt("low"));
		weather.setHigh(row.getInt("high"));
		weather.setForecast(row.getString("forecast"));
		return weather;
	}
	
}
