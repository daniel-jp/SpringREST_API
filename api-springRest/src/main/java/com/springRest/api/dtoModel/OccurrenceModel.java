package com.springRest.api.dtoModel;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OccurrenceModel {
	private Long id;
	private String description;
	private OffsetDateTime createDate;
}
