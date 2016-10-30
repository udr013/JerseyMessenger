package com.udr013.services;


import com.udr013.Exceptions.DataNotFoundException;
import com.udr013.databaseMock.databaseMock;
import com.udr013.domain.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService {

	private Map<Long, Message> messages = databaseMock.getMessageMap();

	public MessageService(){
		messages.put(0L, new Message(0L, "Hello World", "Mark"));
		messages.put(1L, new Message(1L, "Hello Jersey", "Mark"));
	}

	public List<Message> getAllMessages(){
		// remember we can pass a Collection to the ArrayList Constructor
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesFromYear(int year){
		ArrayList<Message> msgsforYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message: messages.values()) {
			cal.setTime(message.getCreated()); //we set cal to year of message
			if (cal.get(Calendar.YEAR) == year) {
				msgsforYear.add(message);
			}
		}
		return msgsforYear;
	}

	public List<Message> getMessagesPaginated(int start,int size){
		List<Message> list = new ArrayList<Message>(messages.values());
		if(start + size > list.size()){
			return new ArrayList<Message>();
		}else {
			return list.subList(start, start + size);
		}
	}


	public Message getMessage (long id) throws DataNotFoundException {
		Message message = messages.get(id);
		if(message == null){
			//handle this elsewhere
			throw new DataNotFoundException("Message with id: "+ id + " is not found on the server!");
		}
		return message;
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

	public Message removeMessage(long id){
		return messages.remove(id);
	}

}
