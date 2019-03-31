package br.com.hdsgroup.handsy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hdsgroup.handsy.entities.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer>{
}
