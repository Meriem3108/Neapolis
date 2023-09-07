package com.orbit.security.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orbit.security.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;

    @OneToOne
    @ToString.Exclude
    @JsonIgnore
    Commande commande;


}
