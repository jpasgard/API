package br.com.hdsgroup.handsy.config.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Service
public class UserSS implements UserDetails { // Usuário especifico do spring security

    private Integer id;
    private String email;
    private String senha;
    private Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

    public UserSS() {
    }

    public UserSS(Integer id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        authorities.add(new SimpleGrantedAuthority("ROLE_CLIENTE"));
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
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
}