package br.com.walkito.fichaOnline.model.entities.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "dnd_attributes")
public class Attributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, precision = 2)
    @Min(1)
    @NotNull
    private int strength;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int strengthMod;

    @Column(nullable = false, precision = 2)
    @Min(1)
    @NotNull
    private int dexterity;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int dexterityMod;

    @Column(nullable = false, precision = 2)
    @Min(1)
    @NotNull
    private int constitution;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int constitutionMod;

    @Column(nullable = false, precision = 2)
    @Min(1)
    @NotNull
    private int intelligence;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int intelligenceMod;

    @Column(nullable = false, precision = 2)
    @Min(1)
    @NotNull
    private int wisdom;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int wisdomMod;

    @Column(nullable = false, precision = 2)
    @Min(1)
    @NotNull
    private int charisma;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int charismaMod;

    public Attributes() {
    }

    public Attributes(int strength, int strengthMod, int dexterity, int dexterityMod, int constitution, int constitutionMod, int intelligence, int intelligenceMod, int wisdom, int wisdomMod, int charisma, int charismaMod) {
        this.strength = strength;
        this.strengthMod = strengthMod;
        this.dexterity = dexterity;
        this.dexterityMod = dexterityMod;
        this.constitution = constitution;
        this.constitutionMod = constitutionMod;
        this.intelligence = intelligence;
        this.intelligenceMod = intelligenceMod;
        this.wisdom = wisdom;
        this.wisdomMod = wisdomMod;
        this.charisma = charisma;
        this.charismaMod = charismaMod;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrengthMod() {
        return strengthMod;
    }

    public void setStrengthMod(int strengthMod) {
        this.strengthMod = strengthMod;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterityMod() {
        return dexterityMod;
    }

    public void setDexterityMod(int dexterityMod) {
        this.dexterityMod = dexterityMod;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getConstitutionMod() {
        return constitutionMod;
    }

    public void setConstitutionMod(int constitutionMod) {
        this.constitutionMod = constitutionMod;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getIntelligenceMod() {
        return intelligenceMod;
    }

    public void setIntelligenceMod(int intelligenceMod) {
        this.intelligenceMod = intelligenceMod;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getWisdomMod() {
        return wisdomMod;
    }

    public void setWisdomMod(int wisdomMod) {
        this.wisdomMod = wisdomMod;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getCharismaMod() {
        return charismaMod;
    }

    public void setCharismaMod(int charismaMod) {
        this.charismaMod = charismaMod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
