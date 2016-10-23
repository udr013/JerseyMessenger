package com.udr013.resources;

import com.udr013.domain.Profile;
import com.udr013.services.ProfileService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * To get a Jersey resource to work we need at least three annotations
 * @Path identifies the URI path template to which the resource responds
 * @GET, @POST, etc to know which method to use at a certain request
 * @Produce to specify the response type*/

@Path("/profiles") //jersey will look for this path and expect methods annotated with the various request methods for
// this path
public class ProfileResource {

	ProfileService profileService = new ProfileService();

	@GET// now jersey now knows how to handle a GET request but also needs to know the format it needs to send back
	@Produces(MediaType.APPLICATION_XML) // So we need the @Produces annotation and specify the MediaType
	public List<Profile> getProfiles(){

		return profileService.getAllProfiles();
	}
}
