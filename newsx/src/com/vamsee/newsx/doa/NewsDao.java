package com.vamsee.newsx.doa;

import java.util.List;

import com.vamsee.newsx.domain.News;
import com.vamsee.newsx.domain.NewsMetric;



public interface NewsDao {

	public List<News> getAllNews();
	
	public void persistNews(News news);
	
	public News getNewsById(Long newsId);
	
	public List<News> searchNewsByQuery(String query);
	
	public List<News> getNewsByType(String newsType);
	
	public List<News> getNewsForCarouselByNewsType(String str);
	
	public List<News> getRecommendedNewsByNewsType(String str);
	
	public List<NewsMetric> getNewsMetric();
	
	
	public List<News> getRecommendedNewsByNewsType(String str, Long count);
	
	
	
	
	
}
