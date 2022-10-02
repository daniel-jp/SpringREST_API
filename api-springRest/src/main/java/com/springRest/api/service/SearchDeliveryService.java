package com.springRest.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springRest.api.bexception.BusinessNotFoundExeption;
import com.springRest.api.model.Delivery;
import com.springRest.api.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SearchDeliveryService {
	
private DeliveryRepository deliveryRepository;
	
	@Transactional
	public Delivery searchOccurrence(Long delivery_id) {
		return deliveryRepository.findById(delivery_id)
				.orElseThrow(() -> new BusinessNotFoundExeption("Delivery not founded!"));
		
	}

}
