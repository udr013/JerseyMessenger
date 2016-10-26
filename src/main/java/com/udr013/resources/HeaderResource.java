package com.udr013.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.Map;

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

	@GET
	@Path("/context")
	public String getParamUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){

	String uriInfoString = uriInfo.getAbsolutePath().toString();
	String kookie = httpHeaders.getCookies().toString();
	Map httpHeaderMap = httpHeaders.getRequestHeaders();

	List bla = httpHeaders.getAcceptableMediaTypes();

		return " This is the uriInfoString " +
				"AbsolutePath: " + uriInfoString + "###  httpHeaderMap: ### " + httpHeaderMap.entrySet() + " " +
				" ### httpHeaders.getAcceptableMediaTypes: ### "+ bla.get(0).toString() +", " +bla.get(1).toString()+
				" ### kookie ###" + kookie;

	}

}
