package br.com.hdsgroup.handsy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hdsgroup.handsy.entities.NodeEntity;

public interface INodeRepository extends JpaRepository<NodeEntity, Integer>{
}
