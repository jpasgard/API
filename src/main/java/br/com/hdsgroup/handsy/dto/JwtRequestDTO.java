package br.com.hdsgroup.handsy.dto;

import lombok.Data;

@Data
public class JwtRequestDTO {
    private String email;
    private String senha;
    
    public String getEmail() {
    	return this.email;
    }
    
    public String getSenha() {
    	return this.senha;
    }
    
}
