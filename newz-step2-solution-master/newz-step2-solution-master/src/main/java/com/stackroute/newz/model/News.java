package com.stackroute.newz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int newsId;
	String title;
	String author;
 	String description;
 	String publishedYear;
 	String content;
 	String url;  
	  
	  public News(int newsId, String title, String author, String description, String publishedYear, String content,
			String url) {
		this.newsId = newsId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.publishedYear = publishedYear;
		this.content = content;
		this.url = url;
	}

	public News() { 
		  super(); 
		  }
	 
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", publishedYear=" + publishedYear + ", content=" + content + ", url=" + url + "]";
	}
	
	public int getNewsId() {
		return newsId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
