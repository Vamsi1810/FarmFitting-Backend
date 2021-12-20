package com.klef.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserService user;
	
	@GetMapping("/user/{email}")
	public User getUser(@PathVariable("email")String email) {
		return user.getUser(email);
	}
	
	@PostMapping("/user/add")
	public String adduser(@RequestBody User u){
		return user.addUser(u);
	}
	@DeleteMapping("/user/delete/{email}")
	public String deleteuser(@PathVariable("email")String email){
		return user.deleteUser(email);
	}
}
