package com.FiapTravel.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class QuartoReservaId implements Serializable {
    private UUID idQuarto;
    private UUID idReserva;
}
