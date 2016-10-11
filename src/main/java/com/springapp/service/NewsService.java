package com.springapp.service;

import java.util.List;

public interface NewsService {

	public void addNews(com.springapp.model.News p);
	public void updateNews(com.springapp.model.News p);
	public List<com.springapp.model.News> listNews();
	public com.springapp.model.News getNewsById(int id);
	public void removeNews(int id);

	public List<com.springapp.model.News> selectNewsByTitle(String title);
	public List<com.springapp.model.News> selectNewsByContent(String content);
	public List<com.springapp.model.News> selectNewsByCategory(String category);

}
