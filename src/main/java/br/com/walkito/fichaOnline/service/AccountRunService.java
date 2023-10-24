package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.model.entities.AccountRun;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import br.com.walkito.fichaOnline.model.repository.AccountRunRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountRunService {
    @Autowired
    AccountRunRepository repository;

    public ResponseEntity<Object> getAccountRuns(int accountId){
        try{
            if(repository.findAllByAccountId(accountId) == null){
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Não foram encontradas Runs para esta Conta",
                        "Não existe nenhuma Run vinculada com esta conta");
            } else {
                return new ResponseEntity<>(repository.findAllByAccountId(accountId), HttpStatus.OK);
            }
        } catch (Exception e){
            throw e;
        }
    }

    public ResponseEntity<Object> linkAccountRun(AccountRun accountRun){
        try{
            repository.save(accountRun);
            return new ResponseEntity<>("Conta Vinculada com a Run com sucesso!", HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }

    public ResponseEntity<Object> editLinks(List<AccountRun> accountsRuns){
        try {
            for(AccountRun ar : accountsRuns){
                AccountRun actualAccountRun =
                        repository
                        .findByAccount_IdAndRun_Id(
                            ar.getAccount().getId(),
                            ar.getRun().getId());
                if(actualAccountRun == null){
                    return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                            "Nenhuma conta está vinculada com esta Run",
                            "Não foi possível encontrar nenhuma conta vinculada com esta run");
                } else {
                    BeanUtils.copyProperties(ar, actualAccountRun);
                    repository.save(actualAccountRun);
                }
            }
            return new ResponseEntity<>("Conta Vinculada com a nova Run com sucesso!", HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }

    public ResponseEntity<Object> deleteLink(int accountId, int runId){
        try {
            AccountRun accountRun = repository.findByAccount_IdAndRun_Id(accountId, runId);
            if (accountRun != null){
                return new ResponseEntity<>("Desvinculo realizado com sucesso", HttpStatus.OK);
            } else {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Vinculo não encontrado",
                        "Não foi possível excluir o vinculo, pois não foi encontrado nenhum.");
            }
        } catch (Exception e){
            throw e;
        }
    }
}
