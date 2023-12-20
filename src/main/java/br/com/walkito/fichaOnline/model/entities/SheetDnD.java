package br.com.walkito.fichaOnline.model.entities;

import br.com.walkito.fichaOnline.model.entities.dndsheet.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "dnd_sheet")
public class SheetDnD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "personal_infos_id")
    private PersonalInfos personalInfo;

    @OneToOne
    @JoinColumn(name = "attributes_id")
    private Attributes attribute;

    @Column(precision = 1)
    private int inspiration;

    @Column(nullable = false, precision = 2)
    @Min(2)
    @NotNull
    private int proeficiencyBonus;

    @OneToOne
    @JoinColumn(name = "saving_throws_id")
    private SavingThrows savingThrow;

    @OneToOne
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

    @OneToOne
    @JoinColumn(name = "attacks_id")
    private Attacks attack;

    @OneToOne
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

    @OneToOne
    @JoinColumn(name = "cantrip_id")
    private Cantrip cantrip;

    @OneToOne
    @JoinColumn(name = "spell_level_one")
    private SpellsLevelOne spellsLevelOne;

    @OneToOne
    @JoinColumn(name = "spell_level_two")
    private SpellsLevelTwo spellsLevelTwo;

    @OneToOne
    @JoinColumn(name = "spell_level_three")
    private SpellsLevelThree spellsLevelThree;

    @OneToOne
    @JoinColumn(name = "spell_level_four")
    private SpellsLevelFour spellsLevelFour;

    @OneToOne
    @JoinColumn(name = "spell_level_five")
    private SpellsLevelFive spellsLevelFive;

    @OneToOne
    @JoinColumn(name = "spell_level_six")
    private SpellsLevelSix spellsLevelSix;

    @OneToOne
    @JoinColumn(name = "spell_level_seven")
    private SpellsLevelSeven spellsLevelSeven;

    @OneToOne
    @JoinColumn(name = "spell_level_eigth")
    private SpellsLevelEigth spellsLevelEigth;

    @OneToOne
    @JoinColumn(name = "spell_level_nine")
    private SpellsLevelNine spellsLevelNine;

    @ManyToOne
    @JoinColumn(name = "players_sheets_id")
    @JsonIgnore
    private PlayerSheet playerSheet;

    public SheetDnD(){

    }

    public SheetDnD(PersonalInfos personalInfo, Attributes attribute, int inspiration, int proeficiencyBonus, SavingThrows savingThrow, Skills skill, int armorClass, int initiative, String speed, int hpMax, int currentHp, int temporaryHp, String totalHitDice, String hitDice, int successes, int failures, Attacks attack, Personality personality, int passiveWisdom, String othersProficiencies, String equipment, String featuresTraits, String characterPictureFileName, String characterPictureAddress, String backstory, String spellcastingClass, String spellcastingHability, int spellDC, int spellAtkBonus, Cantrip cantrip, SpellsLevelOne spellsLevelOne, SpellsLevelTwo spellsLevelTwo, SpellsLevelThree spellsLevelThree, SpellsLevelFour spellsLevelFour, SpellsLevelFive spellsLevelFive, SpellsLevelSix spellsLevelSix, SpellsLevelSeven spellsLevelSeven, SpellsLevelEigth spellsLevelEigth, SpellsLevelNine spellsLevelNine, PlayerSheet playerSheet) {
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
        this.cantrip = cantrip;
        this.spellsLevelOne = spellsLevelOne;
        this.spellsLevelTwo = spellsLevelTwo;
        this.spellsLevelThree = spellsLevelThree;
        this.spellsLevelFour = spellsLevelFour;
        this.spellsLevelFive = spellsLevelFive;
        this.spellsLevelSix = spellsLevelSix;
        this.spellsLevelSeven = spellsLevelSeven;
        this.spellsLevelEigth = spellsLevelEigth;
        this.spellsLevelNine = spellsLevelNine;
        setPlayerSheet(playerSheet);
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

    public PlayerSheet getPlayerSheet() {
        return playerSheet;
    }

    public void setPlayerSheet(PlayerSheet playerSheet) {
        this.playerSheet = playerSheet;
        this.playerSheet.getSheetsDnd().add(this);
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
        personalInfo.setSheetDnD(this);
        this.personalInfo = personalInfo;
    }

    public Attributes getAttribute() {
        return attribute;
    }

    public void setAttribute(Attributes attribute) {
        attribute.setSheetDnD(this);
        this.attribute = attribute;
    }

    public SavingThrows getSavingThrow() {
        return savingThrow;
    }

    public void setSavingThrow(SavingThrows savingThrow) {
        savingThrow.setSheetDnD(this);
        this.savingThrow = savingThrow;
    }

    public Skills getSkill() {
        return skill;
    }

    public void setSkill(Skills skill) {
        skill.setSheetDnD(this);
        this.skill = skill;
    }

    public Attacks getAttack() {
        return attack;
    }

    public void setAttack(Attacks attack) {
        attack.setSheetDnD(this);
        this.attack = attack;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        personality.setSheetDnD(this);
        this.personality = personality;
    }

    public String getSpellcastingHability() {
        return spellcastingHability;
    }

    public void setSpellcastingHability(String spellcastingHability) {
        this.spellcastingHability = spellcastingHability;
    }

    public Cantrip getCantrip() {
        return cantrip;
    }

    public void setCantrip(Cantrip cantrip) {
        cantrip.setSheetDnD(this);
        this.cantrip = cantrip;
    }

    public SpellsLevelOne getSpellsLevelOne() {

        return spellsLevelOne;
    }

    public void setSpellsLevelOne(SpellsLevelOne spellsLevelOne) {
        spellsLevelOne.setSheetDnD(this);
        this.spellsLevelOne = spellsLevelOne;
    }

    public SpellsLevelTwo getSpellsLevelTwo() {

        return spellsLevelTwo;
    }

    public void setSpellsLevelTwo(SpellsLevelTwo spellsLevelTwo) {
        spellsLevelTwo.setSheetDnD(this);
        this.spellsLevelTwo = spellsLevelTwo;
    }

    public SpellsLevelThree getSpellsLevelThree() {

        return spellsLevelThree;
    }

    public void setSpellsLevelThree(SpellsLevelThree spellsLevelThree) {
        spellsLevelThree.setSheetDnD(this);
        this.spellsLevelThree = spellsLevelThree;
    }

    public SpellsLevelFour getSpellsLevelFour() {
        return spellsLevelFour;
    }

    public void setSpellsLevelFour(SpellsLevelFour spellsLevelFour) {
        spellsLevelFour.setSheetDnD(this);
        this.spellsLevelFour = spellsLevelFour;
    }

    public SpellsLevelFive getSpellsLevelFive() {
        return spellsLevelFive;
    }

    public void setSpellsLevelFive(SpellsLevelFive spellsLevelFive) {
        spellsLevelFive.setSheetDnD(this);
        this.spellsLevelFive = spellsLevelFive;
    }

    public SpellsLevelSix getSpellsLevelSix() {
        return spellsLevelSix;
    }

    public void setSpellsLevelSix(SpellsLevelSix spellsLevelSix) {
        spellsLevelSix.setSheetDnD(this);
        this.spellsLevelSix = spellsLevelSix;
    }

    public SpellsLevelSeven getSpellsLevelSeven() {
        return spellsLevelSeven;
    }

    public void setSpellsLevelSeven(SpellsLevelSeven spellsLevelSeven) {
        spellsLevelSeven.setSheetDnD(this);
        this.spellsLevelSeven = spellsLevelSeven;
    }

    public SpellsLevelEigth getSpellsLevelEigth() {
        return spellsLevelEigth;
    }

    public void setSpellsLevelEigth(SpellsLevelEigth spellsLevelEigth) {
        spellsLevelEigth.setSheetDnD(this);
        this.spellsLevelEigth = spellsLevelEigth;
    }

    public SpellsLevelNine getSpellsLevelNine() {
        return spellsLevelNine;
    }

    public void setSpellsLevelNine(SpellsLevelNine spellsLevelNine) {
        spellsLevelNine.setSheetDnD(this);
        this.spellsLevelNine = spellsLevelNine;
    }
}
