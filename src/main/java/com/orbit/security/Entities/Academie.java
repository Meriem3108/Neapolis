package com.orbit.security.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.security.PrivateKey;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Academie extends Produit {
    private Integer duree;
    @Enumerated(EnumType.STRING)

    private Niveau niveau;
    @OneToMany
    @ToString.Exclude
    @JsonIgnore
    private List<Section> sections;
}
