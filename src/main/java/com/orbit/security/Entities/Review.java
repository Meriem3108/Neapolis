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
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private Integer rating;
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    User user;
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    Produit produit;
}
