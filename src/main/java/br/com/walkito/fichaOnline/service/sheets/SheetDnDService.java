package br.com.walkito.fichaOnline.service.sheets;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import br.com.walkito.fichaOnline.service.sheets.dndsheet.PersonalInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SheetDnDService {
    @Autowired
    PersonalInfosService personalInfosService;

    public ResponseEntity<Object> createSheet(SheetDnD sheetDnD){
        try{



        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
        return null;
    }
}
