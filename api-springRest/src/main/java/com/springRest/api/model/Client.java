package com.springRest.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.springRest.api.validroups.ValidationGroups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {
	// Tem relacao de inclusao com Delivery

	
	//A validacao nao esta ser feita para Default. O q significa,esta se  validar todos campos ecepto o Client_ID
	@NotNull(groups = ValidationGroups.ClientId.class)
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 60)
	private String name;
	
	@NotBlank
	@Email
	@Size(max = 255)
	private String email;
	@NotBlank
	@Size(max = 20)
	private String phone;
}
