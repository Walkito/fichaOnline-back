package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.Utils;
import br.com.walkito.fichaOnline.model.UserRole;
import br.com.walkito.fichaOnline.model.dtos.AccountDTO;
import br.com.walkito.fichaOnline.model.dtos.LoginResponse;
import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.model.entities.Run;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import br.com.walkito.fichaOnline.model.repositorys.AccountRepository;
import br.com.walkito.fichaOnline.service.security.TokenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

@Service
public class AccountService{
    @Autowired
    AccountRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity<Object> doLogin(String user, String password) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(user, password);
            var auth = this.authenticationManager.authenticate(usernamePassword);

            Account account = (Account) auth.getPrincipal();

            var token = tokenService.generateToken(account);

            if (account.getSituation().equals("I")) {
                return ResponseEntity.badRequest().build();
            }

            LoginResponse login = new LoginResponse(token, account);

            return ResponseEntity.ok(login);
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
                return ResponseEntity.notFound().build();
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
            return "";
        }
        return "";
    }

    public ResponseEntity<Object> createAccount(Account account) {
        try {
            if (!Utils.emailValidator(account.getEmail())) {
                return new ExceptionConstructor().responseConstructor(HttpStatus.BAD_REQUEST,
                        "E-mail não é válido",
                        "O E-mail informado não é válido. Por favor, inserir um e-mail válido");
            }

            account.setRole(UserRole.PLAYER);

            String encryptedPassword = new BCryptPasswordEncoder().encode(account.getPassword());
            account.setPassword(encryptedPassword);
            repository.save(account);

            return ResponseEntity.ok().build();
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

            String encryptedPassword = new BCryptPasswordEncoder().encode(actualAccount.getPassword());
            actualAccount.setPassword(encryptedPassword);
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