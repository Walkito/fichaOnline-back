package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import br.com.walkito.fichaOnline.service.sheets.SheetDnDService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/sheetDnD")
public class SheetDnDController {

    @Autowired
    SheetDnDService service;

    @GetMapping
    public ResponseEntity<Object> getSheet(@RequestParam("id") int id){
        return service.getSheet(id);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createSheet(@RequestBody @Valid SheetDnD sheetDnD){
        return service.createSheet(sheetDnD);
    }

    @PostMapping(path = "/create/updateAttributes")
    public ResponseEntity<Object> updateAttributesInCreation(@RequestBody SheetDnD sheetDnD){
        return service.updateAttributesInCreation(sheetDnD);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Object> editSheet(@RequestBody @Valid SheetDnD sheetDnD){
        return service.editSheet(sheetDnD);
    }
}
