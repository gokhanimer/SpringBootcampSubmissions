package com.stackroute.newz.service;

import java.util.List;


import com.stackroute.newz.util.exception.NewsAlreadyExistsException;
import com.stackroute.newz.model.News;

public interface NewsService {
	
    public News addNews(News Newsobj) throws NewsAlreadyExistsException; 
    
    public List<News> getNews();
    
    public boolean deleteNews(int newsid);
    
    public News updateNews(News newsupdate);

	public News getNewsById(int id);
    
}
