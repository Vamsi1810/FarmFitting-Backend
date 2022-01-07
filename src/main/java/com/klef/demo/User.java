package com.klef.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Farmer_Table")
public class User {
	
	 @Column(name="Farmer_name")
     private String name;
     @Id
 	 @Column(name="Farmer_email")
     private String email;
     @Column(name="Farmer_mobile")
     private String mobile;
     @Column(name="Location")
     private String location;
     @Column(name="password")
     private String password;
     @Column(name="Access_key")
     private String accessKey;
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
