package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.entities.System;
import br.com.walkito.fichaOnline.service.SystemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/system")
public class SystemController {
    @Autowired
    SystemService service;

    @GetMapping(path = "/systems")
    public List<System> getSystems(){
        return service.getSystems();
    }

    @PostMapping(path = "/create")
    public System createSystems(/*@RequestBody*/ @Valid System system){
        return service.createSystem(system);
    }

    @PutMapping(path = "/edit")
    public System editSystem(/*@RequestBody*/ @Valid System system){
        return service.editSystem(system);
    }
}
