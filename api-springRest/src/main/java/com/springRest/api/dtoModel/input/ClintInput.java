package com.springRest.api.dtoModel.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClintInput {


	@NotNull
     private Long id;
}
