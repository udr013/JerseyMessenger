package com.udr013.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Smal illustration on how to read headers
 */

@Path("/header")
@Produces(MediaType.TEXT_PLAIN)
public class HeaderResource {

	@GET
	public String getHeaderParams(@HeaderParam("blabla") String header,
								  @CookieParam("cookie") String cookie){
		// there is als a @FormParam but  not  widely used
		return "HeaderParam value of blabla: " + header +"/n This is myCookie: " + cookie;
	}
}
