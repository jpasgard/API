package br.com.hdsgroup.handsy.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class DeviceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String deviceName;
    private Boolean status;
    
    public DeviceEntity() {

    }
    
    public DeviceEntity(Integer id, Boolean status, String deviceName) {
        this.id = id;
        this.status = status;
        this.deviceName = deviceName;
    }
    
}
