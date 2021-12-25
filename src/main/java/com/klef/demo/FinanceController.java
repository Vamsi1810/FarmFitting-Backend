package com.klef.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class FinanceController {
	@Autowired
	FinanceService finserv;
	
	
	@PostMapping("/user/finance/add")
	@CrossOrigin
	public Status addFinance(@RequestBody Finance fin) {
		return finserv.addFinancePortal(fin);
	}
	
	@GetMapping("/user/finance/{email}/all")
	@CrossOrigin
	public List<Finance> getFinanceFunction(@PathVariable("email") String email) {
		return finserv.getFinanceFunction(email);
	}
	@GetMapping("/user/getfinance/{email}/{type}")
	@CrossOrigin
	public List<Finance> getFinanceBasedOnType(@PathVariable("email")String email,@PathVariable("type")String type){
		return finserv.getDataBasedOnType(email, type);
	}
	
	@DeleteMapping("/user/finance/delete/record/{id}")
	@CrossOrigin
	public Status deleteRecord(@PathVariable("id") int id) {
		return finserv.deleteRecord(id);
	}
}
