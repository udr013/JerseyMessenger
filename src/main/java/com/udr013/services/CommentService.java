package com.udr013.services;

import com.udr013.databaseMock.databaseMock;
import com.udr013.domain.Comment;
import com.udr013.domain.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by udr013 on 28-10-16.
 */
public class CommentService {

	private Map<Long, Message> messages = databaseMock.getMessageMap();

	public CommentService(){
//		comments.put(0L, new Comment(0L, "Hello World", "Mark"));
//		comments.put(1L, new Comment(1L, "Hello Jersey", "Mark"));
	}

	public List<Comment> getAllComments(long messageId){
		Map<Long, Comment> comments = messages.get(messageId).getCommentsMap();
		return new ArrayList<Comment>(comments.values());
	}

	public Comment getComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getCommentsMap();

		return  comments.get(commentId);
	}

	public Comment addComment(long messageId,Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getCommentsMap();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(),comment);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getCommentsMap();
		if (comment.getId()<= 0){
			return null;
		}else{
			comments.put(comment.getId(),comment);
			return comment;
		}
	}

	public Comment removeComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getCommentsMap();

		return comments.remove(commentId);
	}
}
