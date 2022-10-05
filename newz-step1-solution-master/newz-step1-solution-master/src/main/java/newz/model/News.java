package newz.model;

public class News {
String newsId;
String title;
String author;
String description;
String content;

public String getNewsId() {
	return newsId;
}
public void setNewsId(String newsId) {
	this.newsId = newsId;
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
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

public String toString() {
	return "News [newsId=" + newsId + ", title=" + title + ", author=" + author + ", description=" + description
			+ ", content=" + content + "]";
}

}
