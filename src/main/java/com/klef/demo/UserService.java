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
	
	public String addUser(User user) {
		userrepo.save(user);
		return "added";
	}
	
	public String deleteUser(String email) {
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
	
	public String updateUser(User user) {
		userrepo.save(user);
		return "updated";
	}
}
