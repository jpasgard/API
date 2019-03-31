package br.com.hdsgroup.handsy.config;

import br.com.hdsgroup.handsy.entities.UserEntity;
import br.com.hdsgroup.handsy.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private IUserRepository iUserRepository;

    public void instanteTesteDatabase() {
        UserEntity userEntity01 = new UserEntity(null, "José", "jose@gmail.com", bCryptPasswordEncoder.encode("123"));
        UserEntity userEntity02 = new UserEntity(null, "Maria", "maria@gmail.com", bCryptPasswordEncoder.encode("123"));
        iUserRepository.saveAll(Arrays.asList(userEntity01, userEntity02));
    }
}
