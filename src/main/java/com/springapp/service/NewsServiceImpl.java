package com.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewsServiceImpl implements NewsService {
	
	private com.springapp.dao.NewsDAO newsDAO;

	public void setNewsDAO(com.springapp.dao.NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	@Override
	@Transactional
	public void addNews(com.springapp.model.News p) {
		this.newsDAO.addNews(p);
	}

	@Override
	@Transactional
	public void updateNews(com.springapp.model.News p) {
		this.newsDAO.updateNews(p);
	}

	@Override
	@Transactional
	public List<com.springapp.model.News> listNews() {
		return this.newsDAO.listNews();
	}

	@Override
	@Transactional
	public com.springapp.model.News getNewsById(int id) {
		return this.newsDAO.getNewsById(id);
	}

	@Override
	@Transactional
	public void removeNews(int id) {
		this.newsDAO.removeNews(id);
	}

	@Override
	@Transactional
	public List<com.springapp.model.News> selectNewsByTitle(String title){return this.newsDAO.selectNewsByTitle(title);
	}

	@Override
	@Transactional
	public List<com.springapp.model.News> selectNewsByContent(String content) {return this.newsDAO.selectNewsByContent(content);
	}

	@Override
	@Transactional
	public List<com.springapp.model.News> selectNewsByCategory(String category){return this.newsDAO.selectNewsByCategory(category);
	}

}
