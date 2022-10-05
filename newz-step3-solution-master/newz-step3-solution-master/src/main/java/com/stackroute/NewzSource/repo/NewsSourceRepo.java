package com.stackroute.NewzSource.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.NewzSource.model.NewsSource;


@Repository
public interface NewsSourceRepo extends MongoRepository<NewsSource, String>{

	List <NewsSource> findByNewssourceCreatedBy(String newssourceCreatedBy);
}
