package com.ibm.examples.jaxrs.repository;

import java.util.List;
import javax.ws.rs.PathParam;

import com.ibm.examples.jaxrs.model.Entry;

public interface PhoneRepository {
	
	public List<Entry> getEntries();

	public Entry  addEntry(Entry entry);
	
	public int deleteEntry(int id);
	
	public List<Entry> searchEntryBySurname(@PathParam("surname") String surname);

}
