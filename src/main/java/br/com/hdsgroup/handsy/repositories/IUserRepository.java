package br.com.hdsgroup.handsy.repositories;

import br.com.hdsgroup.handsy.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    public UserEntity findByEmail(String email);
}
