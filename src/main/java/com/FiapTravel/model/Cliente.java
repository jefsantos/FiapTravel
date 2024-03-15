package com.FiapTravel.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class Cliente {

	@Id
	private UUID id;

	@OneToOne
	@MapsId
	private User user;

	private String paisOrigemCliente;
	private String cpfCliente;
	private String passaporteCliente;
	private String nomeCliente;
	private String dataNascimentoCliente;
	private String logradouroEnderecoCliente;
	private String codigoPostalEnderecoCliente;
	private String cidadeEnderecoCliente;
	private String bairroEnderecoCliente;
	private String ufEnderecoCliente;
}
