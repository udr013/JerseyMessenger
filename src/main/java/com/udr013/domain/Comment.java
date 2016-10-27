package com.udr013.domain;


import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {


	private static final long serialVersionUID = 8756878960992576800L;
	private long id;
	private String message;
	private Date created;
	private String author;

	public Comment(){

	}

	public Comment(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}