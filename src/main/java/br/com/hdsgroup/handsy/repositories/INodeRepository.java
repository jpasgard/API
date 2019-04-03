package br.com.hdsgroup.handsy.repositories;

import br.com.hdsgroup.handsy.entities.NodeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INodeRepository extends JpaRepository<NodeEntity, Integer> {
    
}
