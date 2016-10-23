package com.udr013.services;


import com.udr013.databaseMock.databaseMock;
import com.udr013.domain.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService {

	private Map<Long, Message> messages = databaseMock.getMessageMap();

	public MessageService(){
		messages.put(0L, new Message(0L, "Hello World", "Mark"));
		messages.put(1L, new Message(1L, "Hello Jersey", "Mark"));
	}

	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long id){
		return  messages.get(id);
	}

	public Message addMassage(Message message){
		message.setId(getAllMessages().size()+1);
		messages.put(message.getId(),message);
		return message;
	}

	public Message updateMessage(Message message){
		if (message.getId()<= 0){
			return null;
		}else{
			messages.put(message.getId(),message);
			return message;
		}
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}

}
