package br.com.walkito.fichaOnline.service.sheets;

import br.com.walkito.fichaOnline.model.dtos.ImageDTO;
import br.com.walkito.fichaOnline.model.dtos.PayloadMessageDTO;
import br.com.walkito.fichaOnline.model.entities.PlayerSheet;
import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import br.com.walkito.fichaOnline.model.entities.sheets.dndsheet.Attributes;
import br.com.walkito.fichaOnline.model.entities.sheets.dndsheet.SavingThrows;
import br.com.walkito.fichaOnline.model.entities.sheets.dndsheet.Skills;
import br.com.walkito.fichaOnline.model.repositorys.sheets.SheetDnDRepository;
import br.com.walkito.fichaOnline.service.PlayerSheetService;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SheetDnDService {
    @Autowired
    SheetDnDRepository repository;

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @Autowired
    PlayerSheetService playerSheetService;

    public ResponseEntity<Object> getSheet(int id) {
        try {
            return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> getSheets(List<Integer> ids){
        try {
            return new ResponseEntity<>(repository.findAllById(ids), HttpStatus.OK);
        } catch (Exception e){
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }
    public ResponseEntity<Object> createSheet(SheetDnD sheetDnD) {
        try {
            businessRules(sheetDnD);
            return new ResponseEntity<>(repository.save(sheetDnD), HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> editSheet(SheetDnD sheetDnD) {
        try {
            Optional<SheetDnD> actualSheetDnD = repository.findById(sheetDnD.getId());
            PlayerSheet sheetInfos = playerSheetService.getSheet(sheetDnD.getId());

            if (actualSheetDnD.isEmpty()) {
                return new ExceptionConstructor().responseConstructor(HttpStatus.NOT_FOUND,
                        "Impossível editar a ficha!",
                        "Impossível editar a ficha pois não foi achado nenhuma ficha com esse ID.");
            }
            businessRules(sheetDnD);
            messagingTemplate.convertAndSend("/topic/SheetEdit", new PayloadMessageDTO("Uma ficha foi atualizada", sheetInfos.getRun().getId()));
            return new ResponseEntity<>(repository.save(sheetDnD), HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> updateAttributesInCreation(SheetDnD sheetDnD) {
        businessRules(sheetDnD);
        return new ResponseEntity<>(sheetDnD, HttpStatus.OK);
    }

    public String getPictureName(int id) {
        try {
            Optional<SheetDnD> sheet = repository.findById(id);
            if(sheet.isPresent()){
                return sheet.get().getCharacterPictureFileName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String saveFileName(ImageDTO image){
        try{
            Optional<SheetDnD> sheet = repository.findById(image.getId());
            if (sheet.isPresent()){
                String olderFileName = sheet.get().getCharacterPictureFileName();
                sheet.get().setCharacterPictureFileName(image.getFileName());
                repository.save(sheet.get());
                return olderFileName;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    private void businessRules(SheetDnD sheet) {
        sheet.setAttribute(attributesRules(sheet));
        sheet.setSavingThrow(savingThrowsRules(sheet));
        sheet.setSkill(skillsRules(sheet));
    }

    private Skills skillsRules(SheetDnD sheetDnD) {
        Attributes attributes = sheetDnD.getAttribute();
        int proficiencyBonus = sheetDnD.getProeficiencyBonus();

        sheetDnD.getSkill().setAcrobatics(calculateProficiencyNewValue(sheetDnD.getSkill().isAcrobaticsProeficiency(),
                attributes.getDexterityMod(), proficiencyBonus));

        sheetDnD.getSkill().setArcana(calculateProficiencyNewValue(sheetDnD.getSkill().isArcanaProeficiency(),
                attributes.getIntelligenceMod(), proficiencyBonus));

        sheetDnD.getSkill().setAthletics(calculateProficiencyNewValue(sheetDnD.getSkill().isAthleticsProeficiency(),
                attributes.getStrengthMod(), proficiencyBonus));

        sheetDnD.getSkill().setPerformance(calculateProficiencyNewValue(sheetDnD.getSkill().isPerformanceProeficiency(),
                attributes.getCharismaMod(), proficiencyBonus));

        sheetDnD.getSkill().setDeception(calculateProficiencyNewValue(sheetDnD.getSkill().isDeceptionProeficiency(),
                attributes.getCharismaMod(), proficiencyBonus));

        sheetDnD.getSkill().setStealth(calculateProficiencyNewValue(sheetDnD.getSkill().isStealthProeficiency(),
                attributes.getDexterityMod(), proficiencyBonus));

        sheetDnD.getSkill().setHistory(calculateProficiencyNewValue(sheetDnD.getSkill().isHistoryProeficiency(),
                attributes.getIntelligenceMod(), proficiencyBonus));

        sheetDnD.getSkill().setIntimidation(calculateProficiencyNewValue(sheetDnD.getSkill().isIntimidationProeficiency(),
                attributes.getCharismaMod(), proficiencyBonus));

        sheetDnD.getSkill().setInsight(calculateProficiencyNewValue(sheetDnD.getSkill().isInsightProeficiency(),
                attributes.getWisdomMod(), proficiencyBonus));

        sheetDnD.getSkill().setInvestigation(calculateProficiencyNewValue(sheetDnD.getSkill().isInvestigationProeficiency(),
                attributes.getIntelligenceMod(), proficiencyBonus));

        sheetDnD.getSkill().setAnimalHandling(calculateProficiencyNewValue(sheetDnD.getSkill().isAnimalHandlingProeficiency(),
                attributes.getWisdomMod(), proficiencyBonus));

        sheetDnD.getSkill().setMedicine(calculateProficiencyNewValue(sheetDnD.getSkill().isMedicineProeficiency(),
                attributes.getWisdomMod(), proficiencyBonus));

        sheetDnD.getSkill().setNature(calculateProficiencyNewValue(sheetDnD.getSkill().isNatureProeficiency(),
                attributes.getIntelligenceMod(), proficiencyBonus));

        sheetDnD.getSkill().setPerception(calculateProficiencyNewValue(sheetDnD.getSkill().isPerceptionProeficiency(),
                attributes.getWisdomMod(), proficiencyBonus));

        sheetDnD.getSkill().setPersuasion(calculateProficiencyNewValue(sheetDnD.getSkill().isPersuasionProeficiency(),
                attributes.getCharismaMod(), proficiencyBonus));

        sheetDnD.getSkill().setSleightOf(calculateProficiencyNewValue(sheetDnD.getSkill().isSleightOfProeficiency(),
                attributes.getDexterityMod(), proficiencyBonus));

        sheetDnD.getSkill().setReligion(calculateProficiencyNewValue(sheetDnD.getSkill().isReligionProeficiency(),
                attributes.getIntelligenceMod(), proficiencyBonus));

        sheetDnD.getSkill().setSurvival(calculateProficiencyNewValue(sheetDnD.getSkill().isSurvivalProeficiency(),
                attributes.getWisdomMod(), proficiencyBonus));

        return sheetDnD.getSkill();
    }

    private Attributes attributesRules(SheetDnD sheetDnD) {
        int strength = sheetDnD.getAttribute().getStrength();
        int dexterity = sheetDnD.getAttribute().getDexterity();
        int constitution = sheetDnD.getAttribute().getConstitution();
        int intelligence = sheetDnD.getAttribute().getIntelligence();
        int wisdom = sheetDnD.getAttribute().getWisdom();
        int charisma = sheetDnD.getAttribute().getCharisma();

        sheetDnD.getAttribute().setStrengthMod(calculateAttribute(strength));
        sheetDnD.getAttribute().setDexterityMod(calculateAttribute(dexterity));
        sheetDnD.getAttribute().setConstitutionMod(calculateAttribute(constitution));
        sheetDnD.getAttribute().setIntelligenceMod(calculateAttribute(intelligence));
        sheetDnD.getAttribute().setWisdomMod(calculateAttribute(wisdom));
        sheetDnD.getAttribute().setCharismaMod(calculateAttribute(charisma));

        return sheetDnD.getAttribute();
    }

    private int calculateAttribute(int value) {
        double attributeValue = Math.ceil((double) (value - (1)) / 2);
        return (int) attributeValue - 5;
    }

    private SavingThrows savingThrowsRules(SheetDnD sheetDnD) {
        SavingThrows savingThrows = sheetDnD.getSavingThrow();
        Attributes attributes = sheetDnD.getAttribute();
        int proeficiencyBonus = sheetDnD.getProeficiencyBonus();

        savingThrows.setStrength(calculateProficiencyNewValue(savingThrows.isStrengthProeficiency(),
                attributes.getStrengthMod(), proeficiencyBonus));

        savingThrows.setDexterity(calculateProficiencyNewValue(savingThrows.isDexterityProeficiency(),
                attributes.getDexterityMod(), proeficiencyBonus));

        savingThrows.setConstitution(calculateProficiencyNewValue(savingThrows.isConstitutionProeficiency(),
                attributes.getConstitutionMod(), proeficiencyBonus));

        savingThrows.setIntelligence(calculateProficiencyNewValue(savingThrows.isIntelligenceProeficiency(),
                attributes.getIntelligenceMod(), proeficiencyBonus));

        savingThrows.setWisdom(calculateProficiencyNewValue(savingThrows.isWisdomProeficiency(),
                attributes.getWisdomMod(), proeficiencyBonus));

        savingThrows.setCharisma(calculateProficiencyNewValue(savingThrows.isCharismaProeficiency(),
                attributes.getCharismaMod(), proeficiencyBonus));

        return savingThrows;
    }

    private int calculateProficiencyNewValue(boolean proeficiency, int attributeValue, int proeficiencyBonus) {
        return proeficiency ? proeficiencyBonus + attributeValue : attributeValue;
    }
}
