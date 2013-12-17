package com.kiwii.chinese.services.domain;

import java.util.Date;

public class Physical {
	private String time;
	private Date absoluteTime;
	private Figure[] figures;
	private Location[] locations;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getAbsoluteTime() {
		return absoluteTime;
	}
	public void setAbsoluteTime(Date absoluteTime) {
		this.absoluteTime = absoluteTime;
	}
	public Figure[] getFigures() {
		return figures;
	}
	public void setFigures(Figure[] figures) {
		this.figures = figures;
	}
	public Location[] getLocations() {
		return locations;
	}
	public void setLocations(Location[] locations) {
		this.locations = locations;
	}
	
	
}
