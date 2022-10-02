package com.springRest.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.springRest.api.bexception.BusinessExceptions;
import com.springRest.api.validroups.ValidationGroups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Delivery {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	// Sem o Id o Delivery da um erro interno. A validacao da entrega est validada pelo client_id do cliente.
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
	@NotNull
	@ManyToOne
	private Client client;
	@Valid
	@NotNull
	@Embedded // Is for get the Recipient dates on Delivery
	private Recipient recipient;
	@NotNull
	private BigDecimal rate;
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
	private List<Occurrence> occurrences =  new ArrayList<>();
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusDelivery statusDelivery;
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime orderDate;
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime endDate;
	
	
	
	public Occurrence addOccurrence(String description) {
		
		Occurrence occurrence = new Occurrence();
		occurrence.setDescription(description);
		occurrence.setCreateDate(OffsetDateTime.now());
		occurrence.setDelivery(this);
		
		this.getOccurrences().add(occurrence);
		
	return occurrence;
		
	}

	public void finished() {
		if (cannotFinish()) {
			throw new BusinessExceptions("Delivery not finished");
		}
		
		setStatusDelivery(StatusDelivery.FINALIZED);
		setEndDate(OffsetDateTime.now());
		
	}
	
	public boolean canFinish() {
		return StatusDelivery.PENDING.equals(getStatusDelivery());
	}

	public boolean cannotFinish() {
		return !canFinish();
	}

}
