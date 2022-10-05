package com.stackroute.newz.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.newz.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{

	News findByNewsId(int id);

}
