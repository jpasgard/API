package br.com.hdsgroup.handsy.repositories;

import br.com.hdsgroup.handsy.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	UserEntity findByNome(String nome);
    UserEntity findByEmail(String email);

}
