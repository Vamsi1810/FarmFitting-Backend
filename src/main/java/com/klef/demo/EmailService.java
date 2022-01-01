package com.klef.demo;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {	
	@Autowired
	private JavaMailSender emailSender;
	
//	public void sendSimpleMessage(String to, String subject, String text) {
//		SimpleMailMessage message = new SimpleMailMessage();
//		
//		message.setTo(to);
//		message.setSubject(subject);
//		text = String.format(text); 
//		message.setText(text);
//		emailSender.send(message);
//	}
	
	public void sendHtmlMessage(String to, String subject, String htmlBody) throws MessagingException {
	    MimeMessage message = emailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(htmlBody, true);
	    emailSender.send(message);
	}
}

