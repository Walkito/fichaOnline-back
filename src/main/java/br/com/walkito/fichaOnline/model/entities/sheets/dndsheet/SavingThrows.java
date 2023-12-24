package br.com.walkito.fichaOnline.model.entities.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "dnd_saving_throws")
public class SavingThrows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int strength;

    @Column
    private boolean strengthProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int dexterity;

    @Column
    private boolean dexterityProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int constitution;

    @Column
    private boolean constitutionProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int intelligence;

    @Column
    private boolean intelligenceProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int wisdom;

    @Column
    private boolean wisdomProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int charisma;

    @Column
    private boolean charismaProeficiency;

    public SavingThrows() {
    }

    public SavingThrows(int strength, boolean strengthProeficiency, int dexterity, boolean dexterityProeficiency, int constitution, boolean constitutionProeficiency, int intelligence, boolean intelligenceProeficiency, int wisdom, boolean wisdomProeficiency, int charisma, boolean charismaProeficiency) {
        this.strength = strength;
        this.strengthProeficiency = strengthProeficiency;
        this.dexterity = dexterity;
        this.dexterityProeficiency = dexterityProeficiency;
        this.constitution = constitution;
        this.constitutionProeficiency = constitutionProeficiency;
        this.intelligence = intelligence;
        this.intelligenceProeficiency = intelligenceProeficiency;
        this.wisdom = wisdom;
        this.wisdomProeficiency = wisdomProeficiency;
        this.charisma = charisma;
        this.charismaProeficiency = charismaProeficiency;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public boolean isStrengthProeficiency() {
        return strengthProeficiency;
    }

    public void setStrengthProeficiency(boolean strengthProeficiency) {
        this.strengthProeficiency = strengthProeficiency;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public boolean isDexterityProeficiency() {
        return dexterityProeficiency;
    }

    public void setDexterityProeficiency(boolean dexterityProeficiency) {
        this.dexterityProeficiency = dexterityProeficiency;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public boolean isConstitutionProeficiency() {
        return constitutionProeficiency;
    }

    public void setConstitutionProeficiency(boolean constitutionProeficiency) {
        this.constitutionProeficiency = constitutionProeficiency;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public boolean isIntelligenceProeficiency() {
        return intelligenceProeficiency;
    }

    public void setIntelligenceProeficiency(boolean intelligenceProeficiency) {
        this.intelligenceProeficiency = intelligenceProeficiency;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public boolean isWisdomProeficiency() {
        return wisdomProeficiency;
    }

    public void setWisdomProeficiency(boolean wisdomProeficiency) {
        this.wisdomProeficiency = wisdomProeficiency;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public boolean isCharismaProeficiency() {
        return charismaProeficiency;
    }

    public void setCharismaProeficiency(boolean charismaProeficiency) {
        this.charismaProeficiency = charismaProeficiency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
