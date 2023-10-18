package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.model.entities.Run;
import br.com.walkito.fichaOnline.model.repository.RunRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunService {
    @Autowired
    RunRepository repository;

    public List<Run> getRuns(){
        try {
            return repository.findAll();
        } catch (Exception e){
            throw e;
        }
    }

    public Run registerRun(Run run){
        try{
            return repository.save(run);
        } catch (Exception e){
            throw e;
        }
    }

    public Run editRun(Run run){
        try{
            Run actualRun = repository.searchById(run.getId());
            BeanUtils.copyProperties(run, actualRun, "accountRuns");
            return repository.save(actualRun);
        } catch (Exception e){
            throw e;
        }
    }
}
