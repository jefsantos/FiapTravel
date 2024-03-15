package com.FiapTravel.model;

import java.util.UUID;

import jakarta.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
