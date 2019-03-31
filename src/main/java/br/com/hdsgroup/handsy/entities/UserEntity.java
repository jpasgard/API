package br.com.hdsgroup.handsy.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Data
public class UserEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	@Email
	private String email;
	private String nome;
	@OneToMany
	private List<NodeEntity> nodes;
}
