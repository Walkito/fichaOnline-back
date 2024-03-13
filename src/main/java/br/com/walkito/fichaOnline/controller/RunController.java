package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.dtos.RunAccountDTO;
import br.com.walkito.fichaOnline.model.entities.Run;
import br.com.walkito.fichaOnline.service.RunService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/run")
public class RunController {
    @Autowired
    RunService service;

    @GetMapping(path = "/runs")
    public ResponseEntity<Object> getRuns() {
        return service.getRuns();
    }

    @GetMapping(path = "/runsFiltered")
    public ResponseEntity<Object> getRunsFiltered(@RequestParam(value = "filter") List<String> status,
                                                  @RequestParam(value = "accountID") int accountID) {
        return service.getRunsFiltered(status, accountID);
    }

    @GetMapping(path = "/linkedAccounts")
    public ResponseEntity<Object> getLinkedAccounts(@RequestParam(value = "idRun", defaultValue = "0")
                                                    int idRun) {
        return service.getLinkedAccounts(idRun);
    }

    @GetMapping(path = "/getMaster")
    public ResponseEntity<Object> getMasterName(@RequestParam(value = "id") int id) {
        return service.getMasterRun(id);
    }

    @GetMapping(path = "/masterRuns")
    public ResponseEntity<Object> getMasterRuns(@RequestParam(value = "id") int id) {
        return service.getMasterRuns(id);
    }

    @GetMapping
    public ResponseEntity<Object> getRun(@RequestParam(value = "id") int id) {
        return service.getRun(id);
    }

    @PostMapping(path = "/register")
    @ResponseBody
    public ResponseEntity<Object> registerRun(@RequestBody @Valid Run run) {
        return service.registerRun(run);
    }

    @PostMapping(path = "/linkAccount")
    public ResponseEntity<Object> linkAccount(@RequestBody @Valid RunAccountDTO lra) {
        return service.linkAccount(lra);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Object> editRun(@RequestBody @Valid Run run) {
        return service.editRun(run);
    }

    @DeleteMapping(path = "/unlinkAccount")
    public ResponseEntity<Object> unlinkAccount(@RequestParam(value = "idRun") int idRun,
                                                @RequestParam(value = "idAccount") int idAccount) {
        return service.unlinkAccount(idRun, idAccount);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Object> deleteRun(@RequestParam("idRun") int idRun) {
        return service.deleteRun(idRun);
    }
}
