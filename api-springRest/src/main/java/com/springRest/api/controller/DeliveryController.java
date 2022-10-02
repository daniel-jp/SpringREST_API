package com.springRest.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.api.dtoModel.DeliveryDtoModel;
import com.springRest.api.mapper.DeliveryMapper;
import com.springRest.api.model.Delivery;
import com.springRest.api.repository.DeliveryRepository;
import com.springRest.api.service.DeliveryService;
import com.springRest.api.service.FinishingService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
	
	private DeliveryRepository deliveryRepository;
	private DeliveryService deliveryService;
	private FinishingService finishingService;
	private DeliveryMapper deliveryMapper;

	@GetMapping
	public List<DeliveryDtoModel> list(){
		return deliveryMapper.toCollectionModel(deliveryRepository.findAll());
	}
	
	// Converter de DTo model para Entidade

	  @PostMapping
	  @ResponseStatus(HttpStatus.CREATED) 
	  public DeliveryDtoModel createDelivery(@Valid @RequestBody Delivery delivery) { 
		  Delivery deliveryCreate = deliveryService.saveDelivery(delivery);
	  
	  return deliveryMapper.toModel(deliveryCreate); 
	  }
	  
	  @PutMapping("/{deliveryId}/finishing")
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void finishing( @PathVariable Long deliveryId) {
		  
		  finishingService.finishing(deliveryId);
		
	}
	  
	  
	
		/*
	// Converter de Entidade para DTo model

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DeliveryDtoModel createDelivery(@Valid @RequestBody DeliveryInput deliveryInput) {
		
		        Delivery newDelivery = deliveryMapper.toEntity(deliveryInput);
				Delivery deliveryCreate =  deliveryService.saveDelivery(newDelivery);
		return deliveryMapper.toModel(deliveryCreate);
	}
	 */
	
	
	
	//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public Delivery addDelivery(@Valid @RequestBody Delivery delivery) {
//		
//		return deliveryService.saveDelivery(delivery);
//		
//	}
//	
	
	
	
//	@GetMapping("/{deliveryId}")
//	public ResponseEntity<Delivery> search(@PathVariable Long deliveryId) {
//		
//		return deliveryRepository.findById(deliveryId)
//				.map(ResponseEntity::ok)
//				.orElse(ResponseEntity.notFound().build());
//		
//	}
	

	//We create this method to get all values of Delivery class to DeliveryDtoModel 
	// to reduce the dates to our REST_API
	@GetMapping("/{deliveryId}")
	public ResponseEntity<DeliveryDtoModel> search(@PathVariable Long deliveryId) {
		
		return deliveryRepository.findById(deliveryId) 
				.map( delivery -> ResponseEntity.ok(deliveryMapper.toModel(delivery)))
				.orElse(ResponseEntity.notFound().build());
	}

}
