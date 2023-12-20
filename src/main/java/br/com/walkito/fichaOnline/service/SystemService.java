package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.model.entities.Run;
import br.com.walkito.fichaOnline.model.entities.System;
import br.com.walkito.fichaOnline.model.repository.SystemRepository;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> createSystem(System system){
        try {
            return new ResponseEntity<>(repository.save(system), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
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
                return new ResponseEntity<>(repository.save(actualSystem), HttpStatus.OK);
            }
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> deleteSystem(int idSystem){
        try{
            System system = repository.searchById(idSystem);
            if(system.getId() < 1 ){
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Não foi possível excluir o sistema.",
                        "O sistema não foi encontrado, o id passado não é válido.");
            }
            if(!system.getRuns().isEmpty()){
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Existem Runs vinculadas a esse sistema, não foi possível excluir",
                        "Não é possivel excluir um sistema que tem runs vinculadas, pelo bem da consistência de dados.");
            }
            repository.delete(system);
            return new ResponseEntity<>("Sistema excluído com sucesso!", HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }
}
