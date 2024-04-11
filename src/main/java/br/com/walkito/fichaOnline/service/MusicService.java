package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.model.dtos.MusicDTO;
import br.com.walkito.fichaOnline.model.entities.Music;
import br.com.walkito.fichaOnline.model.repositorys.MusicRepository;
import br.com.walkito.fichaOnline.model.repositorys.RunRepository;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Optional;

@Service
public class MusicService {

    @Autowired
    private MusicRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<Object> registerMusic(MusicDTO musicDTO){
        try{
            Music music = convertDTO(musicDTO);
            return new ResponseEntity<>(repository.save(music), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> deleteMusic(int id){
        try{
            Optional<Music> music = repository.findById(id);
            if(music.isEmpty()){
                return new ResponseEntity<>(false, HttpStatus.OK);
            } else {
                repository.delete(music.get());
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    private Music convertDTO(MusicDTO musicDTO){
        return modelMapper.map(musicDTO, Music.class);
    }
}
