package br.com.hdsgroup.handsy.config;

import br.com.hdsgroup.handsy.entities.DeviceEntity;
import br.com.hdsgroup.handsy.entities.UserEntity;
import br.com.hdsgroup.handsy.repositories.DeviceRepository;
import br.com.hdsgroup.handsy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    public void instanteTesteDatabase() {
    	
        UserEntity userEntity01 = new UserEntity(null, "José", "jose@gmail.com", bCryptPasswordEncoder.encode("123"));
        UserEntity userEntity02 = new UserEntity(null, "Maria", "maria@gmail.com", bCryptPasswordEncoder.encode("123"));
        
        userEntity01.setDevices(new ArrayList<DeviceEntity>());
        userEntity02.setDevices(new ArrayList<DeviceEntity>());
        
        DeviceEntity deviceEntity01 = new DeviceEntity(null, false, "Quarto");
        DeviceEntity deviceEntity02 = new DeviceEntity(null, false, "Cozinha");
        
        DeviceEntity deviceEntity03 = new DeviceEntity(null, true, "Garagem");
        DeviceEntity deviceEntity04 = new DeviceEntity(null, true, "Sala");
        
        userEntity01.getDevices().addAll(Arrays.asList(deviceEntity01, deviceEntity02));
        
        userEntity02.getDevices().addAll(Arrays.asList(deviceEntity03, deviceEntity04));
        
        deviceRepository.saveAll(Arrays.asList(deviceEntity01, deviceEntity02, deviceEntity03, deviceEntity04));
        
        userRepository.saveAll(Arrays.asList(userEntity01, userEntity02));
    }
}
