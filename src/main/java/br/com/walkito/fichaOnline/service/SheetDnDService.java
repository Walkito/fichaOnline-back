package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.model.entities.SheetDnD;
import br.com.walkito.fichaOnline.model.repository.SheetDnDRepository;
import br.com.walkito.fichaOnline.model.repository.dndsheet.*;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SheetDnDService {
    @Autowired
    SheetDnDRepository repository;
    @Autowired
    AttacksRepository attacksRepository;
    @Autowired
    AttributesRepository attributesRepository;
    @Autowired
    CantripRepository cantripRepository;
    @Autowired
    PersonalInfosRepository personalInfosRepository;
    @Autowired
    PersonalityRepository personalityRepository;
    @Autowired
    SavingThrowsRepository savingThrowsRepository;
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    SpellsLevelNineRepository spellsLevelNineRepository;
    @Autowired
    SpellsLevelEigthRepository spellsLevelEigthRepository;
    @Autowired
    SpellsLevelSevenRepository spellsLevelSevenRepository;
    @Autowired
    SpellsLevelSixRepository spellsLevelSixRepository;
    @Autowired
    SpellsLevelFiveRepository spellsLevelFiveRepository;
    @Autowired
    SpellsLevelFourRepository spellsLevelFourRepository;
    @Autowired
    SpellsLevelThreeRepository spellsLevelThreeRepository;
    @Autowired
    SpellsLevelTwoRepository spellsLevelTwoRepository;
    @Autowired
    SpellsLevelOneRepository spellsLevelOneRepository;

    public ResponseEntity<Object> createSheet(SheetDnD sheetDnD){
        try{
            //TO DO SERVICES DE CADA UM;
            personalInfosRepository.save(sheetDnD.getPersonalInfo());
            attributesRepository.save(sheetDnD.getAttribute());
            savingThrowsRepository.save(sheetDnD.getSavingThrow());
            skillsRepository.save(sheetDnD.getSkill());
            attacksRepository.save(sheetDnD.getAttack());
            personalityRepository.save(sheetDnD.getPersonality());
            cantripRepository.save(sheetDnD.getCantrip());
            spellsLevelOneRepository.save(sheetDnD.getSpellsLevelOne());
            spellsLevelTwoRepository.save(sheetDnD.getSpellsLevelTwo());
            spellsLevelThreeRepository.save(sheetDnD.getSpellsLevelThree());
            spellsLevelFourRepository.save(sheetDnD.getSpellsLevelFour());
            spellsLevelFiveRepository.save(sheetDnD.getSpellsLevelFive());
            spellsLevelSixRepository.save(sheetDnD.getSpellsLevelSix());
            spellsLevelSevenRepository.save(sheetDnD.getSpellsLevelSeven());
            spellsLevelEigthRepository.save(sheetDnD.getSpellsLevelEigth());
            spellsLevelNineRepository.save(sheetDnD.getSpellsLevelNine());

            return new ResponseEntity<>(repository.save(sheetDnD), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }
}
