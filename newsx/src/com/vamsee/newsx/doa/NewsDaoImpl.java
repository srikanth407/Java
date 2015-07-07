package com.vamsee.newsx.doa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.vamsee.newsx.domain.News;
import com.vamsee.newsx.domain.NewsMetric;
@Repository
public class NewsDaoImpl implements NewsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
		

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from news", new BeanPropertyRowMapper<News>(News.class));
	}

	@Override
	public void persistNews(News news) {
		// TODO Auto-generated method stub
		news.setNews_id(System.nanoTime());
		String insertSQL = "INSERT INTO news(news_id, headlines, mainstory, imageurl, videourl, newstype)"+
										"VALUES (?, ?, ?, ?, ?, ?);";
		jdbcTemplate.update(insertSQL, new Object[]{news.getNews_id(),news.getHeadlines(),news.getMainstory(),
				news.getImageurl(),news.getVideourl(),news.getNewstype()});
		
	}

	@Override
	public News getNewsById(Long newsId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from news where news_id =?", new Object[]{newsId},new BeanPropertyRowMapper<News>(News.class));
	}

	@Override
	public List<News> searchNewsByQuery(String query) {
		// TODO Auto-generated method stub
		String q = "select  * from news where upper(headlines) Like upper('%"+query+"%')";
		//System.out.println(q);
		return  jdbcTemplate.query(q,new BeanPropertyRowMapper<News>(News.class));		
	}

	@Override
	public List<News> getNewsByType(String newsType) {
		// TODO Auto-generated method stub
		String q = "select  * from news where newstype = ?";
		return jdbcTemplate.query(q,new Object[]{newsType}, new BeanPropertyRowMapper<News>(News.class));
	}

	@Override
	public List<News> getNewsForCarouselByNewsType(String str) {
		// TODO Auto-generated method stub	
		String query = "";
		if(StringUtils.isEmpty(str)){
			query = "select * from news order by Random() limit 4";
		}else{
			query = "select * from news where  newstype= '"+ str+"'order by Random() limit 4";
		}
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<News>(News.class));
	}

	@Override
	public List<News> getRecommendedNewsByNewsType(String str) {
		// TODO Auto-generated method stub
		String query = "select * from news where  newstype= '"+ str+"'order by Random() limit 10";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<News>(News.class));
	}

	@Override
	public List<NewsMetric> getNewsMetric() {
		// TODO Auto-generated method stub
	return jdbcTemplate.query("select newstype AS \"newsType\" ,count(*) AS \"count\" from news group by newstype", new BeanPropertyRowMapper<NewsMetric>(NewsMetric.class));
	}

	@Override
	public List<News> getRecommendedNewsByNewsType(String str, Long count) {
		// TODO Auto-generated method stub
		String query;
		if(count == 0){
			query = "select * from news where  newstype= '"+ str+"'order by Random() limit 25";
		}else{
			query = "select * from news where  newstype= '"+ str+"'order by Random() limit "+ count;
		}
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<News>(News.class));
	}

}
