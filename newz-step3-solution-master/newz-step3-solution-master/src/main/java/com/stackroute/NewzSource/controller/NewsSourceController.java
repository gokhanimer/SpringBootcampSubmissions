package com.stackroute.NewzSource.controller;

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

import com.stackroute.NewzSource.model.NewsSource;
import com.stackroute.NewzSource.service.NewsSourceService;
import com.stackroute.NewzSource.util.exception.NewsSourceAlreadyExistsException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("news/mongo/")
public class NewsSourceController {

	@Autowired
	NewsSourceService service;
	
	@ApiOperation("to post new Jobs")
	@GetMapping("/getAllNews")
	public ResponseEntity<?> getNews(){	
		List<NewsSource> news=service.getNews();
		return new ResponseEntity<List>(news,HttpStatus.OK);
	}
	
	@PostMapping("/addNews")
	public ResponseEntity<?> saveNews(@RequestBody NewsSource newsObj) throws NewsSourceAlreadyExistsException{
			NewsSource newsAdd = service.addNews(newsObj);
			return new ResponseEntity<NewsSource> (newsAdd,HttpStatus.CREATED);

	}
	@PutMapping("/updateNews")
	public ResponseEntity<?> updateNews(@RequestBody NewsSource newsUpdate){
		NewsSource updatednews = service.updateNews(newsUpdate);
		
		if (updatednews==null)
			return new ResponseEntity("News not found", HttpStatus.NOT_FOUND);
		else 
			return new ResponseEntity<NewsSource> (updatednews,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteNews/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String newssourceId){
		boolean b = service.deleteNews(newssourceId);
		
		if (b)
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		else 
			return new ResponseEntity<String>("News not found",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/{newssourceCreatedBy}")
	public ResponseEntity<?> getCreator(@PathVariable("newssourceCreatedBy") String newssourceCreatedBy)
	{
	List <NewsSource> news=	service.getNewsByCreator(newssourceCreatedBy);
	return new ResponseEntity<List<NewsSource>> (news, HttpStatus.OK);
	}

}
