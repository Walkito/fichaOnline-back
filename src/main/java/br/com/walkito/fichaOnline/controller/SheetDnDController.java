package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import br.com.walkito.fichaOnline.service.sheets.SheetDnDService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/sheetDnD")
public class SheetDnDController {

    @Autowired
    SheetDnDService service;

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createSheet(@RequestBody @Valid SheetDnD sheetDnD){
        return service.createSheet(sheetDnD);
    }
}
