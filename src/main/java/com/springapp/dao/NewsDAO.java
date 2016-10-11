package com.springapp.dao;

import java.util.List;

public interface NewsDAO {

	public void addNews(com.springapp.model.News p);
	public void updateNews(com.springapp.model.News p);
	public List<com.springapp.model.News> listNews();
	public com.springapp.model.News getNewsById(int id);
	public List<com.springapp.model.News> selectNewsByTitle(String title);
	public List<com.springapp.model.News> selectNewsByContent(String content);
	public List<com.springapp.model.News> selectNewsByCategory(String category);
	public void removeNews(int id);
}