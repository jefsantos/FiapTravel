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
public class Empreendimento {
    @Id
	private UUID idEmpreendimento;
	private String nomeEmpreendimento;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

}
