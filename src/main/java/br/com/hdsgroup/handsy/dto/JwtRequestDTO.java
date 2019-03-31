package br.com.hdsgroup.handsy.dto;

import lombok.Data;

@Data
public class JwtRequestDTO {
    private String email;
    private String senha;
}
