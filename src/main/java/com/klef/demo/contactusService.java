package com.klef.demo;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class contactusService {
	@Autowired
	contactusRepository contactrepo;
	
	public Status sendQuery(contactus query) {
		query.setId(randomString());
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
	public String randomString() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 20;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}
}

