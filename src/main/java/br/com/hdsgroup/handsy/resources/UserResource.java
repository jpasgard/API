package br.com.hdsgroup.handsy.resources;

import br.com.hdsgroup.handsy.dto.JwtRequestDTO;
import br.com.hdsgroup.handsy.dto.JwtResponseDTO;
import br.com.hdsgroup.handsy.entities.DeviceEntity;
import br.com.hdsgroup.handsy.entities.UserEntity;
import br.com.hdsgroup.handsy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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
    
    @RequestMapping(value = "/nome", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> findNome(@RequestParam(value="value") String nome) {
        UserEntity userEntity = userService.getByNome(nome);
        return ResponseEntity.ok().body(userEntity);
    }
    
    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> findEmail(@RequestParam(value="value") String email) {
        UserEntity userEntity = userService.getByEmail(email);
        return ResponseEntity.ok().body(userEntity);
    }
    
    @RequestMapping(value = "/nodes", method = RequestMethod.GET)
    public ResponseEntity<List<DeviceEntity>> findNomeListaNodes(@RequestParam(value="value") String nome) {
        List<DeviceEntity> deviceEntity = userService.getByNome(nome).getDevices();
        return ResponseEntity.ok().body(deviceEntity);
    }
     
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserResource> save(@RequestBody UserEntity userEntity) {
        userEntity = userService.save(userEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userEntity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<JwtResponseDTO> login(@Valid @RequestBody JwtRequestDTO jwtRequestDTO) throws Exception {
        return userService.login(jwtRequestDTO);
    }

    @RequestMapping(value = "/devices/{email}", method = RequestMethod.GET)
    public ResponseEntity<List<DeviceEntity>> findDevicesByEmail(@PathVariable String email) {
        UserEntity userEntity = userService.getByEmail(email);
        return ResponseEntity.ok().body(userEntity.getDevices());
    }
}
