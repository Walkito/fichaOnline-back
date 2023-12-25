package br.com.walkito.fichaOnline.service.sheets;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import br.com.walkito.fichaOnline.model.repositorys.sheets.SheetDnDRepository;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class SheetDnDService {
    @Autowired
    SheetDnDRepository repository;

    public ResponseEntity<Object> getSheets(int id){
        try{
            return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> createSheet(SheetDnD sheetDnD){
        try{
            return new ResponseEntity<>(repository.save(sheetDnD), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> editSheet(SheetDnD sheetDnD){
        try{
            Optional<SheetDnD> actualSheetDnD = repository.findById(sheetDnD.getId());
            if(actualSheetDnD.isEmpty()){
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Impossível editar a ficha!",
                        "Impossível editar a ficha pois não foi achado nenhuma ficha com esse ID.");
            }
            return new ResponseEntity<>(repository.save(sheetDnD), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> deleteSheet(int id){
        try{
            Optional<SheetDnD> sheetDnD = repository.findById(id);
            if(sheetDnD.isEmpty()){
                return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Não foi possível excluir a ficha!",
                        "Ficha não existe.");
            }
            repository.delete(sheetDnD.get());
            return new ResponseEntity<>("Ficha excluída", HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }
}
