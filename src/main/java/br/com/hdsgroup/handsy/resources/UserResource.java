package br.com.hdsgroup.handsy.resources;

import br.com.hdsgroup.handsy.dto.JwtRequestDTO;
import br.com.hdsgroup.handsy.dto.JwtResponseDTO;
import br.com.hdsgroup.handsy.entities.NodeEntity;
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
    
    @RequestMapping(value = "busca/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<NodeEntity>> findListaNodeId(@PathVariable Integer id) {
        List<NodeEntity> nodeEntity = userService.getById(id).getNodes();
        return ResponseEntity.ok().body(nodeEntity);
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
    
    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    public ResponseEntity<List<NodeEntity>> findNomeListaNode(@RequestParam(value="value") String nome) {
        List<NodeEntity> nodeEntity = userService.getByNome(nome).getNodes();
        return ResponseEntity.ok().body(nodeEntity);
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
