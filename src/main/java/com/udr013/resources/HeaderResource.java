package com.udr013.resources;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Smal illustration on how to read headers
 */

@Path("/header")
@Produces(MediaType.TEXT_PLAIN)
public class HeaderResource {

	@GET
	public String getHeaderParams(@HeaderParam("blabla") String header){
		return "HeaderParam value of blabla: " +header;
	}
}
