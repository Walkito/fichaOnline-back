package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.model.entities.System;
import br.com.walkito.fichaOnline.model.repository.SystemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemService {
    @Autowired
    SystemRepository repository;

    public List<System> getSystems(){
        try{
            return repository.findAll();
        } catch (Exception e){
            throw e;
        }
    }

    public System createSystem(System system){
        try {
            return repository.save(system);
        } catch (Exception e){
            throw e;
        }
    }

    public System editSystem(System system){
        try {
            System actualSystem = repository.searchById(system.getId());
            BeanUtils.copyProperties(system, actualSystem, "runs");
            return repository.save(actualSystem);
        } catch (Exception e){
            throw e;
        }
    }
}
