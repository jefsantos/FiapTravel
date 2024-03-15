package com.FiapTravel.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idQuarto;
    private String nomeQuarto;
    private int quantidadeLimitePessoas;
    private int quantidadeNoPredio;
    private BigDecimal valorDiaria;
    @ManyToOne
    @JoinColumn(name = "id_tipo_quarto")
    private TipoQuarto tipoQuarto;
    @ManyToOne
    @JoinColumn(name = "id_predio")
    private Predio predio;
}
