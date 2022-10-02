package com.springRest.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springRest.api.model.Delivery;
import com.springRest.api.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinishingService {

	private DeliveryRepository deliveryRepository;
	private SearchDeliveryService searchDeliveryService;
	
	
	@Transactional
	public void finishing(Long deliveryId) {
		
		Delivery delivery = searchDeliveryService.searchOccurrence(deliveryId);

	      	delivery.finished();
		deliveryRepository.save(delivery);
		
	}
}
