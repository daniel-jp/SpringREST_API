package com.springRest.api.dtoModel;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.springRest.api.model.StatusDelivery;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DeliveryDtoModel {

	private Long id;
	
	// Na classe cliente podemos mencionar aqui os campos como exp:
	/*
	 * private Long clientId; private String clientName; private String clientEmail;
	 */
	//Ou criar um objeto ao criarmos uma nova class
	private ClientMapper client;
	private RecipientDTO recipient;
	private BigDecimal rate;
	private StatusDelivery statusDelivery;
	private OffsetDateTime orderDate;
	private OffsetDateTime endDate;
	
	
}
