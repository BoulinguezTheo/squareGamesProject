package com.example.squaregamesspring.dto;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@Entity
@Table(name="users")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue
    private int id;
    String username;
    String password;
    boolean accountExpire = false;
    boolean accountLock = false;
    boolean credentialExpired = false;
    boolean enable = true;
    @ElementCollection(fetch = FetchType.EAGER)
    List<String> authorities;

    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserEntity(String username, String password, boolean accountExpire, boolean accountLock, boolean credentialExpired, boolean enable, List<String> authorities) {
        this.username = username;
        this.password = password;
        this.accountExpire = accountExpire;
        this.accountLock = accountLock;
        this.credentialExpired = credentialExpired;
        this.enable = enable;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream().map(s -> (GrantedAuthority) () -> s).collect(Collectors.toList());
    }
    public void addAuthorities(String authorities){ this.authorities.add(authorities); }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountExpire;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountLock;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }
}
