package com.klef.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {
	@Autowired
	FinanceRepository finrepo;
	
	public Status addFinancePortal(Finance fin){
		finrepo.save(fin);
		Status s = new Status("Added");
		return s;
	}
	
	public List<Finance> getFinanceFunction(String email) {
		return (List<Finance>)finrepo.getAllThroughId(email);
	}
	
	public Status deleteRecord(int id) {
		finrepo.deleteById(id);
		Status s = new Status("Deleted");
		return s;
	}
}
