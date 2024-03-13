package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.model.dtos.RunAccountDTO;
import br.com.walkito.fichaOnline.model.dtos.RunMasterNameDTO;
import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.model.entities.PlayerSheet;
import br.com.walkito.fichaOnline.model.entities.Run;
import br.com.walkito.fichaOnline.model.repositorys.AccountRepository;
import br.com.walkito.fichaOnline.model.repositorys.RunRepository;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RunService {
    @Autowired
    RunRepository repository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;

    public ResponseEntity<Object> getRuns() {
        try {
            if (repository.findAll().isEmpty()) {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Runs não encontradas", "Não existem Runs Cadastradas.");
            } else {
                return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> getLinkedAccounts(int idRun) {
        try {
            Run run = repository.searchById(idRun);
            if (run.getAccounts().isEmpty()) {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Não existem Runs vinculados a essa conta",
                        "Não foi possivel encontrar runs vinculadas com essa conta, a lista retornou vazia!");
            } else {
                return new ResponseEntity<>(run.getAccounts(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> registerRun(Run run) {
        try {
            return new ResponseEntity<>(repository.save(run), HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> editRun(Run run) {
        try {
            Optional<Run> actualRun = repository.findById(run.getId());
            if (actualRun.isEmpty()) {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Não foi possível editar esta Run!",
                        "Não foi possível achar uma Run com o ID passado.");
            }
            return new ResponseEntity<>(repository.save(run), HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> linkAccount(RunAccountDTO lra) {
        try {
            Run run = repository.searchById(lra.getIdRun());
            Account account = accountRepository.searchById(lra.getIdAccount());

            if(run.getAccounts().contains(account)){
                return new ResponseEntity<>(false, HttpStatus.OK);
            }

            run.setLinkAccount(account);
            repository.save(run);
            accountRepository.save(account);

            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> unlinkAccount(int idRun, int idAccount){
        try {
            Run run = repository.searchById(idRun);
            Account account = accountRepository.searchById(idAccount);

            for(PlayerSheet sheet : run.getSheets()){
                if(sheet.getAccount().equals(account)){
                 return new ResponseEntity<>(false, HttpStatus.OK);
                }
            }

            run.unlinkAccount(account);
            repository.save(run);
            accountRepository.save(account);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> deleteRun(int idRun) {
        try {
            Run run = repository.searchById(idRun);

            if (run.getId() < 1) {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Não foi possível excluir a conta",
                        "A conta não foi localizada por este ID informado.");
            }
            if (!run.getAccounts().isEmpty()) {
                for (Account account : run.getAccounts()) {
                    account.getRuns().remove(run);
                }
                run.getAccounts().clear();
            }
            repository.save(run);
            repository.delete(run);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> getMasterRun(int id) {
        try {
            Optional<Account> masterAccount = accountRepository.findById(id);
            if (masterAccount.isPresent()) {
                String masterName = masterAccount.get().getName() + " " + masterAccount.get().getLastName();
                RunMasterNameDTO runMasterNameDTO = new RunMasterNameDTO(masterName);
                return new ResponseEntity<>(runMasterNameDTO, HttpStatus.OK);
            } else {
                return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Conta do Mestre não localizada",
                        "A conta do Mestre da Run não foi localizada.");
            }
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> getRunsFiltered(List<String> status, int accountID) {
        try {
            List<Run> runs = repository.findAllRunsFilter(status, accountID);
            return new ResponseEntity<>(runs, HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> getMasterRuns(int masterId) {
        try {
            return new ResponseEntity<>(repository.findByMasterId(masterId), HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> getRun(int id) {
        try {
            Optional<Run> run = repository.findById(id);
            if (run.isPresent()) {
                return new ResponseEntity<>(run.get(), HttpStatus.OK);
            } else {
                return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Run não encontrada",
                        "Não foi encontrada nenhuma run com o ID passado.");
            }
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }
}
