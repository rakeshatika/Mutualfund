package com.vcube.Mutualfund.entity;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    // "ROLE_USER" or "ROLE_ADMIN"
    private String role;

   
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Investment> investments;

    // ── UserDetails ──────────────────────────────────────────────────────────

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() { return password; }

    /** Spring Security uses email as the username. */
    @Override
    public String getUsername() { return email; }

    @Override public boolean isAccountNonExpired()     { return true; }
    @Override public boolean isAccountNonLocked()      { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled()               { return true; }

    // ── Getters & Setters ────────────────────────────────────────────────────

    public Long getId()                            { return id; }
    public void setId(Long id)                     { this.id = id; }

    public String getUsernameValue() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail()                       { return email; }
    public void setEmail(String email)             { this.email = email; }

    public String getPhone()                       { return phone; }
    public void setPhone(String phone)             { this.phone = phone; }

    public String getRole()                        { return role; }
    public void setRole(String role)               { this.role = role; }

    public void setPassword(String password)       { this.password = password; }

    public List<Investment> getInvestments()       { return investments; }
    public void setInvestments(List<Investment> i) { this.investments = i; }
}
