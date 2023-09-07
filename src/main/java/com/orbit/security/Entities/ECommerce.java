package com.orbit.security.Entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ECommerce extends Produit{
    private String couleur;
    private Integer stock;
    private String image;
    private Integer garantie;

}
