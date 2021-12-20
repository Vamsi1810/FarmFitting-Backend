package com.klef.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {
	@Autowired
	FinanceRepository finrepo;
	
	public String addFinancePortal(Finance fin){
		finrepo.save(fin);
		return "Added";
	}
	
	public List<Finance> getFinanceFunction(String email) {
		return (List<Finance>)finrepo.getAllThroughId(email);
	}
	
	public String deleteRecord(int id) {
		finrepo.deleteById(id);
		return "Deleted";
	}
}
