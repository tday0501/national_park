package com.techelevator.model.weather;

public class Weather {

	private String parkCode;
	private int fiveDayForecastValue;
	private double low;
	private double high;
	private String forecast;
	private String imageResult;
	
	public double getLow() {
		return low;
	}
	
	public void setLow(int low) {
		this.low = low;
	}
	
	public double getHigh() {
		return high;
	}
	
	public void setHigh(int high) {
		this.high = high;
	}
	
	public String getForecast() {
		return forecast;
	}
	
	public String getRecommendation() {
		String recommendation ="";
		if (forecast.equals("snow")) {
			recommendation ="Pack Snowshoes!";
		}
		else if(forecast.equals("rain")) {
			recommendation="Pack raingear and wear waterproof shoes!";
		}
		else if (forecast.equals("thunderstorms")) {
			recommendation="Seek shelter and avoid hiking on exposed ridges!";
		}
		else if (forecast.equals("sunny")) {
			recommendation="Pack sunblock!";
		}
		else if (high > 75) {
			recommendation="Bring an extra gallon of water!";
		}
		else if (high - low > 20) {
			recommendation="Wear breathable laters";
		}
		else if(low < 20){
			recommendation="WARNING freezing temperatures! Do not be exposed for long periods of time";
		}
		else{
			recommendation="Have a wonderful day!";
		}
		return recommendation;
	}
	
	public String getImageExt() {
		if(forecast.contains(" ")) {
			String[] weather = forecast.split(" ");
			String imageResult = "";
			for(int i = 0; i <weather.length; i++) {
				if(i == 0) {
					imageResult += weather[i];
				} else {
					imageResult += weather[i].substring(0,1).toUpperCase() + weather[1].substring(1);
				}
			}
			return imageResult;
		}
		return forecast;
	}
	
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}

	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}

	public double getTempConvert(int temp) {
		return (int)((temp-32)*(0.5556));
	}
	
}
