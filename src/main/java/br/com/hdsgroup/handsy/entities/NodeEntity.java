package br.com.hdsgroup.handsy.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class NodeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Boolean status;
    
    public NodeEntity() {

    }
    
    public NodeEntity(Integer id, Boolean status) {
        this.id = id;
        this.status = status;
    }
    
}
