package com.springRest.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springRest.api.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	//Search by name
	List<Client> findByName( String name);
	
	//Search by character exemple: "a,b,c,d,e,f..." using Containing == Like
	List<Client> findByNameContaining(String name);
	Optional<Client>  findByEmail(String email);
}
 