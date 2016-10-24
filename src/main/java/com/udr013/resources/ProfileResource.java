package com.udr013.resources;

import com.udr013.domain.Profile;
import com.udr013.services.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * To get a Jersey resource to work we need at least three annotations
 * @Path identifies the URI path template to which the resource responds
 * @GET, @POST, etc to know which method to use at a certain request
 * @Produce to specify the response type*/

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON) // now we don't have to annotate every method with it, it's for the whole class
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	ProfileService profileService = new ProfileService();

	@GET// now jersey now knows how to handle a GET request but also needs to know the format it needs to send back
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}

	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName){
		return profileService.getProfile(profileName);
	}

	@POST
	public Profile AddProfile(Profile profile){
		return profileService.addProfile(profile);
	}


	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}

	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName){ //void cause nothing to return
		profileService.removeProfile(profileName);
	}
}
