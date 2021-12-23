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
public class contactusController {

	@Autowired
	contactusService query;
	
	@PostMapping("/query/send")
	@CrossOrigin
	public String sendquery(@RequestBody contactus cus) {
		return query.sendQuery(cus);
	}
	
	@GetMapping("/query/all")
	@CrossOrigin
	public List<contactus> getQueries(){
		return query.getQuery();
	}
	
	@DeleteMapping("/query/delete/{id}")
	@CrossOrigin
	public String deleteQuery(@PathVariable("id")int id) {
		return query.deleteQuery(id);
	}
}
