package com.kiwii.chinese.services.search;

import java.util.List;

public class Hits<T> {
	
	
	private List<T> hits;
	private double max_score;
	private int total;

	public List<T> getHits() {
		return hits;
	}

	public void setHits(List<T> hits) {
		this.hits = hits;
	}

	public double getMax_score() {
		return max_score;
	}

	public void setMax_score(double max_score) {
		this.max_score = max_score;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
}
