package com.ibm.examples.jaxrs.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ibm.examples.jaxrs.model.Entry;

@Path("/")
public interface PhoneService {

	@GET
	@Path("/entries")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Entry> getAllPhoneBookEntries();

	@POST
	@Path("/addEntry")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPhoneBookEntry(Entry entry);

	@Path("/searchEntry/{surname}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchPhoneBookEntryBySurname(@PathParam("surname") String surname);

	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEntry(@PathParam("id") int id);

}
