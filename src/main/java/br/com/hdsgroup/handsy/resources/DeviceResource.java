package br.com.hdsgroup.handsy.resources;

import br.com.hdsgroup.handsy.entities.DeviceEntity;
import br.com.hdsgroup.handsy.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/device")
public class DeviceResource {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResponseEntity<DeviceEntity> editDevice(@Valid @RequestBody DeviceEntity deviceEntity) throws Exception {
        return ResponseEntity.ok(deviceService.saveDevice(deviceEntity));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DeviceEntity> find(@PathVariable Integer id) {
        DeviceEntity deviceEntity = deviceService.getById(id).get();
        return ResponseEntity.ok().body(deviceEntity);
    }
}
