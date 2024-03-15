package com.FiapTravel.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idReserva;
    private String dataEntradaReserva;
    private String dataSaidaReserva;
    private String quantidadePessoasRererva;
    private BigDecimal valorTotalReserva;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

}
