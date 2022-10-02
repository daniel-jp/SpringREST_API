package com.springRest.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.springRest.api.dtoModel.DeliveryDtoModel;
import com.springRest.api.dtoModel.input.DeliveryInput;
import com.springRest.api.model.Delivery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeliveryMapper {

	private ModelMapper modelMapper;
	
	// Converter de DTo model para Entidade
	public DeliveryDtoModel toModel( Delivery delivery) {
		
		return modelMapper.map( delivery, DeliveryDtoModel.class);
	}
	
	public List<DeliveryDtoModel> toCollectionModel(List<Delivery> deliveries){
		
		return deliveries.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	// Converter de Entidade para DTo model
	public Delivery toEntity(DeliveryInput deliveryInput) {
		return modelMapper.map(deliveryInput, Delivery.class);
  }
}