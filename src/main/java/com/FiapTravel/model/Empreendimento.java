package com.FiapTravel.model;

import java.util.UUID;

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
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class Empreendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idEmpreendimento;
	private String nomeEmpreendimento;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

}
