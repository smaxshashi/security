package com.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.Client;
import com.spring.security.service.ClientService;

@RestController
public class TestController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping("/myCards")
    public  String getCardsDetails () {
        return "Here are the card details from the DB";
    }
	
	@GetMapping("/myAccount")
    public  String getmyAccount () {
        return "Here are the card details from the DB";
    }
	
	@GetMapping("/register")
	public String registerUser() {
		
		Client client= new Client();
		client.setEmailAdress("userr@gmail.com");
		client.setName("usernew");
		client.setPassword("90076");
		client.setRole("user");
		
		ResponseEntity<String> registerUser= clientService.registerUser(client);
		if(registerUser.getStatusCode().toString().equals("200")) {
			return"success";
		}
		return "not success";
		
	}

}
