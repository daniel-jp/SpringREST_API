package com.springRest.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.api.dtoModel.OccurrenceModel;
import com.springRest.api.dtoModel.input.OccurrenceInput;
import com.springRest.api.mapper.OccurerenceMapper;
import com.springRest.api.model.Delivery;
import com.springRest.api.model.Occurrence;
import com.springRest.api.service.OccurrenceService;
import com.springRest.api.service.SearchDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries/{deliveryId}/occurrences")
public class OccurrenceController {
	
	private  OccurrenceService occurrenceService;
	private OccurerenceMapper occurerenceMapper;
	private SearchDeliveryService searchDeliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OccurrenceModel createOccurrence(@PathVariable Long deliveryId,
			@Valid @RequestBody OccurrenceInput occurrenceInput) {
		
				Occurrence occurrence = 	occurrenceService
						.createOccurrence(deliveryId, occurrenceInput.getDescription());
				
				return occurerenceMapper.toModel(occurrence);
		
		
		
	}
	
	@GetMapping
	public List<OccurrenceModel> list(@PathVariable Long deliveryId) {
		Delivery delivery = searchDeliveryService.searchOccurrence(deliveryId);
		
		return occurerenceMapper.toCollectionModel(delivery.getOccurrences());
	}

}
