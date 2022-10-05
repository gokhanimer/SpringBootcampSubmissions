package com.stackroute.NewzSource.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.NewzSource.model.NewsSource;
import com.stackroute.NewzSource.util.exception.NewsSourceAlreadyExistsException;

public interface NewsSourceService {

	public NewsSource addNews(NewsSource newsObj) throws NewsSourceAlreadyExistsException;
	
    public List<NewsSource> getNews();
    
    public boolean deleteNews(String newssourceId);
    
    public NewsSource updateNews(NewsSource newsUpdate);

	public List <NewsSource> getNewsByCreator(String newssourceCreatedBy);
}
