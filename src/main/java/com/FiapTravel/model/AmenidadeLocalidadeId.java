package com.FiapTravel.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AmenidadeLocalidadeId implements Serializable {
    private UUID idLocalidade;
    private UUID idAmenidade;

    @Override
    public String toString() {
        return "AmenidadeLocalidadeId(idLocalidade=" + idLocalidade +
                ", idAmenidade=" + idAmenidade + ")";
    }
}