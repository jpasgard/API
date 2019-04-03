package br.com.hdsgroup.handsy.config;

import br.com.hdsgroup.handsy.entities.NodeEntity;
import br.com.hdsgroup.handsy.entities.UserEntity;
import br.com.hdsgroup.handsy.repositories.INodeRepository;
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
    @Autowired
    private INodeRepository iNodeRepository;

    public void instanteTesteDatabase() {
    	
        UserEntity userEntity01 = new UserEntity(null, "José", "jose@gmail.com", bCryptPasswordEncoder.encode("123"));
        UserEntity userEntity02 = new UserEntity(null, "Maria", "maria@gmail.com", bCryptPasswordEncoder.encode("123"));
        
        NodeEntity nodeEntity01 = new NodeEntity(null, false);
        NodeEntity nodeEntity02 = new NodeEntity(null, false);
        
        NodeEntity nodeEntity03 = new NodeEntity(null, true);
        NodeEntity nodeEntity04 = new NodeEntity(null, true);
        
        userEntity01.getNodes().addAll(Arrays.asList(nodeEntity01, nodeEntity02));
        
        userEntity02.getNodes().addAll(Arrays.asList(nodeEntity03, nodeEntity04));
        
        iNodeRepository.saveAll(Arrays.asList(nodeEntity01, nodeEntity02, nodeEntity03, nodeEntity04));
        
        iUserRepository.saveAll(Arrays.asList(userEntity01, userEntity02));
    }
}
