package com.springRest.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.springRest.api.dtoModel.OccurrenceModel;
import com.springRest.api.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OccurerenceMapper {
	private ModelMapper modelMapper;
	
	public OccurrenceModel toModel(Occurrence occurrence){
		return modelMapper.map(occurrence, OccurrenceModel.class);
	}
	
	public List<OccurrenceModel> toCollectionModel(List<Occurrence> occurrences){
		
		return occurrences.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
