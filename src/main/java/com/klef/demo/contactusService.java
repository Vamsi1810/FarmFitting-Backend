package com.klef.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class contactusService {
	@Autowired
	contactusRepository contactrepo;
	
	public String sendQuery(contactus query) {
		contactrepo.save(query);
		return "reached";
	}
	
	public List<contactus> getQuery(){
		return (List<contactus>) contactrepo.findAll();
	}
	public String deleteQuery(int id) {
		contactrepo.deleteById(id);
		return "Deleted";
	}
}

