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
public class AmenidadeLocalidade {
    @EmbeddedId
    private AmenidadeLocalidadeId id;

    @ManyToOne
    @MapsId("idLocalidade")
    @JoinColumn(name = "id_localidade")
    private Localidade localidade;

    @ManyToOne
    @MapsId("idAmenidade")
    @JoinColumn(name = "id_amenidade")
    private AmenidadeLocalidade amenidadeLocalidade;

    private int quantidade;
}
