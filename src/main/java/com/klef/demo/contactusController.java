package com.klef.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class contactusController {

	@Autowired
	contactusService query;
	
	@PostMapping("/query/send")
	public String sendquery(@RequestBody contactus cus) {
		return query.sendQuery(cus);
	}
	
	@GetMapping("/query/all")
	public List<contactus> getQueries(){
		return query.getQuery();
	}
}
