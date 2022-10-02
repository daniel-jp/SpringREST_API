package com.springRest.api.dtoModel.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OccurrenceInput {

	@NotBlank
	private String description;
}
