package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.Utils;
import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import br.com.walkito.fichaOnline.model.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;

    public ResponseEntity<Object> doLogin(String user, String email, String password){
        try{
            Account account = repository.getLogin(user, email, password);
            if (account != null) {
                return new ResponseEntity<>("Login realizado com sucesso!", HttpStatus.OK);
            } else {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Login não encontrada", "Usuário/E-mail ou Senha incorretos.");
            }
        }catch (Exception e){
            throw e;
        }
    }

    public ResponseEntity<Object> createAccount(Account account){
        try {
            if(!Utils.emailValidator(account.getEmail())){
                return new ExceptionConstructor().responseConstructor(HttpStatus.BAD_REQUEST,
                        "E-mail não é válido",
                        "O E-mail informado não é válido. Por favor, inserir um e-mail válido");
            }
            repository.save(account);
            return new ResponseEntity<>("Conta criada com sucesso!",HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }

    public ResponseEntity<Object> editAccount(Account account){
        try {
            if(!Utils.emailValidator(account.getEmail())){
                return new ExceptionConstructor().responseConstructor(HttpStatus.BAD_REQUEST,
                        "E-mail não é válido",
                        "O E-mail informado não é válido. Por favor, inserir um e-mail válido");
            }
            Account actualAccount = repository.findByEmail(account.getEmail());
            BeanUtils.copyProperties(account, actualAccount, "accountRuns");
            repository.save(actualAccount);
            return new ResponseEntity<>("Conta editada com sucesso!", HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }
}
