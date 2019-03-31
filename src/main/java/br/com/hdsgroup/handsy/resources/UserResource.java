package br.com.hdsgroup.handsy.resources;

import br.com.hdsgroup.handsy.dto.JwtRequestDTO;
import br.com.hdsgroup.handsy.dto.JwtResponseDTO;
import br.com.hdsgroup.handsy.entities.UserEntity;
import br.com.hdsgroup.handsy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> find(@PathVariable Integer id) {
        UserEntity userEntity = userService.getById(id);
        return ResponseEntity.ok().body(userEntity);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserResource> save(@PathVariable UserEntity userEntity) {
        userEntity = userService.save(userEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userEntity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<JwtResponseDTO> login(@Valid @RequestBody JwtRequestDTO jwtRequestDTO) throws Exception {
        return userService.login(jwtRequestDTO);
    }
}
