package com.ibm.examples.jaxrs.service;

import java.util.List;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.examples.jaxrs.exception.PhoneEntryNotFoundException;
import com.ibm.examples.jaxrs.model.Entry;
import com.ibm.examples.jaxrs.repository.PhoneRepository;


public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneRepository repository;

	@Override
	public List<Entry> getAllPhoneBookEntries() {
		return repository.getEntries();
	}

	@Override
	public Response addPhoneBookEntry(Entry entry) {
		Entry newEntry=repository.addEntry(entry);
		return Response.ok(newEntry).build();
	}

	@Override
	public Response searchPhoneBookEntryBySurname(String surname) {
		List<Entry> entry=(List<Entry>) repository.searchEntryBySurname(surname);
		if(entry == null || entry.isEmpty()){
			throw new PhoneEntryNotFoundException("not found");
		}
		return Response.ok(entry).build();
	}

	@Override
	public Response deleteEntry(int id) {
		repository.deleteEntry(id);
		return Response.noContent().build();
	}

}
