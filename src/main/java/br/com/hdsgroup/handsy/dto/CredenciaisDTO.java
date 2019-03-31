package br.com.hdsgroup.handsy.dto;

import lombok.Data;

@Data
public class CredenciaisDTO {

    private Integer id;
    private String email;
    private String senha;

    public CredenciaisDTO() {

    }

    public CredenciaisDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}
