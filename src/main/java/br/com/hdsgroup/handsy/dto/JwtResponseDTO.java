package br.com.hdsgroup.handsy.dto;

import lombok.Data;

@Data
public class JwtResponseDTO {
    private String token;
    private String email;

    public JwtResponseDTO() {
    }

    public JwtResponseDTO(String token, String email) {
        this.token = token;
        this.email = email;
    }
}
