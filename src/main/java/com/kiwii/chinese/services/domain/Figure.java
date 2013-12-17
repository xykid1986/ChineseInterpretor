package com.kiwii.chinese.services.domain;

import java.util.HashMap;
import java.util.Map;

public class Figure {
	
	private String name;
	private final Map<String, String> properties;
	
	public Figure(){
		properties = new HashMap<String,String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getProperties() {
		return properties;
	}
	
	
}
