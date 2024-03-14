package com.FiapTravel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private UUID idQuarto;
    private String nomeQuarto;
    private int quantidadeLimitePessoas;
    private int quatidadeNoPredio;
    private BigDecimal valorDiaria;
    @ManyToOne
    @JoinColumn(name = "id_tipo_quarto")
    private TipoQuarto tipoQuarto;
    @ManyToOne
    @JoinColumn(name = "id_predio")
    private Predio predio;
}
