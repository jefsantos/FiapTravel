package com.FiapTravel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Endereco {


	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String logradouro;
	private String cep;
	private String cidade;
	private String estado;
	
	@ManyToOne
	 @JoinColumn(name = "localidade_id")
	private Localidade localidade;
	
}
