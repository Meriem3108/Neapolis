package com.orbit.security.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orbit.security.Entities.Produit;
import com.orbit.security.token.Token;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import lombok.*;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {


 // @GeneratedValue

 // @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "_user_seq") // Specify the generator name here
 // @SequenceGenerator(name = "_user_seq", sequenceName = "_user_seq", allocationSize = 1)

  @Id
  @GeneratedValue
  private Integer id;
  private String firstname;
  private String lastname;
  private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(mappedBy = "user")
  private List<Token> tokens;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @OneToMany(cascade = CascadeType.ALL,mappedBy="user")
  @JsonIgnore
  @ToString.Exclude
  private Set<Produit> produits;
}
