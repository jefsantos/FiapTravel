package com.FiapTravel.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class QuartoReserva {
    @EmbeddedId
    private QuartoReservaId id;

    @ManyToOne
    @MapsId("idQuarto")
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;

    @ManyToOne
    @MapsId("idReserva")
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
}
