package br.com.walkito.fichaOnline.model.entities.sheets;

import br.com.walkito.fichaOnline.model.entities.PlayerSheet;
import br.com.walkito.fichaOnline.model.entities.sheets.dndsheet.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dnd_sheet")
public class SheetDnD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_infos_id")
    private PersonalInfos personalInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attributes_id")
    private Attributes attribute;

    @Column(precision = 1)
    private int inspiration;

    @Column(nullable = false, precision = 2)
    @Min(2)
    @NotNull
    private int proeficiencyBonus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "saving_throws_id")
    private SavingThrows savingThrow;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skills_id")
    private Skills skill;

    @Column(nullable = false, precision = 2)
    @Min(1)
    @NotNull
    private int armorClass;

    @Column(precision = 2)
    private int initiative;

    @Column(length = 6)
    private String speed;

    @Column(nullable = false, precision = 3)
    @NotNull
    private int hpMax;

    @Column(nullable = false, precision = 3)
    @NotNull
    private int currentHp;

    @Column(precision = 3)
    private int temporaryHp;

    @Column(length = 6)
    private String totalHitDice;

    @Column(length = 6)
    private String hitDice;

    @Column(precision = 1)
    @Max(3)
    @Min(0)
    private int successes;

    @Column(precision = 1)
    @Max(3)
    @Min(0)
    private int failures;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attacks_id")
    private Attacks attack;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personality_id")
    private Personality personality;

    @Column(precision = 2)
    private int passiveWisdom;

    @Column(length = 300)
    @Size(max = 300)
    private String othersProficiencies;

    @Column(length = 300)
    @Size(max = 300)
    private String equipment;

    @Column(length = 300)
    @Size(max = 300)
    private String featuresTraits;

    @Column(length = 50)
    @Size(max = 50)
    private String characterPictureFileName;

    @Column(length = 1000)
    @Size(max = 1000)
    private String characterPictureAddress;

    @Column
    private String backstory;

    @Column(length = 25)
    @Size(max = 25)
    private String spellcastingClass;

    @Column(length = 20)
    @Size(max = 20)
    private String spellcastingHability;

    @Column(precision = 2)
    @Min(1)
    private int spellDC;

    @Column(precision = 2)
    private int spellAtkBonus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cantrip_id")
    private Cantrips cantrips;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_level_one")
    private SpellsLevelOne spellsLevelOne;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_level_two")
    private SpellsLevelTwo spellsLevelTwo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_level_three")
    private SpellsLevelThree spellsLevelThree;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_level_four")
    private SpellsLevelFour spellsLevelFour;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_level_five")
    private SpellsLevelFive spellsLevelFive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_level_six")
    private SpellsLevelSix spellsLevelSix;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_level_seven")
    private SpellsLevelSeven spellsLevelSeven;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_level_eigth")
    private SpellsLevelEigth spellsLevelEigth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spell_level_nine")
    private SpellsLevelNine spellsLevelNine;

    public SheetDnD(){

    }

    public SheetDnD(PersonalInfos personalInfo, Attributes attribute, int inspiration,
                    int proeficiencyBonus, SavingThrows savingThrow, Skills skill, int armorClass,
                    int initiative, String speed, int hpMax, int currentHp, int temporaryHp,
                    String totalHitDice, String hitDice, int successes, int failures, Attacks attack,
                    Personality personality, int passiveWisdom, String othersProficiencies,
                    String equipment, String featuresTraits, String characterPictureFileName,
                    String characterPictureAddress, String backstory, String spellcastingClass,
                    String spellcastingHability, int spellDC, int spellAtkBonus, Cantrips cantrips,
                    SpellsLevelOne spellsLevelOne, SpellsLevelTwo spellsLevelTwo,
                    SpellsLevelThree spellsLevelThree, SpellsLevelFour spellsLevelFour,
                    SpellsLevelFive spellsLevelFive, SpellsLevelSix spellsLevelSix,
                    SpellsLevelSeven spellsLevelSeven, SpellsLevelEigth spellsLevelEigth,
                    SpellsLevelNine spellsLevelNine) {
        this.personalInfo = personalInfo;
        this.attribute = attribute;
        this.inspiration = inspiration;
        this.proeficiencyBonus = proeficiencyBonus;
        this.savingThrow = savingThrow;
        this.skill = skill;
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.hpMax = hpMax;
        this.currentHp = currentHp;
        this.temporaryHp = temporaryHp;
        this.totalHitDice = totalHitDice;
        this.hitDice = hitDice;
        this.successes = successes;
        this.failures = failures;
        this.attack = attack;
        this.personality = personality;
        this.passiveWisdom = passiveWisdom;
        this.othersProficiencies = othersProficiencies;
        this.equipment = equipment;
        this.featuresTraits = featuresTraits;
        this.characterPictureFileName = characterPictureFileName;
        this.characterPictureAddress = characterPictureAddress;
        this.backstory = backstory;
        this.spellcastingClass = spellcastingClass;
        this.spellcastingHability = spellcastingHability;
        this.spellDC = spellDC;
        this.spellAtkBonus = spellAtkBonus;
        this.cantrips = cantrips;
        this.spellsLevelOne = spellsLevelOne;
        this.spellsLevelTwo = spellsLevelTwo;
        this.spellsLevelThree = spellsLevelThree;
        this.spellsLevelFour = spellsLevelFour;
        this.spellsLevelFive = spellsLevelFive;
        this.spellsLevelSix = spellsLevelSix;
        this.spellsLevelSeven = spellsLevelSeven;
        this.spellsLevelEigth = spellsLevelEigth;
        this.spellsLevelNine = spellsLevelNine;
    }

    public int getInspiration() {
        return inspiration;
    }

    public void setInspiration(int inspiration) {
        this.inspiration = inspiration;
    }

    public int getProeficiencyBonus() {
        return proeficiencyBonus;
    }

    public void setProeficiencyBonus(int proeficiencyBonus) {
        this.proeficiencyBonus = proeficiencyBonus;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getTemporaryHp() {
        return temporaryHp;
    }

    public void setTemporaryHp(int temporaryHp) {
        this.temporaryHp = temporaryHp;
    }

    public String getTotalHitDice() {
        return totalHitDice;
    }

    public void setTotalHitDice(String totalHitDice) {
        this.totalHitDice = totalHitDice;
    }

    public String getHitDice() {
        return hitDice;
    }

    public void setHitDice(String hitDice) {
        this.hitDice = hitDice;
    }

    public int getSuccesses() {
        return successes;
    }

    public void setSuccesses(int successes) {
        this.successes = successes;
    }

    public int getFailures() {
        return failures;
    }

    public void setFailures(int failures) {
        this.failures = failures;
    }

    public int getPassiveWisdom() {
        return passiveWisdom;
    }

    public void setPassiveWisdom(int passiveWisdom) {
        this.passiveWisdom = passiveWisdom;
    }

    public String getOthersProficiencies() {
        return othersProficiencies;
    }

    public void setOthersProficiencies(String othersProficiencies) {
        this.othersProficiencies = othersProficiencies;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getFeaturesTraits() {
        return featuresTraits;
    }

    public void setFeaturesTraits(String featuresTraits) {
        this.featuresTraits = featuresTraits;
    }

    public String getCharacterPictureFileName() {
        return characterPictureFileName;
    }

    public void setCharacterPictureFileName(String characterPictureFileName) {
        this.characterPictureFileName = characterPictureFileName;
    }

    public String getCharacterPictureAddress() {
        return characterPictureAddress;
    }

    public void setCharacterPictureAddress(String characterPictureAddress) {
        this.characterPictureAddress = characterPictureAddress;
    }

    public String getBackstory() {
        return backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    public String getSpellcastingClass() {
        return spellcastingClass;
    }

    public void setSpellcastingClass(String spellcastingClass) {
        this.spellcastingClass = spellcastingClass;
    }

    public String getSpellcastingAbility() {
        return spellcastingHability;
    }

    public void setSpellcastingAbility(String spellcastingAbility) {
        this.spellcastingHability = spellcastingAbility;
    }

    public int getSpellDC() {
        return spellDC;
    }

    public void setSpellDC(int spellDC) {
        this.spellDC = spellDC;
    }

    public int getSpellAtkBonus() {
        return spellAtkBonus;
    }

    public void setSpellAtkBonus(int spellAtkBonus) {
        this.spellAtkBonus = spellAtkBonus;
    }

    public Cantrips getCantrips() {
        return cantrips;
    }

    public void setCantrips(Cantrips cantrips) {
        this.cantrips = cantrips;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonalInfos getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfos personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Attributes getAttribute() {
        return attribute;
    }

    public void setAttribute(Attributes attribute) {
        this.attribute = attribute;
    }

    public SavingThrows getSavingThrow() {
        return savingThrow;
    }

    public void setSavingThrow(SavingThrows savingThrow) {
        this.savingThrow = savingThrow;
    }

    public Skills getSkill() {
        return skill;
    }

    public void setSkill(Skills skill) {
        this.skill = skill;
    }

    public Attacks getAttack() {
        return attack;
    }

    public void setAttack(Attacks attack) {
        this.attack = attack;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public String getSpellcastingHability() {
        return spellcastingHability;
    }

    public void setSpellcastingHability(String spellcastingHability) {
        this.spellcastingHability = spellcastingHability;
    }

    public SpellsLevelOne getSpellsLevelOne() {

        return spellsLevelOne;
    }

    public void setSpellsLevelOne(SpellsLevelOne spellsLevelOne) {
        this.spellsLevelOne = spellsLevelOne;
    }

    public SpellsLevelTwo getSpellsLevelTwo() {

        return spellsLevelTwo;
    }

    public void setSpellsLevelTwo(SpellsLevelTwo spellsLevelTwo) {
        this.spellsLevelTwo = spellsLevelTwo;
    }

    public SpellsLevelThree getSpellsLevelThree() {

        return spellsLevelThree;
    }

    public void setSpellsLevelThree(SpellsLevelThree spellsLevelThree) {
        this.spellsLevelThree = spellsLevelThree;
    }

    public SpellsLevelFour getSpellsLevelFour() {
        return spellsLevelFour;
    }

    public void setSpellsLevelFour(SpellsLevelFour spellsLevelFour) {
        this.spellsLevelFour = spellsLevelFour;
    }

    public SpellsLevelFive getSpellsLevelFive() {
        return spellsLevelFive;
    }

    public void setSpellsLevelFive(SpellsLevelFive spellsLevelFive) {
        this.spellsLevelFive = spellsLevelFive;
    }

    public SpellsLevelSix getSpellsLevelSix() {
        return spellsLevelSix;
    }

    public void setSpellsLevelSix(SpellsLevelSix spellsLevelSix) {
        this.spellsLevelSix = spellsLevelSix;
    }

    public SpellsLevelSeven getSpellsLevelSeven() {
        return spellsLevelSeven;
    }

    public void setSpellsLevelSeven(SpellsLevelSeven spellsLevelSeven) {
        this.spellsLevelSeven = spellsLevelSeven;
    }

    public SpellsLevelEigth getSpellsLevelEigth() {
        return spellsLevelEigth;
    }

    public void setSpellsLevelEigth(SpellsLevelEigth spellsLevelEigth) {
        this.spellsLevelEigth = spellsLevelEigth;
    }

    public SpellsLevelNine getSpellsLevelNine() {
        return spellsLevelNine;
    }

    public void setSpellsLevelNine(SpellsLevelNine spellsLevelNine) {
        this.spellsLevelNine = spellsLevelNine;
    }
}
