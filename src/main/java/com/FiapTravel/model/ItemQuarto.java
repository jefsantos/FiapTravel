package com.FiapTravel.model;

import jakarta.persistence.*;

import lombok.*;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class ItemQuarto implements Serializable {

    @EmbeddedId
    private ItemQuartoId id;

    @ManyToOne
    @MapsId("idQuarto")
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;

    @ManyToOne
    @MapsId("idItem")
    @JoinColumn(name = "id_item")
    private Item item;

    private int quantidade;
}
