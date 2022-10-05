package com.stackroute.NewzSource.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.NewzSource.model.NewsSource;
import com.stackroute.NewzSource.repo.NewsSourceRepo;
import com.stackroute.NewzSource.util.exception.NewsSourceAlreadyExistsException;

@Service
public class NewsSourceServiceImpl implements NewsSourceService{

	@Autowired
	NewsSourceRepo repo;
	
	@Override
	public NewsSource addNews(NewsSource newsObj) throws NewsSourceAlreadyExistsException {
		Optional<NewsSource> optnews= repo.findById(newsObj.getNewssourceId());
   	 if (optnews.isEmpty()) {
   		 repo.save(newsObj);
   		 return newsObj;   		 
   	} else
   		 throw new NewsSourceAlreadyExistsException("duplicate news");
	}

	
	public List<NewsSource> getNews() {
		return repo.findAll();
	}

	@Override
	public boolean deleteNews(String newssourceId) {
		Optional<NewsSource> optnews= repo.findById(newssourceId);
    	if(optnews.isPresent())
    	{
    		repo.deleteById(newssourceId);
    		return true;
    	}
    	else return false;
	}

	@Override
	public NewsSource updateNews(NewsSource newsupdate) {
		Optional<NewsSource> optnews= repo.findById(newsupdate.getNewssourceId());
    	if (optnews.isPresent())
    	{
    		repo.save(newsupdate);
    		return newsupdate;
    	}
    	else return null;
	}

	@Override
	public List<NewsSource> getNewsByCreator(String newssourceCreatedBy) { 
		return repo.findByNewssourceCreatedBy(newssourceCreatedBy);
		}

}
