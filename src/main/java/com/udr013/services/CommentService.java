package com.udr013.services;

import com.udr013.databaseMock.databaseMock;
import com.udr013.domain.Comment;
import com.udr013.domain.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CommentService {

	private Map<Long, Message> messages = databaseMock.getMessageMap();

	public CommentService() {
		messages.get(0L).getCommentsMap().put(0L,new Comment(0,"here is the first comment","mark"));
		messages.get(0L).getCommentsMap().put(1L,new Comment(1,"here is the second comment","mark"));
		messages.get(1L).getCommentsMap().put(0L,new Comment(0,"here is the third comment","mark"));
		messages.get(1L).getCommentsMap().put(1L,new Comment(1,"here is the fourth comment","mark"));

	}

	public List<Comment> getAllComments(long messageId){
		Map<Long, Comment> comments = messages.get(messageId).getCommentsMap();
		return new ArrayList<>(comments.values());
	}

	public Comment getComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getCommentsMap();
		return  comments.get(commentId);
	}

	public Comment addComment(long messageId,Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getCommentsMap();
		comment.setCommentId(comments.size()+1);
		comments.put(comment.getCommentId(),comment);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getCommentsMap();
		if (comment.getCommentId()<= 0){
			return null;
		}else{
			comments.put(comment.getCommentId(),comment);
			return comment;
		}
	}

	public Comment removeComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getCommentsMap();

		return comments.remove(commentId);
	}
}
