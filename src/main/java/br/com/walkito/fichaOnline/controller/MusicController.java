package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.dtos.MusicDTO;
import br.com.walkito.fichaOnline.model.entities.Music;
import br.com.walkito.fichaOnline.service.MusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/musics")
public class MusicController {

    @Autowired
    MusicService service;

    @PostMapping(path = "/register")
    public ResponseEntity<Object> registerMusic(@RequestBody @Valid MusicDTO musicDTO){
        return service.registerMusic(musicDTO);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Object> deleteMusic(@RequestParam(name = "id") int id){
        return service.deleteMusic(id);
    }
}
