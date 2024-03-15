package com.FiapTravel.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class OpcionalReserva {
    @EmbeddedId
    private OpcionalReservaId id;

    @ManyToOne
    @MapsId("idLocalidade")
    @JoinColumn(name = "id_localidade")
    private Localidade localidade;

    @ManyToOne
    @MapsId("idReserva")
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @ManyToOne
    @MapsId("idOpcional")
    @JoinColumn(name = "id_opcional")
    private Opcional opcional;

    private int quantidade;
}
