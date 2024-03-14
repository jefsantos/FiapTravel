package com.FiapTravel.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class ItemQuartoId implements Serializable {

    private UUID idItem;
    private UUID idQuarto;
}
