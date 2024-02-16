package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.dtos.ImageDTO;
import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import br.com.walkito.fichaOnline.service.FileService;
import br.com.walkito.fichaOnline.service.sheets.SheetDnDService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/sheetDnD")
public class SheetDnDController {

    @Autowired
    SheetDnDService service;

    @Autowired
    FileService fileService;

    @GetMapping
    public ResponseEntity<Object> getSheet(@RequestParam("id") int id){
        return service.getSheet(id);
    }

    @GetMapping(path = "/sheets")
    public ResponseEntity<Object> getSheets(@RequestParam("ids") List<Integer> ids){
        return service.getSheets(ids);
    }

    @GetMapping(path = "/characterPicture")
    public ResponseEntity<Object> getCharacterPicture(@RequestParam("id") int id){
        String fileName = service.getPictureName(id);
        return fileService.downloadFile("sheets/dnd5e", fileName);
    }

    @PostMapping(path = "/uploadCharacterPicture")
    public ResponseEntity<Object> uploadCharacterPicture(@RequestBody ImageDTO image){
        String olderFileName = service.saveFileName(image);
        return fileService.uploadFile(olderFileName, "sheets/dnd5e", image);
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
