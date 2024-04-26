package br.com.walkito.fichaOnline.service.security;

import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.model.repositorys.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> account = repository.searchByUser(username);
        if(account.isPresent()){
            return account.get();
        } else {
            throw new UsernameNotFoundException("Usuário/Senha incorretos");
        }
    }
}
