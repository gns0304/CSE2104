package com.han.model;

public class Lecture {
	


	private int lecture_id;
	private String title;
	private String language;
	private int price;
	private String image_url;
	private String description;
	
	public Lecture(String title, String language, int price, String image_url, String description) {
		super();
		this.title = title;
		this.language = language;
		this.price = price;
		this.image_url = image_url;
		this.description = description;
	}
	
	public Lecture() {
		
	}

	public int getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Lecture [lecture_id=" + lecture_id + ", title=" + title + ", language=" + language + ", price=" + price
				+ ", image_url=" + image_url + ", description=" + description + "]";
	}
	
	
	
	
	
}
