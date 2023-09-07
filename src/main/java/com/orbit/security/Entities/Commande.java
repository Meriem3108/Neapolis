package com.orbit.security.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orbit.security.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  float somme;

    @OneToOne
    @ToString.Exclude
    @JsonIgnore
    Panier panier;
    @OneToOne
    @ToString.Exclude
    @JsonIgnore
    Facture facture;
}
