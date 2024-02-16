package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.Utils;
import br.com.walkito.fichaOnline.config.S3Config;
import br.com.walkito.fichaOnline.model.dtos.AccountDTO;
import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.model.entities.Run;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import br.com.walkito.fichaOnline.model.repositorys.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public ResponseEntity<Object> doLogin(String user, String email, String password) {
        try {
            Account account = repository.getLogin(user, email, password);
            if (account != null && account.getSituation().equals("I")) {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "A Conta está Inativa.", "Não foi possível fazer o login pois a conta está inativa");
            }
            if (account != null) {
                return new ResponseEntity<>(convertDTO(account), HttpStatus.OK);
            } else {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Usuário/E-mail ou Senha incorretos.", "Login não encontrado ");
            }
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> getAccountInfos(int id) {
        try {
            Optional<Account> account = repository.findById(id);
            if (account.isPresent()) {
                return new ResponseEntity<>(convertDTO(account.get()), HttpStatus.OK);
            } else {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Conta não encontrada.",
                        "Conta não foi encontrada com o ID passado.");
            }
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> getAccountInfosByUser(String user) {
        try {
            Optional<Account> account = repository.findByUser(user);
            if (account.isPresent()) {
                return new ResponseEntity<>(convertDTO(account.get()), HttpStatus.OK);
            } else {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Conta não encontrada.",
                        "Conta não foi encontrada com o ID passado.");
            }
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public String getAccountProfilePictureName(int id) {
        try {
            Optional<Account> account = repository.findById(id);
            if (account.isPresent()) {
                return account.get().getProfilePictureName();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Conta não encontrado";
        }
        return "Conta não encontrado";
    }

    public ResponseEntity<Object> createAccount(Account account) {
        try {
            if (!Utils.emailValidator(account.getEmail())) {
                return new ExceptionConstructor().responseConstructor(HttpStatus.BAD_REQUEST,
                        "E-mail não é válido",
                        "O E-mail informado não é válido. Por favor, inserir um e-mail válido");
            }
            return new ResponseEntity<>(repository.save(account), HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> editAccount(Account account) {
        try {
            if (!Utils.emailValidator(account.getEmail())) {
                return new ExceptionConstructor().responseConstructor(HttpStatus.BAD_REQUEST,
                        "E-mail não é válido",
                        "O E-mail informado não é válido. Por favor, inserir um e-mail válido");
            }
            Account actualAccount = repository.searchById(account.getId());
            BeanUtils.copyProperties(account, actualAccount, new String[]{"runs", "sheets"});
            repository.save(actualAccount);
            return new ResponseEntity<>(actualAccount, HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> getLinkedRuns(int idAccount) {
        try {
            Account account = repository.searchById(idAccount);
            if (account.getRuns().isEmpty()) {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Não existem Runs vinculados a essa conta",
                        "Não foi possivel encontrar runs vinculadas com essa conta, a lista retornou vazia!");
            } else {
                account.getRuns().sort(Comparator.comparingLong(Run::getId));
                return new ResponseEntity<>(account.getRuns(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> verifyEmailUser(String email, String user, int id) {
        try {
            Optional<Account> accountEmail = repository.searchByEmail(email, id);
            Optional<Account> accountUser = repository.findByUser(user);

            if (accountEmail.isPresent() && accountUser.isPresent()) {
                return new ResponseEntity<>(1, HttpStatus.OK);
            }
            if (accountEmail.isPresent()) {
                return new ResponseEntity<>(2, HttpStatus.OK);
            }
            if (accountUser.isPresent()) {
                return new ResponseEntity<>(3, HttpStatus.OK);
            }
            if (!Utils.emailValidator(email)) {
                return new ResponseEntity<>(4, HttpStatus.OK);
            }
            return new ResponseEntity<>(0, HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> deleteAccount(int idAccount) {
        try {
            Account account = repository.searchById(idAccount);
            if (account.getId() < 1 || account.getSituation().equals("I")) {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Não foi possível excluir a conta.",
                        "Id passado não existe ou conta já está inativa!");
            }
            if (account.getRuns().isEmpty()) {
                repository.delete(account);
                return new ResponseEntity<>(0, HttpStatus.OK);
            } else {
                account.setSituation("I");
                repository.save(account);
                return new ResponseEntity<>(1, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public String saveFileName(int id, String fileName) {
        try {
            Optional<Account> account = repository.findById(id);
            if (account.isPresent()) {
                String olderFileName = account.get().getProfilePictureName();
                account.get().setProfilePictureName(fileName);
                repository.save(account.get());
                return olderFileName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private AccountDTO convertDTO(Account account) {
        return modelMapper.map(account, AccountDTO.class);
    }
}