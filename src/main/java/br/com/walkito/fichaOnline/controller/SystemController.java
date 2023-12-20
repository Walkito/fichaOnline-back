package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.entities.System;
import br.com.walkito.fichaOnline.service.SystemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/system")
public class SystemController {
    @Autowired
    SystemService service;

    @GetMapping(path = "/systems")
    public ResponseEntity<Object> getSystems(){
        return service.getSystems();
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createSystems(@RequestBody @Valid System system){
        return service.createSystem(system);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Object> editSystem(@RequestBody @Valid System system){
        return service.editSystem(system);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Object> deleteSystem(@RequestParam("idSystem") int idSystem){
        return service.deleteSystem(idSystem);
    }

}
