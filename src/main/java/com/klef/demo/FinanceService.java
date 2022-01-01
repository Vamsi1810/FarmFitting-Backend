package com.klef.demo;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {
	@Autowired
	FinanceRepository finrepo;
	
	public Status addFinancePortal(Finance fin){
		fin.setId(randomString());
		finrepo.save(fin);
		Status s = new Status("Added");
		return s;
	}
	
	public List<Finance> getFinanceFunction(String email) {
		return (List<Finance>)finrepo.getAllThroughId(email);
	}
	
	public List<Finance> getDataBasedOnType(String email,String type){
		return (List<Finance>)finrepo.getDataBasedOnType(email, type);
	}
	
	public Status deleteRecord(int id) {
		finrepo.deleteById(id);
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
