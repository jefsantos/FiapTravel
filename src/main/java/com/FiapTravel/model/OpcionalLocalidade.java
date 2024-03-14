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
public class OpcionalLocalidade {
    @EmbeddedId
    private OpcionalLocalidadeId id;

    @ManyToOne
    @MapsId("idLocalidade")
    @JoinColumn(name = "id_localidade")
    private Localidade localidade;

    @ManyToOne
    @MapsId("idOpcional")
    @JoinColumn(name = "id_opcional")
    private Opcional opcional;

    private BigDecimal valorOpcional;
}
