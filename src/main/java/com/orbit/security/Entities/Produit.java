package com.orbit.security.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orbit.security.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String description;
    private float prix;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    User user;

    @OneToMany
    @ToString.Exclude
    @JsonIgnore
    private List<Review> reviews;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    Promotion promotion;

    @ManyToMany
    @JsonIgnore
    @ToString.Exclude
    private List<Panier> paniers;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    Categorie categorie;
}
