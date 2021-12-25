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
	
	public Status addUser(User user) {
		userrepo.save(user);
		Status s = new Status("Success");
		return s;
	}
	
	public Status deleteUser(String email) {
		userrepo.deleteById(email);
		Status s = new Status("Deleted");
		return s;
	}
	
	public Status loginCheck(String email,String password) {
		User u = userrepo.checkLogin(email, password);
		   System.out.println(u);
		if(u==null) {
			Status s = new Status("NotFound");
			return s;
		}
		Status s = new Status("Found");
		return s;
	}
	
	public Status updateUser(User user) {
		userrepo.save(user);
		Status s = new Status("Updated");
		return s;
	}
}
