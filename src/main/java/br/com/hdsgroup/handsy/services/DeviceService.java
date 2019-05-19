package br.com.hdsgroup.handsy.services;

import br.com.hdsgroup.handsy.entities.DeviceEntity;
import br.com.hdsgroup.handsy.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public DeviceEntity saveDevice(DeviceEntity deviceEntity){
        return deviceRepository.save(deviceEntity);
    }

    public Optional<DeviceEntity> getById(Integer id) {
        return deviceRepository.findById(id);
    }
}
