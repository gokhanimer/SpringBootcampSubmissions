package newz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import newz.model.News;

@Controller
public class NewsController {

@GetMapping("/")
	public String getHome() {
		return "index";	
}
@PostMapping("/saveData")
	public String storeData(@ModelAttribute("NewsObj") News news) {
	System.out.println(news);
	if (news.getNewsId().isEmpty() || news.getAuthor().isEmpty() || news.getContent().length() > 100
			|| news.getDescription().length() < 10 ||news.getTitle().length() < 6)
	return "error";	
	else 
	return "register";
	
}
}
