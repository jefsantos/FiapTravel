package com.FiapTravel.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class OpcionalReservaId implements Serializable {
    private UUID idLocalidade;
    private UUID idReserva;
    private UUID idOpcional;
}
