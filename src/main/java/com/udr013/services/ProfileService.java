package com.udr013.services;


import com.udr013.databaseMock.databaseMock;
import com.udr013.domain.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

	private Map<String, Profile> profiles = databaseMock.getProfileMap();

	public ProfileService(){
		profiles.put("udr013", new Profile(1L,"udr013","Mark","Markie"));
	}

	public List<Profile> getAllProfiles(){
		return new ArrayList<>(profiles.values());
	}

	public Profile getProfile(String profileName){
		return  profiles.get(profileName);
	}

	public Profile addProfile(Profile profile){
		profile.setId(getAllProfiles().size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}

	public Profile updateProfile(Profile profile){
		if (profile.getProfileName().isEmpty()){
			return null;
		}else{
			profiles.put(profile.getProfileName(),profile);
			return profile;
		}
	}

	public Profile removeProfile(String profileName) {

		return profiles.remove(profileName);
	}
}
