package br.com.hdsgroup.handsy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.hdsgroup.handsy.entities.UserEntity;
import br.com.hdsgroup.handsy.repositories.IUserRepository;

public class UserService {
	
	@Autowired
	private IUserRepository repositorio;
	
	public Optional<UserEntity> find(Integer id) {
		return repositorio.findById(id);
	}
}
