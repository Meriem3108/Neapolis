package com.orbit.security.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orbit.security.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor /*constructeur vide*/
@AllArgsConstructor /*constructeur avec tous les attributs*/
@ToString
@Builder
public class ChatBox implements Serializable {
    @Id
    private Integer id;
    private Integer nombrePartcipants;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="chatBox")
    @JsonIgnore
    @ToString.Exclude
    private List<Chat> chats =new ArrayList<Chat>();
    @ManyToMany
    @JsonIgnore
    @ToString.Exclude
    private List<User> users;
}
