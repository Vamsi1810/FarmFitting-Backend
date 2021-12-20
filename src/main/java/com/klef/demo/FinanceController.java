package com.klef.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinanceController {
	@Autowired
	FinanceService finserv;
	
	
	@PostMapping("/finance/add")
	public String addFinance(@RequestBody Finance fin) {
		return finserv.addFinancePortal(fin);
	}
	
	@GetMapping("/finance/{email}/all")
	public List<Finance> getFinanceFunction(@PathVariable("email") String email) {
		return finserv.getFinanceFunction(email);
	}
	
	@DeleteMapping("/finance/delete/record/{id}")
	public String deleteRecord(@PathVariable("id") int id) {
		return finserv.deleteRecord(id);
	}
}
