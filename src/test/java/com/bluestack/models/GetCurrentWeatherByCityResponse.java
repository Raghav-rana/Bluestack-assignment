package com.bluestack.models;

import java.util.List;

public class GetCurrentWeatherByCityResponse {
	private Coord coord;
	private List<Weather> weather = null;
	private String base;
	private Main main;
	private Integer visibility;
	private Wind wind;
	private Clouds clouds;
	private Integer dt;
	private Sys sys;
	private Integer timezone;
	private Integer id;
	private String name;
	private Integer cod;

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Integer getVisibility() {
		return visibility;
	}

	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Integer getDt() {
		return dt;
	}

	public void setDt(Integer dt) {
		this.dt = dt;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public Integer getTimezone() {
		return timezone;
	}

	public void setTimezone(Integer timezone) {
		this.timezone = timezone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public static class Coord {

		private Double lon;
		private Double lat;

		public Double getLon() {
			return lon;
		}

		public void setLon(Double lon) {
			this.lon = lon;
		}

		public Double getLat() {
			return lat;
		}

		public void setLat(Double lat) {
			this.lat = lat;
		}

	}

	public static class Weather {

		private Integer id;
		private String main;
		private String description;
		private String icon;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getMain() {
			return main;
		}

		public void setMain(String main) {
			this.main = main;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

	}

	public static class Main {

		private Double temp;
		private Double feelsLike;
		private Double tempMin;
		private Double tempMax;
		private Integer pressure;
		private Integer humidity;
		private Integer seaLevel;
		private Integer grndLevel;

		public Double getTemp() {
			return temp;
		}

		public void setTemp(Double temp) {
			this.temp = temp;
		}

		public Double getFeelsLike() {
			return feelsLike;
		}

		public void setFeelsLike(Double feelsLike) {
			this.feelsLike = feelsLike;
		}

		public Double getTempMin() {
			return tempMin;
		}

		public void setTempMin(Double tempMin) {
			this.tempMin = tempMin;
		}

		public Double getTempMax() {
			return tempMax;
		}

		public void setTempMax(Double tempMax) {
			this.tempMax = tempMax;
		}

		public Integer getPressure() {
			return pressure;
		}

		public void setPressure(Integer pressure) {
			this.pressure = pressure;
		}

		public Integer getHumidity() {
			return humidity;
		}

		public void setHumidity(Integer humidity) {
			this.humidity = humidity;
		}

		public Integer getSeaLevel() {
			return seaLevel;
		}

		public void setSeaLevel(Integer seaLevel) {
			this.seaLevel = seaLevel;
		}

		public Integer getGrndLevel() {
			return grndLevel;
		}

		public void setGrndLevel(Integer grndLevel) {
			this.grndLevel = grndLevel;
		}

	}

	public static class Wind {

		private Double speed;
		private Integer deg;
		private Double gust;

		public Double getSpeed() {
			return speed;
		}

		public void setSpeed(Double speed) {
			this.speed = speed;
		}

		public Integer getDeg() {
			return deg;
		}

		public void setDeg(Integer deg) {
			this.deg = deg;
		}

		public Double getGust() {
			return gust;
		}

		public void setGust(Double gust) {
			this.gust = gust;
		}

	}

	public static class Clouds {

		private Integer all;

		public Integer getAll() {
			return all;
		}

		public void setAll(Integer all) {
			this.all = all;
		}

	}

	public static class Sys {

		private String country;
		private Integer sunrise;
		private Integer sunset;

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public Integer getSunrise() {
			return sunrise;
		}

		public void setSunrise(Integer sunrise) {
			this.sunrise = sunrise;
		}

		public Integer getSunset() {
			return sunset;
		}

		public void setSunset(Integer sunset) {
			this.sunset = sunset;
		}

	}
}
