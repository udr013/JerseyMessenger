package com.udr013.databaseMock;

import com.udr013.domain.Message;
import com.udr013.domain.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Mock Database not thread save so just for testing locally
 */
public class databaseMock {

	private static Map<Long, Message> messageMap = new HashMap<>();
	private static Map<Long, Profile> profileMap = new HashMap<>();

	public static Map<Long, Message> getMessageMap() {
		return messageMap;
	}

	public static Map<Long, Profile> getProfileMap() {
		return profileMap;
	}


}
