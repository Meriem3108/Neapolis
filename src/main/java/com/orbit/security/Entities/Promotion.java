package com.orbit.security.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Promotion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private float pourcentage;
    private LocalDateTime debut;
    private LocalDateTime fin;

    @OneToMany
    @ToString.Exclude
    @JsonIgnore
    private List<Produit> produits;




}
