package com.udr013.domain;


import java.io.Serializable;
import java.util.Date;

public class Comment implements
		Serializable {


	private static final long serialVersionUID = 8756878960992576800L;
	private long commentId;
	private String msgComment;
	private Date created;
	private String author;

	public Comment(){

	}

	public Comment(long commentId, String msgComment, String author) {
		this.commentId = commentId;
		this.msgComment = msgComment;
		this.created = new Date();
		this.author = author;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getMsgComment() {
		return msgComment;
	}

	public void setMsgComment(String msgComment) {
		this.msgComment = msgComment;
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