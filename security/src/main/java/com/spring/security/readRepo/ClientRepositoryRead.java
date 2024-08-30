package com.spring.security.readRepo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.entity.Client;

@Repository
public interface ClientRepositoryRead extends CrudRepository<Client,Long>{
	
	//@Query(value= "select b from Client b where b.Client=?1")
	Optional<Client> findByEmail(String emailAdress);

}
