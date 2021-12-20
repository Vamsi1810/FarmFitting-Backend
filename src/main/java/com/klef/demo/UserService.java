package com.klef.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository userrepo;
	
	public User getUser(String email){
		return userrepo.getUser(email);
	}
	
	public String addEmployee(User user) {
		userrepo.save(user);
		return "added";
	}
	
	public String deleteEmployee(String email) {
		userrepo.deleteById(email);
		return "deleted";
	}
	
	public String loginCheck(String email,String password) {
		User u = userrepo.checkLogin(email, password);
		if(u!=null) {
			return "NotFound";
		}
		return "Found";
	}
	
}
