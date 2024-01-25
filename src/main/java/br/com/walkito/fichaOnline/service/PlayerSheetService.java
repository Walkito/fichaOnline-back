package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.model.entities.PlayerSheet;
import br.com.walkito.fichaOnline.model.repositorys.AccountRepository;
import br.com.walkito.fichaOnline.model.repositorys.PlayerSheetRepository;
import br.com.walkito.fichaOnline.model.repositorys.RunRepository;
import br.com.walkito.fichaOnline.model.specifications.PlayerSheetSpecifications;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
                repository.save(sheet);
                return new ResponseEntity<>(true, HttpStatus.OK);
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

    public ResponseEntity<Object> deleteSheet(int idSheet){
        try{
            Optional<PlayerSheet> playerSheetActual = repository.findBySheetDnDId(idSheet);
            if(playerSheetActual.isPresent()){
                repository.delete(playerSheetActual.get());
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Não foi possível excluir a ficha",
                        "Ficha não encontrada para excluir");
            }
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }
}
