package com.springRest.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Data
@Embeddable //Means that we can use this class wherever we want
public class Recipient {
	
// Esta classe, nao e registrado na base de dados, mais podemos usar os seus dados
// sustentando a tabela Delivery. A classe est registrado na base de dados caso usarmos anotacao @Entity
// Tem relacao de inclusao com Delivery
	
	@NotBlank
	@Column(name = "recipientName")
	private String  name;
	@NotBlank
	@Column(name = "recipientStreet")
	private String street;
	@NotBlank
	@Column(name = "recipientNomber")
	private String number;
	@NotBlank
	@Column(name = "recipientApartment")
	private String  apartment;
	@NotBlank
	@Column(name = "recipientDistrict")
	private String district;

}
