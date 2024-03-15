package com.FiapTravel.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
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
    private Amenidade amenidade;

    private int quantidade;

    @Override
    public String toString() {
        return "AmenidadeLocalidade(id=" + id + ", localidade=" + localidade +
                ", amenidadeLocalidade=null, quantidade=" + quantidade + ")";
    }
}
