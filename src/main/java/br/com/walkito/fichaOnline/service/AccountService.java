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

import java.util.Arrays;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;

    public ResponseEntity<Object> doLogin(String user, String email, String password){
        try{
            Account account = repository.getLogin(user, email, password);
            if (account != null) {
                return new ResponseEntity<>(account,HttpStatus.OK);
            } else {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Usuário/E-mail ou Senha incorretos.","Login não encontrado ");
            }
        }catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> createAccount(Account account){
        try {
            if(!Utils.emailValidator(account.getEmail())){
                return new ExceptionConstructor().responseConstructor(HttpStatus.BAD_REQUEST,
                        "E-mail não é válido",
                        "O E-mail informado não é válido. Por favor, inserir um e-mail válido");
            }
            return new ResponseEntity<>(repository.save(account), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> editAccount(Account account){
        try {
            if(!Utils.emailValidator(account.getEmail())){
                return new ExceptionConstructor().responseConstructor(HttpStatus.BAD_REQUEST,
                        "E-mail não é válido",
                        "O E-mail informado não é válido. Por favor, inserir um e-mail válido");
            }
            Account actualAccount = repository.searchById(account.getId());
            BeanUtils.copyProperties(account, actualAccount, new String[]{"runs","sheets"});
            repository.save(actualAccount);
            return new ResponseEntity<>(actualAccount, HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> getLinkedRuns(int idAccount){
        try{
            Account account = repository.searchById(idAccount);
            if(account.getRuns().isEmpty()){
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Não existem Runs vinculados a essa conta",
                        "Não foi possivel encontrar runs vinculadas com essa conta, a lista retornou vazia!");
            } else {
                return new ResponseEntity<>(account.getRuns(), HttpStatus.OK);
            }
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> deleteAccount(int idAccount){
        try{
            Account account = repository.searchById(idAccount);
            if(account.getId() < 1 || account.getSituation().equals("I")){
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Não foi possível excluir a conta.",
                        "Id passado não existe ou conta já está inativa!");
            }
            if(account.getRuns().isEmpty()){
                repository.delete(account);
            } else {
                account.setSituation("I");
                repository.save(account);
            }
                return new ResponseEntity<>("Conta Excluída com Sucesso!",HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }
}
