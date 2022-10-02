package com.springRest.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springRest.api.bexception.BusinessExceptions;
import com.springRest.api.model.Client;
import com.springRest.api.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientService {
	
	private ClientRepository clientRepository;
	
	@Transactional
	public Client saveClient( Client client) {
		boolean emailUser= clientRepository.findByEmail(client.getEmail())
				.stream()
				.anyMatch(cExist -> !cExist.equals(client));
		if (emailUser){
			 throw new BusinessExceptions("There is already a customer with this email!");
		}
		return clientRepository.save(client);
	}
	
	@Transactional
	public void deleteClient(Long clientId) {
		
	 clientRepository.deleteById(clientId);
		
		
	}
	

}
