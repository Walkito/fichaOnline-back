package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.dtos.RunAccountDTO;
import br.com.walkito.fichaOnline.model.entities.PlayerSheet;
import br.com.walkito.fichaOnline.service.PlayerSheetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/playerSheet")
public class PlayerSheetController {

    @Autowired
    PlayerSheetService service;

    @GetMapping(path = "/get")
    public ResponseEntity<Object> getSheets(@RequestParam(value = "idAccount", defaultValue = "0") int idAccount,
                                            @RequestParam(value = "idRun", defaultValue = "0") int idRun){
        return service.getSheets(idAccount, idRun);
    }

    @PostMapping(path = "/linkSheet")
    public ResponseEntity<Object> linkSheet(@RequestBody PlayerSheet sheet){
        return service.linkSheet(sheet);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Object> editSheet(@RequestBody PlayerSheet sheet){
        return service.editSheet(sheet);
    }
}
