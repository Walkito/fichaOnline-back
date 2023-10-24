package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.entities.AccountRun;
import br.com.walkito.fichaOnline.service.AccountRunService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/accounts/linked/run")
public class AccountRunController {
    @Autowired
    AccountRunService service;

    @GetMapping(path = "/linkeds")
    public ResponseEntity<Object> getAccountsLinkedRun(@RequestParam(name = "id") int accountId){
        return service.getAccountRuns(accountId);
    }

    @PostMapping(path = "/link")
    public ResponseEntity<Object> linkAccountRun(/*@RequestBody*/ @Valid AccountRun accountRun){
        return service.linkAccountRun(accountRun);
    }

    @PutMapping(path = "/edit/links")
    public ResponseEntity<Object> editLinks(/*@RequestBody*/ @Valid List<AccountRun> accountsRuns){
        return service.editLinks(accountsRuns);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Object> deleteLink(@RequestParam(name = "accountId") int accountId,
                           @RequestParam(name = "runId")int runId){
        return service.deleteLink(accountId, runId);
    }
}
