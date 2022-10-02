package com.springRest.api.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.springRest.api.validroups.ValidationGroups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Occurrence {
	
	// Essa classe tem relacao com @ManyToOne com a classe Delivery
	
	
	@NotNull(groups = ValidationGroups.ClientId.class)
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Delivery delivery;
	private String description;
	private OffsetDateTime createDate;
	
	
}
