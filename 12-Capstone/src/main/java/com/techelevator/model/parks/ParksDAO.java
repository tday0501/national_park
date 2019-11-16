package com.techelevator.model.parks;

import java.util.List;

public interface ParksDAO {

	public List<Park> getAllParks(); 
	public Park getParkByCode(String code);
	
}
