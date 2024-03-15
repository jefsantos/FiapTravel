package com.FiapTravel.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class Localidade {

	@Id
	private UUID idLocalidade;
	private String nomeLocalidade;
	private String logradouroLocalidade;
	private String codigoPostalLocalidade;
	private String cidadeLocalidade;
	private String bairroLocalidade;
	private String ufLocalidade;
	@ManyToOne
	@JoinColumn(name = "id_empreendimento")
	private Empreendimento empreendimento;

}
