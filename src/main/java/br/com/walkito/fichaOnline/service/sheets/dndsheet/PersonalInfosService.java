package br.com.walkito.fichaOnline.service.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.dndsheet.PersonalInfos;
import br.com.walkito.fichaOnline.model.repositorys.sheets.dndsheet.PersonalInfosRepository;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PersonalInfosService {
    @Autowired
    PersonalInfosRepository repository;

    public ResponseEntity<Object> insertPersonalInfos(PersonalInfos personalInfos){
        try{
            return new ResponseEntity<>(repository.save(personalInfos), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> editPersonalInfos(PersonalInfos personalInfos){
        try{
            PersonalInfos actualPersonalInfos = repository.searchById(personalInfos.getId());
            BeanUtils.copyProperties(personalInfos, actualPersonalInfos, "sheetDnD");

            return new ResponseEntity<>(repository.save(actualPersonalInfos), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }    }

}
