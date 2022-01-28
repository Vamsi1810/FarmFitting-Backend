package com.klef.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	UserService user;
	
	@Autowired
	EmailService es;

	@GetMapping("/user/getdetails/{email}")
	public User getUser(@PathVariable("email")String email) {
		return user.getUser(email);
	}
	

	@PostMapping("/user/add")
	public Status adduser(@RequestBody User u) throws Exception{
		return user.addUser(u);
	}
	

	@DeleteMapping("/user/delete/{email}")
	public Status deleteuser(@PathVariable("email")String email){
		return user.deleteUser(email);
	}
	

	@GetMapping("/user/login/{email}/{password}")
	public Status findUser(@PathVariable("email")String email,@PathVariable("password")String password) throws Exception {
		es.sendHtmlMessage(email,"Login Success","<h1>Thank your login is successful</h1>");
		return user.loginCheck(email, password);
	}
	

	@PutMapping("/user/update")
	public Status updateUser(@RequestBody User u) {
		return user.updateUser(u);
	}
}
