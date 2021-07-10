package com.han.model;

import java.sql.Date;

public class Article {

	private int article_id;
	private int user_id;
	private String title;
	private String body;
	public Article(int user_id, String title, String body) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.body = body;
	}
	
	public Article(int article_id, int user_id, String title, String body) {
		super();
		this.article_id = article_id;
		this.user_id = user_id;
		this.title = title;
		this.body = body;
	}
	
	public Article() {
		super();
	}
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "Article [article_id=" + article_id + ", user_id=" + user_id + ", title=" + title + ", body=" + body + "]";
	}





	
	
	
}
