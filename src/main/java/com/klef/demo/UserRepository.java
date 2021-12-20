package com.klef.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User,String> {

	@Query("select u from User u where u.email= :email and password = :password")
	public User checkLogin(@Param("email") String email,@Param("password")String password);
	
	@Query("select u from User u where u.email=:email")
	public User getUser(@Param("email")String email);
}
