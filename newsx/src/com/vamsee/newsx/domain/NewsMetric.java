package com.vamsee.newsx.domain;

import java.io.Serializable;

public class NewsMetric implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8690812842607325411L;

	private String newsType;
	
	private Long count;

	public String getNewsType() {
		return newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	
	
	
	
	
	
	
}
