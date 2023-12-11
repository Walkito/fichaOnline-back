package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.dtos.LinkRunAccountDTO;
import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.model.entities.Run;
import br.com.walkito.fichaOnline.service.RunService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/run")
public class RunController {
    @Autowired
    RunService service;

    @GetMapping(path = "/runs")
    public ResponseEntity<Object> getRuns(){
        return service.getRuns();
    }

    @PostMapping(path = "/register")
    @ResponseBody
    public ResponseEntity<Object> registerRun(@RequestBody @Valid Run run){
        return service.registerRun(run);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Object> editRun(@RequestBody @Valid Run run){
        return service.editRun(run);
    }

    @PostMapping(path = "/linkAccount")
    public ResponseEntity<Object> linkAccount(@RequestBody @Valid LinkRunAccountDTO lra){
        return service.linkAccount(lra);
    }


}
