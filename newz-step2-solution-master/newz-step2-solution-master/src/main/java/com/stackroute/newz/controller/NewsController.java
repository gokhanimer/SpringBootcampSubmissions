package com.stackroute.newz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.newz.model.News;
import com.stackroute.newz.service.NewsService;
import com.stackroute.newz.util.exception.NewsAlreadyExistsException;

@RestController
@RequestMapping("news/api/")
public class NewsController {
	
	@Autowired
	NewsService service;
	
	@GetMapping("/getAllNews")
	public ResponseEntity<?> getNews(){	
		List<News> news=service.getNews();
		return new ResponseEntity<List<News>>(news,HttpStatus.OK);
	}
	
	@PostMapping("/addNews")
	public ResponseEntity<?> saveNews(@RequestBody News newsobj){
		News newsres;
		try {
			newsres = service.addNews(newsobj);
			return new ResponseEntity<News> (newsres,HttpStatus.CREATED);
		}
		catch (NewsAlreadyExistsException e)
		{
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateNews(@RequestBody News newsupdate){
		News updatednews = service.updateNews(newsupdate);
		
		if (updatednews==null)
			return new ResponseEntity("News not found", HttpStatus.NOT_FOUND);
		else 
			return new ResponseEntity<News> (updatednews,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deletenews/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int nid){
		boolean b = service.deleteNews(nid);
		
		if (b)
			return new ResponseEntity("Deleted", HttpStatus.OK);
		else 
			return new ResponseEntity("News not found",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> newsById(@PathVariable("id") int nid){
		News newsres = service.getNewsById(nid);
		if (newsres == null)
			return new ResponseEntity<>("Id not found", HttpStatus.NOT_FOUND);
		else 
			return new ResponseEntity<News>(newsres, HttpStatus.OK);
	}

}
