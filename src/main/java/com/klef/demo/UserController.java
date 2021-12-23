package com.klef.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
	@Autowired
	UserService user;
	
	@CrossOrigin
	@GetMapping("/user/getdetails/{email}")
	public User getUser(@PathVariable("email")String email) {
		return user.getUser(email);
	}
	
	@PostMapping("/user/add")
	@CrossOrigin
	public String adduser(@RequestBody User u){
		return user.addUser(u);
	}
	@DeleteMapping("/user/delete/{email}")
	@CrossOrigin
	public String deleteuser(@PathVariable("email")String email){
		return user.deleteUser(email);
	}
	
	@GetMapping("/user/login/{email}/{password}")
	@CrossOrigin
	public String findUser(@PathVariable("email")String email,@PathVariable("password")String password) {
		return user.loginCheck(email, password);
	}
	
	@PutMapping("/user/update")
	@CrossOrigin
	public String updateUser(@RequestBody User u) {
		return user.updateUser(u);
	}
}
