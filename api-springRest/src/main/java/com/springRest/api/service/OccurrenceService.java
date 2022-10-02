package com.springRest.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springRest.api.model.Delivery;
import com.springRest.api.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OccurrenceService {
	
	private SearchDeliveryService searchDeliveryService;
	
	@Transactional
	public Occurrence createOccurrence(Long delivery_id, String description) {
		Delivery delivery = searchDeliveryService.searchOccurrence(delivery_id); 
		return delivery.addOccurrence(description);
	}

}
