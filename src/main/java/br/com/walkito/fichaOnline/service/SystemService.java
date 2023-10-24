package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.model.entities.System;
import br.com.walkito.fichaOnline.model.repository.SystemRepository;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemService {
    @Autowired
    SystemRepository repository;

    public ResponseEntity<Object> getSystems(){
        try{
            if(repository.findAll().isEmpty()){
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Sistemas não encontrados",
                        "Não foi possível achar os sistemas");
            } else {
                return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
            }
        } catch (Exception e){
            throw e;
        }
    }

    public ResponseEntity<Object> createSystem(System system){
        try {
            repository.save(system);
            return new ResponseEntity<>("Sistema criado com sucesso!", HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }

    public ResponseEntity<Object> editSystem(System system){
        try {
            System actualSystem = repository.searchById(system.getId());
            if (actualSystem == null){
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Sistema não encontrado",
                        "O sistema em questão não foi encontrado, por isso não foi possível realizara  edição.");
            } else {
                BeanUtils.copyProperties(system, actualSystem, "runs");
                repository.save(actualSystem);
                return new ResponseEntity<>("Sistema atualizado com sucesso!", HttpStatus.OK);
            }
        } catch (Exception e){
            throw e;
        }
    }
}
