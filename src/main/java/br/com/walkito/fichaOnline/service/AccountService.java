package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.Utils;
import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.model.exception.ExceptionsCustomizadas;
import br.com.walkito.fichaOnline.model.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;

    public Account doLogin(String user, String email, String password) throws ExceptionsCustomizadas {
        try{
            Account account = repository.getLogin(user, email, password);
            if (account != null) {
                return account;
            } else {
                throw new ExceptionsCustomizadas("Usuário ou Senha incorretos");
            }
        }catch (Exception e){
            throw e;
        }
    }

    public Account createAccount(Account account) throws ExceptionsCustomizadas {
        try {
            if(!Utils.emailValidator(account.getEmail())){
                throw new ExceptionsCustomizadas("E-Mail Inválido");
            }
            return repository.save(account);
        } catch (Exception e){
            throw e;
        }
    }

    public Account editAccount(Account account) throws ExceptionsCustomizadas {
        try {
            if(!Utils.emailValidator(account.getEmail())){
                throw new ExceptionsCustomizadas("E-Mail Inválido");
            }
            Account actualAccount = repository.findByEmail(account.getEmail());
            BeanUtils.copyProperties(account, actualAccount, "accountRuns");
            return repository.save(actualAccount);
        } catch (Exception e){
            throw e;
        }
    }
}
