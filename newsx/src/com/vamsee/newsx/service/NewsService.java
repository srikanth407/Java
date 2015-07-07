package com.vamsee.newsx.service;

import java.util.List;

import com.vamsee.newsx.domain.News;
import com.vamsee.newsx.domain.NewsMetric;

public interface NewsService {

	public List<News> getEveryNewsFromMyDB();
	
	public News getNewsByNewsId(Long id);
	
	public void saveLatestNews(News news);
	
	public List<News> searchNews(String str);
	
	public List<News> getAllNewsByNewsType(String str);
	
	public List<News> getNewsForCarouselByNewsType(String str);
	
	public List<News> getRecommendedNewsByNewsType(String str);
	
	public List<NewsMetric> getNewsMetric();	
	
	public List<News> getRecommendedNewsByNewsType(String str, Long count);
	
	public String getChartData();
}
