package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.entities.Npc;
import br.com.walkito.fichaOnline.service.NpcService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/npc")
public class NpcController {
    @Autowired
    NpcService service;

    @GetMapping(path = "/npcs")
    public ResponseEntity<Object> getNpcs(@RequestParam(value = "runId") int runId){
        return service.getNpcs(runId);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Object> addNpc(@RequestBody @Valid Npc npc){
        return service.addNpc(npc);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Object> editNpc(@RequestBody @Valid Npc npc){
        return service.editNpc(npc);
    }
}
