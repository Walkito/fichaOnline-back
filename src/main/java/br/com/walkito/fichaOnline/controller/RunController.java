package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.dtos.RunAccountDTO;
import br.com.walkito.fichaOnline.model.entities.Run;
import br.com.walkito.fichaOnline.service.RunService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/run")
public class RunController {
    @Autowired
    RunService service;

    @GetMapping(path = "/runs")
    public ResponseEntity<Object> getRuns(){
        return service.getRuns();
    }

    @GetMapping(path = "/linkedAccounts")
    public ResponseEntity<Object> getLinkedAccounts(@RequestParam(value = "idRun", defaultValue = "0")
                                                int idRun){
        return service.getLinkedAccounts(idRun);
    }

    @PostMapping(path = "/register")
    @ResponseBody
    public ResponseEntity<Object> registerRun(@RequestBody @Valid Run run){
        return service.registerRun(run);
    }

    @PostMapping(path = "/linkAccount")
    public ResponseEntity<Object> linkAccount(@RequestBody @Valid RunAccountDTO lra){
        return service.linkAccount(lra);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Object> editRun(@RequestBody @Valid Run run){
        return service.editRun(run);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Object> deleteRun(@RequestParam("idRun") int idRun){
        return service.deleteRun(idRun);
    }
}
