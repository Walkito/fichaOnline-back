package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.entities.Run;
import br.com.walkito.fichaOnline.service.RunService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/run")
public class RunController {
    @Autowired
    RunService service;

    @GetMapping(path = "/runs")
    public List<Run> getRuns(){
        return service.getRuns();
    }

    @PostMapping(path = "/register")
    public Run registerRun(/*@RequestBody*/ @Valid Run run){
        return service.registerRun(run);
    }

    @PutMapping(path = "/edit")
    public Run editRun(/*@RequestBody*/ @Valid Run run){
        return service.editRun(run);
    }
}
