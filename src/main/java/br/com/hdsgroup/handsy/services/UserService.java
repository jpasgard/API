package br.com.hdsgroup.handsy.services;

import br.com.hdsgroup.handsy.config.security.JWTUtil;
import br.com.hdsgroup.handsy.config.security.UserSS;
import br.com.hdsgroup.handsy.dto.JwtRequestDTO;
import br.com.hdsgroup.handsy.dto.JwtResponseDTO;
import br.com.hdsgroup.handsy.entities.UserEntity;
import br.com.hdsgroup.handsy.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserEntity getById(Integer id) {
        return iUserRepository.findById(id).get();
    }

    public UserEntity save(UserEntity userEntity) {
        userEntity.setSenha(bCryptPasswordEncoder.encode(userEntity.getSenha()));
        return iUserRepository.save(userEntity);
    }

    public ResponseEntity<JwtResponseDTO> login(JwtRequestDTO jwtRequestDTO) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequestDTO.getEmail(), jwtRequestDTO.getSenha()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = "Bearer " + jwtUtil.generateToken(jwtRequestDTO.getEmail());
        UserSS userSS = (UserSS) auth.getPrincipal();
        return ResponseEntity.ok(new JwtResponseDTO(jwt, userSS.getUsername()));
    }
}

