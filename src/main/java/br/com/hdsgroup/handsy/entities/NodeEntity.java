package br.com.hdsgroup.handsy.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NodeEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	private Integer id;
}
