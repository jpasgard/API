package br.com.hdsgroup.handsy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    @Column(unique = true)
    private String email;
    @OneToMany(fetch = FetchType.EAGER)
    private List<NodeEntity> nodes;
    @JsonIgnore
    private String senha;

    public UserEntity() {

    }

    public UserEntity(Integer id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
