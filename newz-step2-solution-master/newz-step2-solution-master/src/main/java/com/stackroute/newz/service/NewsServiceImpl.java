package com.stackroute.newz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.stackroute.newz.util.exception.NewsAlreadyExistsException;
import com.stackroute.newz.model.News;
import com.stackroute.newz.repository.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	NewsRepository repo;
	
	@Override
	public News addNews(News Newsobj) throws NewsAlreadyExistsException{
    	Optional<News> optnews= repo.findById(Newsobj.getNewsId());
    	 if (optnews.isEmpty())
    	 {
    		 repo.save(Newsobj);
    		 return Newsobj;
    		 
    	 }
    	 else
    		 throw new NewsAlreadyExistsException("duplicate news");
    }
	@Override
    public List<News> getNews()
    {
    	return repo.findAll();
    }
	@Override
    public boolean deleteNews(int newsid) {
    	Optional<News> optnews= repo.findById(newsid);
    	if(optnews.isPresent())
    	{
    		repo.deleteById(newsid);
    		return true;
    	}
    	else return false;
    }
	@Override
    public News updateNews(News newsupdate) {
    	Optional<News> optnews= repo.findById(newsupdate.getNewsId());
    	if (optnews.isPresent())
    	{
    		repo.save(newsupdate);
    		return newsupdate;
    	}
    	else return null;
    }
	@Override
	public News getNewsById(int id) {
		Optional<News> opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
		//News newsres = repo.findByNewsId(id);
		//return newsres;
	}
}
