package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.service.exception.GenericException;
import br.com.walkito.fichaOnline.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/account")
public class AccountController {
    @Autowired
    AccountService service;

    @GetMapping(path = "/login")
    public ResponseEntity<Object> doLogin(@RequestParam(name = "user") String user,
                                          @RequestParam(name = "email") String email,
                                          @RequestParam(name = "password") String password){
        return service.doLogin(user,email,password);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createAccount(@RequestBody @Valid Account account){
        return service.createAccount(account);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Object> editAccount(@RequestBody @Valid Account account){
        return service.editAccount(account);
    }
}
