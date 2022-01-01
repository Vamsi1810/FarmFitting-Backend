package com.klef.demo;

import javax.mail.MessagingException;

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
	
	@Autowired
	EmailService es;
	
	@CrossOrigin
	@GetMapping("/user/getdetails/{email}")
	public User getUser(@PathVariable("email")String email) {
		return user.getUser(email);
	}
	
	@PostMapping("/user/add")
	@CrossOrigin
	public Status adduser(@RequestBody User u){
		return user.addUser(u);
	}
	@DeleteMapping("/user/delete/{email}")
	@CrossOrigin
	public Status deleteuser(@PathVariable("email")String email){
		return user.deleteUser(email);
	}
	
	@GetMapping("/user/login/{email}/{password}")
	@CrossOrigin
	public Status findUser(@PathVariable("email")String email,@PathVariable("password")String password) throws MessagingException {
		es.sendHtmlMessage(email,"Login Success","<h1>Thank your login is successful</h1>");
		return user.loginCheck(email, password);
	}
	
	@PutMapping("/user/update")
	@CrossOrigin
	public Status updateUser(@RequestBody User u) {
		return user.updateUser(u);
	}
}
