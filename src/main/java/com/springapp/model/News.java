package com.springapp.model;

import javax.persistence.*;
import java.util.Date;


 		@NamedNativeQuery(
				name = "selectNewsByCategory",
				query = "select * FROM News WHERE :string=category",
				resultClass = News.class)

@Entity
@Table(name="NEWS")
public class News {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="TITLE")
	private String title;

	private String content;

	@Temporal(TemporalType.DATE)
	private java.util.Date date;

	private String category;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString(){
		return "id="+id+", title="+title+", content="+content+", content="+date+", category="+category;
	}
}
