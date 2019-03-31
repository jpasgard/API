package br.com.hdsgroup.handsy.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.hdsgroup.handsy.entities.UserEntity;
import br.com.hdsgroup.handsy.services.UserService;

public class UserResorce {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserEntity> find(@PathVariable Integer id){
		UserEntity user = service.find(id).get();
		return ResponseEntity.ok().body(user);
	}
}
