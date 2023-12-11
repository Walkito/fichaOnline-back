package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.model.dtos.LinkRunAccountDTO;
import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.model.entities.Run;
import br.com.walkito.fichaOnline.model.repository.AccountRepository;
import br.com.walkito.fichaOnline.model.repository.RunRepository;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunService {
    @Autowired
    RunRepository repository;

    @Autowired
    AccountRepository accountRepository;

    public ResponseEntity<Object> getRuns(){
        try {
            if(repository.findAll().isEmpty()){
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Runs não encontradas", "Não existem Runs Cadastradas.");
            } else {
                return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
            }
        } catch (Exception e){
            throw e;
        }
    }

    public ResponseEntity<Object> registerRun(Run run){
        try{
            return new ResponseEntity<>(repository.save(run), HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }

    public ResponseEntity<Object> editRun(Run run){
        try{
            Run actualRun = repository.searchById(run.getId());
            BeanUtils.copyProperties(run, actualRun, "accountRuns");
            repository.save(actualRun);
            return new ResponseEntity<>(actualRun, HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }

    public ResponseEntity<Object> linkAccount(LinkRunAccountDTO lra){
        try{
            Run run = repository.searchById(lra.getIdRun());
            Account account = accountRepository.searchById(lra.getIdAccount());
            run.setAccounts(account);
            return new ResponseEntity<>(run.getAccounts(), HttpStatus.OK);
        } catch(Exception e){
            throw e;
        }
    }
}
