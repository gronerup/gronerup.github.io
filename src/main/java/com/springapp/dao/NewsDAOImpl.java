package com.springapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.springapp.model.News;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDAOImpl implements NewsDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(NewsDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addNews(com.springapp.model.News p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateNews(com.springapp.model.News p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.springapp.model.News> listNews() {
		Session session = this.sessionFactory.getCurrentSession();
		List<com.springapp.model.News> NewsList = session.createQuery("from News").list();
		for(com.springapp.model.News p : NewsList){
			logger.info("Person List::"+p);
		}
		return NewsList;
	}

	@Override
	public com.springapp.model.News getNewsById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		com.springapp.model.News p = (com.springapp.model.News) session.load(com.springapp.model.News.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeNews(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		com.springapp.model.News p = (com.springapp.model.News) session.load(com.springapp.model.News.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}
	@Override
	public List<com.springapp.model.News> selectNewsByTitle(String title) {
		Session session = this.sessionFactory.getCurrentSession();
		List<News> NewsList = new ArrayList<News>();
		String hql = "from News where Title LIKE :string ";
		Query query = session.createQuery(hql);
		query.setParameter("string","%"+title+"%");
		for(Object c : query.list())
			NewsList.add((News)c);


		return NewsList;
	}

	@Override
	public List<com.springapp.model.News> selectNewsByContent(String content) {
		Session session = this.sessionFactory.getCurrentSession();
		List<News> NewsList = new ArrayList<News>();
		String hql = "from News where content LIKE :string ";
		Query query = session.createQuery(hql);
		query.setParameter("string","%"+content+"%");
		for(Object c : query.list())
			NewsList.add((News)c);


		return NewsList;
	}




	@Override
	public List<com.springapp.model.News> selectNewsByCategory(String category) {
		Session session = this.sessionFactory.getCurrentSession();
		List<News> NewsList = new ArrayList<News>();
		Query query = session.getNamedQuery("selectNewsByCategory");
		query.setParameter("string",category);
		for(Object c : query.list())
			NewsList.add((News)c);


		return NewsList;
	}

	}
