package com.springRest.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.api.model.Client;
import com.springRest.api.repository.ClientRepository;
import com.springRest.api.service.ClientService;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@RestController
@EqualsAndHashCode
@AllArgsConstructor
@RequestMapping(path = "/clients")
public class ClientController {
	
	// we use  the notation @Autowired wen we want not use @AllArgsConstructor
	private ClientRepository clientRepository;
	private ClientService clientService;
	
	
	
	//LIST METHOD
	//@GetMapping("/clients")  //ou
	@GetMapping
	public List<Client> list(){
		return clientRepository.findAll(); 
		//return cRepository.findByNameContaining("b"); // Search by name
	}
	
	// SEARCH METHOD
	@GetMapping("/{clientId}") 
	public ResponseEntity<Client> search( @PathVariable Long clientId){
		
		return clientRepository.findById(clientId)	.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

				//.map(client-> ResponseEntity.ok(client))
//		 
//		Optional<Client> client =	cRepository.findById(clientId);
//		if (client.isPresent()) {
//			return ResponseEntity.ok(client.get());
//		}
//		return ResponseEntity.notFound().build();
	}
	
	// SAVE METHOD
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) //status 201
	public Client addClient(@Valid @RequestBody Client client) {
		
		return clientService.saveClient(client);
		
	} 
	
	// UPDATE METHOD
	
  @PutMapping("/{clientId}")
	public ResponseEntity<Client> updateClient( @RequestBody Client client , @Valid @PathVariable Long clientId){
		if (!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(clientId);
		client = clientService.saveClient(client);
		return ResponseEntity.ok(client);
		
	}
	
  @DeleteMapping("/{clientId}")
  public ResponseEntity<Void> deleteClient( @PathVariable Long clientId){
	  
	  if (!clientRepository.existsById(clientId)) {
		return  ResponseEntity.notFound().build();		
	}
	  
	  clientService.deleteClient(clientId);
	  return ResponseEntity.noContent().build();
  }

}
