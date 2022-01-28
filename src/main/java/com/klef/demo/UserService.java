package com.klef.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;    
import javax.crypto.Cipher;  
import javax.crypto.KeyGenerator;   
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec; 
@Service
public class UserService {
	@Autowired
	UserRepository userrepo;
	
	Cipher cipher;
	
	public User getUser(String email){
		return userrepo.getUser(email);
	}
	
	public Status addUser(User user) throws Exception {
		SecretKey sk = keyGenerator();
		String encrypted = encrypt(user.getPassword(),sk);
		user.setPassword(encrypted);
		String accesskey = Base64.getEncoder().encodeToString(sk.getEncoded());
		user.setAccessKey(accesskey);
		userrepo.save(user);
		Status s = new Status("Success");
		return s;
	}
	
	public Status deleteUser(String email) {
		userrepo.deleteById(email);
		Status s = new Status("Deleted");
		return s;
	}
	
	public Status loginCheck(String email,String password) throws Exception {
		User useremail = getUser(email);
//		System.out.println(useremail.getEmail());
		if(useremail.getEmail()!=null && useremail.getPassword().equals(password)) {
			
//			String pass = useremail.getPassword();
//			String acskey = useremail.getAccessKey();
//			byte[] decodedKey = Base64.getDecoder().decode(acskey);
//			SecretKey skr = new SecretKeySpec(decodedKey,0,decodedKey.length,"AES");
//			String decryptpass = decrypt(pass,skr);
//			System.out.println("Decrypted password is "+decryptpass);
//			if(decryptpass.equals(password)) {
				Status s = new Status("Found");
				return s;
		}
			Status s = new Status("NotFound");
			return s;
	}
	
	public Status updateUser(User user) {
		userrepo.save(user);
		Status s = new Status("Updated");
		return s;
	}
	
	public String encrypt(String plainText, SecretKey secretKey)
            throws Exception {
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }

    public String decrypt(String encryptedText, SecretKey secretKey)
            throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
    
    public SecretKey keyGenerator() throws Exception {
    	KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // block size is 128bits
        SecretKey secretKey = keyGenerator.generateKey();
        cipher = Cipher.getInstance("AES"); 
        return secretKey;
        
    }
}
