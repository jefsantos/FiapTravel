package com.FiapTravel.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Localidade {

	@Id
	private UUID idLocalidade;
	private String nomeLocalidade;

}
