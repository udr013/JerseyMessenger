package com.udr013.Exceptions;


import com.udr013.domain.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider // we need to annotate with provider so the class gets registered in jax-rs so jax-rs is able to handle the
// exception for us. otherwise it would be handled by tomcat eventually
public  class GenericExceptionMapper implements ExceptionMapper<Throwable>{


	@Override
	public Response toResponse(Throwable t) {
		ErrorMessage errorMessage = new ErrorMessage(t.getMessage(), 500, "internal server error");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(errorMessage).build();
	}


}
