package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.model.dtos.RunAccountDTO;
import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.model.entities.PlayerSheet;
import br.com.walkito.fichaOnline.model.entities.Run;
import br.com.walkito.fichaOnline.model.repository.AccountRepository;
import br.com.walkito.fichaOnline.model.repository.PlayerSheetRepository;
import br.com.walkito.fichaOnline.model.repository.RunRepository;
import br.com.walkito.fichaOnline.model.specifications.PlayerSheetSpecifications;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class PlayerSheetService {
    @Autowired
    PlayerSheetRepository repository;
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RunRepository runRepository;

    public ResponseEntity<Object> getSheets(int idAccount, int idRun){
        try{
            Specification<PlayerSheet> specs = PlayerSheetSpecifications.filterByAccountId(idAccount)
                                        .and(PlayerSheetSpecifications.filterByRunId(idRun));
            List<PlayerSheet> sheets = repository.findAll(specs);
            if(sheets.isEmpty()){
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Fichas não encontradas.",
                          "Nenhuma ficha foi encontrada, verifique os Ids passados");
            }
            return new ResponseEntity<>(sheets, HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> linkSheet(PlayerSheet sheet){
        try{
            if(sheet.getAccount().getId() > 0  || sheet.getRun().getId() > 0){
                return new ResponseEntity<>(repository.save(sheet), HttpStatus.OK);
            } else {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Impossível criar a ficha!",
                        "Os valores de Account ou da Run não existem");
            }
        } catch(Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                                                                    e.getMessage(),
                                                                    Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> editSheet(PlayerSheet sheet){
        try{
            if(sheet.getAccount().getId() > 0  || sheet.getRun().getId() > 0){
                PlayerSheet actualSheet = repository.searchById(sheet.getId());
                BeanUtils.copyProperties(sheet, actualSheet, "sheetsDnd");
                return new ResponseEntity<>(repository.save(actualSheet), HttpStatus.OK);
            } else {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Impossível criar a ficha!",
                        "Os valores de Account ou da Run não existem");
            }
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                                                                  e.getMessage(),
                                                                  Arrays.toString(e.getStackTrace()));
        }
    }
}
