package com.vamsee.newsx.domain;

import java.io.Serializable;

public class News implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 3375189919979009484L;


	private Long news_id;
	
	
	private String headlines;
	
	private String mainstory;
	
	private String imageurl;
	
	private String videourl;
	
	private String newstype;

	public Long getNews_id() {
		return news_id;
	}

	public void setNews_id(Long news_id) {
		this.news_id = news_id;
	}

	public String getHeadlines() {
		return headlines;
	}

	public void setHeadlines(String headlines) {
		this.headlines = headlines;
	}

	public String getMainstory() {
		return mainstory;
	}

	public void setMainstory(String mainstory) {
		this.mainstory = mainstory;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getVideourl() {
		return videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}

	public String getNewstype() {
		return newstype;
	}

	public void setNewstype(String newstype) {
		this.newstype = newstype;
	}

	@Override
	public String toString() {
		return "News [news_id=" + news_id + ", headlines=" + headlines
				+ ", mainstory=" + mainstory + ", imageurl=" + imageurl
				+ ", videourl=" + videourl + ", newstype=" + newstype + "]";
	}
	
}
