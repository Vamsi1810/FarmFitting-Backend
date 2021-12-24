package com.klef.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class contactusService {
	@Autowired
	contactusRepository contactrepo;
	
	public Status sendQuery(contactus query) {
		contactrepo.save(query);
		Status s = new Status("Reached");
		return s;
	}
	
	public List<contactus> getQuery(){
		return (List<contactus>) contactrepo.findAll();
	}
	public Status deleteQuery(int id) {
		contactrepo.deleteById(id);
		Status s = new Status("Deleted");
		return s;
	}
}

