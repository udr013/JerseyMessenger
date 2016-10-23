package com.udr013.services;


import com.udr013.databaseMock.databaseMock;
import com.udr013.domain.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

	private Map<Long, Profile> profiles = databaseMock.getProfileMap();

	public List<Profile> getAllProfiles(){
		return new ArrayList<>(profiles.values());
	}

	public Profile getProfile(long id){
		return  profiles.get(id);
	}

	public Profile addProfile(Profile profile){
		profile.setId(getAllProfiles().size()+1);
		profiles.put(profile.getId(),profile);
		return profile;
	}

	public Profile updateProfile(Profile profile){
		if (profile.getId()<= 0){
			return null;
		}else{
			profiles.put(profile.getId(),profile);
			return profile;
		}
	}

	public Profile removeProfile(long id) {
		return profiles.remove(id);
	}
}
