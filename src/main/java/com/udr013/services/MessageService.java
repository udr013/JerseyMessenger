package com.udr013.services;


import com.udr013.domain.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

	public List<Message> getAllMessages(){

		List<Message> messages =new ArrayList<>();
		Message m1 = new Message(1L, "Hello World", "Mark");
		Message m2 = new Message(2L, "Hello Jersey", "Mark");
		Message m3 = new Message(3L, "Hello Mark", "Mark");

		messages.add(m1);
		messages.add(m2);
		messages.add(m3);

		return messages;
	}
}
