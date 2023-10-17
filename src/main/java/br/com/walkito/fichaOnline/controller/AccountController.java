package br.com.walkito.fichaOnline.controller;

import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.model.exception.ExceptionsCustomizadas;
import br.com.walkito.fichaOnline.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/account")
public class AccountController {
    @Autowired
    AccountService service;

    @GetMapping(path = "/login")
    public Account doLogin(@RequestParam(name = "user") String user,
                         @RequestParam(name = "email") String email,
                         @RequestParam(name = "password") String password)
                        throws ExceptionsCustomizadas{
        return service.doLogin(user,email,password);
    }

    @PostMapping(path = "/login/create")
    public Account createAccount(/*@RequestBody*/ @Valid Account account) throws ExceptionsCustomizadas {
        return service.createAccount(account);
    }

    @PutMapping(path = "/login/edit")
    public Account editAccount(/*@RequestBody*/ @Valid Account account) throws ExceptionsCustomizadas {
        return service.editAccount(account);
    }


}
