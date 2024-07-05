package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.model.entities.Npc;
import br.com.walkito.fichaOnline.model.repositorys.NpcRepository;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NpcService {

    @Autowired
    NpcRepository repository;

    public ResponseEntity<Object> addNpc(Npc npc){
        try{
            repository.save(npc);
            return new ResponseEntity<>(repository.findByRunId(npc.getRun().getId()), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(), e.getLocalizedMessage());
        }
    }
    public ResponseEntity<Object> getNpcs(int runId){
        try{
            return new ResponseEntity<>(repository.findByRunId(runId), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(), e.getLocalizedMessage());
        }
    }

    public ResponseEntity<Object> editNpc(Npc npc){
        try{
            repository.save(npc);
            return new ResponseEntity<>(repository.findByRunId(npc.getRun().getId()), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(), e.getLocalizedMessage());
        }
    }
}
