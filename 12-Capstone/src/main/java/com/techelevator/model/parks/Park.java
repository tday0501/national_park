package com.techelevator.model.parks;

public class Park {

	private String name;

	private String code;

	private String description;

	private String state;

	private int acreage;

	private int elevationInFeet;

	private double milesOfTrail;

	private int numberOfCampsites;

	private String climate;

	private int yearFounded;

	private int annualVisitorCount;

	private String inspirationalQuote;

	private String quoteSource;

	private int entryFee;

	private int numberOfSpecies;

	public Park() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLowerCaseCode() {
		return code.toLowerCase();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String location) {
		this.state = location;
	}

	public int getAcreage() {
		return acreage;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}

	public int getElevationInFeet() {
		return elevationInFeet;
	}

	public void setElevationInFeet(int elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}

	public double getMilesOfTrail() {
		return milesOfTrail;
	}

	public void setMilesOfTrail(double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}

	public int getNumberOfCampsites() {
		return numberOfCampsites;
	}

	public void setNumberOfCampsites(int numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public int getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}

	public int getAnnualVisitorCount() {
		return annualVisitorCount;
	}

	public void setAnnualVisitorCount(int annaulVisitorCount) {
		this.annualVisitorCount = annaulVisitorCount;
	}

	public String getInspirationalQuote() {
		return inspirationalQuote;
	}

	public void setInspirationalQuote(String inspirationalQuote) {
		this.inspirationalQuote = inspirationalQuote;
	}

	public String getQuoteSource() {
		return quoteSource;
	}

	public void setQuoteSource(String quoteSource) {
		this.quoteSource = quoteSource;
	}

	public int getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}

	public int getNumberOfSpecies() {
		return numberOfSpecies;
	}

	public void setNumberOfSpecies(int numberOfSpecies) {
		this.numberOfSpecies = numberOfSpecies;
	}

}
