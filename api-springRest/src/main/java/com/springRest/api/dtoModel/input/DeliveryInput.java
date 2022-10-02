package com.springRest.api.dtoModel.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryInput {

	
	@NotNull @Valid
	private ClintInput clientInput;
	@NotNull	@Valid
	private RecipientInput recipientInput;
	@NotNull 
	private BigDecimal rate;
	
	
	
	
	
}
