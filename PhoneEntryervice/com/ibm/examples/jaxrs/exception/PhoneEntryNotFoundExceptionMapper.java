package com.ibm.examples.jaxrs.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Value;

@Provider
public class PhoneEntryNotFoundExceptionMapper implements ExceptionMapper<PhoneEntryNotFoundException> {

	@Value("${message.PhoneBookEntryNotfound}")
	String message;
	
	@Override
	public Response toResponse(PhoneEntryNotFoundException exception) {
		return Response.serverError().entity(message).type(MediaType.APPLICATION_JSON).build();
	}

}
