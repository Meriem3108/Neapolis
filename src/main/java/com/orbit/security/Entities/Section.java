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
public class Section implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String titre;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    Academie academie;

    @OneToMany
    @ToString.Exclude
    @JsonIgnore
    private List<Video> videos;






}
