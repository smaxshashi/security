package com.spring.security.writeRepo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.entity.Client;

@Repository
public interface ClientRepositoryWrite extends CrudRepository<Client,Long>{
	
	Optional<Client> findByEmail(String email_adress);

}
