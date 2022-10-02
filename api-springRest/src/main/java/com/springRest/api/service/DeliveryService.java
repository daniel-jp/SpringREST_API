package com.springRest.api.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springRest.api.bexception.BusinessExceptions;
import com.springRest.api.model.Client;
import com.springRest.api.model.Delivery;
import com.springRest.api.model.StatusDelivery;
import com.springRest.api.repository.ClientRepository;
import com.springRest.api.repository.DeliveryRepository;

import lombok.AllArgsConstructor;


@Service 
@AllArgsConstructor
public class DeliveryService {
	

	private ClientRepository clientRepository;
	private DeliveryRepository deliveryRepository;
	
	@Transactional
	public Delivery saveDelivery(Delivery delivery) {
		
		Client client = clientRepository.findById(delivery.getClient().getId())
				.orElseThrow(()-> new BusinessExceptions("Client not found"));
		
		delivery.setClient(client);
		delivery.setStatusDelivery(StatusDelivery.PENDING);
		delivery.setOrderDate(OffsetDateTime.now());
		
		return deliveryRepository.save(delivery);
	}
	
	@Transactional
	public List<Delivery> all_List (){
		return deliveryRepository.findAll();
	}
	
	
	
}
