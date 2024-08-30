package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.entity.Client;
import com.spring.security.readRepo.ClientRepositoryRead;
import com.spring.security.writeRepo.ClientRepositoryWrite;

@Service
public class ClientService {

	@Autowired
	private ClientRepositoryRead clientRepositoryRead;

	@Autowired
	private ClientRepositoryWrite clientRepositoryWrite;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public ResponseEntity<String> registerUser(Client client) {
		try {
			String hashPwd = passwordEncoder.encode(client.getPassword());
			client.setPassword(hashPwd);
			Client savedCustomer = clientRepositoryWrite.save(client);

			if (savedCustomer.getId() > 0) {
				return ResponseEntity.status(HttpStatus.CREATED).body("Given user details are successfully registered");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
			}
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An exception occurred: " + ex.getMessage());
		}

	}

}
