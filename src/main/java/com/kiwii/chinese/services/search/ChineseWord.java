package com.kiwii.chinese.services.search;

import java.util.ArrayList;
import java.util.List;

public class ChineseWord {

	private String id;
	private String traditional;
	private String simplified;
	private String pronouncation;
	private List<String> descriptions;
	
	public ChineseWord(){
		descriptions = new ArrayList<String>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTraditional() {
		return traditional;
	}
	public void setTraditional(String traditional) {
		this.traditional = traditional;
	}
	public String getSimplified() {
		return simplified;
	}
	public void setSimplified(String simplified) {
		this.simplified = simplified;
	}
	public String getPronouncation() {
		return pronouncation;
	}
	public void setPronouncation(String pronouncation) {
		this.pronouncation = pronouncation;
	}
	public List<String> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(traditional+" ");
		sb.append(simplified+" [");
		sb.append(pronouncation+"] ");
		for(String des: descriptions){
			sb.append("\\"+des);
		}
		sb.append("\\");
		return sb.toString();
	}
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof ChineseWord)) return false;
		if(obj==this) return true;
		return simplified.equals((String)obj);
	}
	@Override
	public int hashCode(){
		return simplified.hashCode();
	}
	
	
}
