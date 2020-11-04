package org.thoke.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.thoke.messenger.database.DatabaseClass;
import org.thoke.messenger.model.Profile;

public class ProfileService {
	
private Map<String, Profile> profiles = DatabaseClass.getProfiles();

public ProfileService() {
	profiles.put("moses", new Profile(1L, "moses", "Moses", "Thokeronga"));
	profiles.put("brenda", new Profile(2L, "brenda", "Brenda", "Basooma"));
	profiles.put("mercy", new Profile(3L, "mercy", "Marcelina", "Ayomirwoth"));
	}
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}

}
