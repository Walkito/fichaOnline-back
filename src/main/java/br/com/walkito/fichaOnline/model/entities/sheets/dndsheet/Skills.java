package br.com.walkito.fichaOnline.model.entities.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "dnd_skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int acrobatics;

    @Column
    private boolean acrobaticsProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int animalHandling;

    @Column
    private boolean animalHandlingProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int arcana;

    @Column
    private boolean arcanaProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int athletics;

    @Column
    private boolean athleticsProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int deception;

    @Column
    private boolean deceptionProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int history;

    @Column
    private boolean historyProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int insight;

    @Column
    private boolean insightProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int intimidation;

    @Column
    private boolean intimidationProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int investigation;

    @Column
    private boolean investigationProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int medicine;

    @Column
    private boolean medicineProeficiency;

    @Column(nullable = false, precision = 2)
    private int nature;

    @Column
    private boolean natureProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int perception;

    @Column
    private boolean perceptionProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int performance;

    @Column
    private boolean performanceProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int persuasion;

    @Column
    private boolean persuasionProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int religion;

    @Column
    private boolean religionProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int sleightOf;

    @Column
    private boolean sleightOfProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int stealth;

    @Column
    private boolean stealthProeficiency;

    @Column(nullable = false, precision = 2)
    @NotNull
    private int survival;

    @Column
    private boolean survivalProeficiency;

    public Skills() {
    }

    public Skills(int acrobatics, boolean acrobaticsProeficiency, int animalHandling, boolean animalHandlingProeficiency, int arcana, boolean arcanaProeficiency, int athletics, boolean athleticsProeficiency, int deception, boolean deceptionProeficiency, int history, boolean historyProeficiency, int insight, boolean insightProeficiency, int intimidation, boolean intimidationProeficiency, int investigation, boolean investigationProeficiency, int medicine, boolean medicineProeficiency, int nature, boolean natureProeficiency, int perception, boolean perceptionProeficiency, int performance, boolean performanceProeficiency, int persuasion, boolean persuasionProeficiency, int religion, boolean religionProeficiency, int sleightOf, boolean sleightOfProeficiency, int stealth, boolean stealthProeficiency, int survival, boolean survivalProeficiency) {
        this.acrobatics = acrobatics;
        this.acrobaticsProeficiency = acrobaticsProeficiency;
        this.animalHandling = animalHandling;
        this.animalHandlingProeficiency = animalHandlingProeficiency;
        this.arcana = arcana;
        this.arcanaProeficiency = arcanaProeficiency;
        this.athletics = athletics;
        this.athleticsProeficiency = athleticsProeficiency;
        this.deception = deception;
        this.deceptionProeficiency = deceptionProeficiency;
        this.history = history;
        this.historyProeficiency = historyProeficiency;
        this.insight = insight;
        this.insightProeficiency = insightProeficiency;
        this.intimidation = intimidation;
        this.intimidationProeficiency = intimidationProeficiency;
        this.investigation = investigation;
        this.investigationProeficiency = investigationProeficiency;
        this.medicine = medicine;
        this.medicineProeficiency = medicineProeficiency;
        this.nature = nature;
        this.natureProeficiency = natureProeficiency;
        this.perception = perception;
        this.perceptionProeficiency = perceptionProeficiency;
        this.performance = performance;
        this.performanceProeficiency = performanceProeficiency;
        this.persuasion = persuasion;
        this.persuasionProeficiency = persuasionProeficiency;
        this.religion = religion;
        this.religionProeficiency = religionProeficiency;
        this.sleightOf = sleightOf;
        this.sleightOfProeficiency = sleightOfProeficiency;
        this.stealth = stealth;
        this.stealthProeficiency = stealthProeficiency;
        this.survival = survival;
        this.survivalProeficiency = survivalProeficiency;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public boolean isNatureProeficiency() {
        return natureProeficiency;
    }

    public void setNatureProeficiency(boolean natureProeficiency) {
        this.natureProeficiency = natureProeficiency;
    }

    public int getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(int acrobatics) {
        this.acrobatics = acrobatics;
    }

    public boolean isAcrobaticsProeficiency() {
        return acrobaticsProeficiency;
    }

    public void setAcrobaticsProeficiency(boolean acrobaticsProeficiency) {
        this.acrobaticsProeficiency = acrobaticsProeficiency;
    }

    public int getAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(int animalHandling) {
        this.animalHandling = animalHandling;
    }

    public boolean isAnimalHandlingProeficiency() {
        return animalHandlingProeficiency;
    }

    public void setAnimalHandlingProeficiency(boolean animalHandlingProeficiency) {
        this.animalHandlingProeficiency = animalHandlingProeficiency;
    }

    public int getArcana() {
        return arcana;
    }

    public void setArcana(int arcana) {
        this.arcana = arcana;
    }

    public boolean isArcanaProeficiency() {
        return arcanaProeficiency;
    }

    public void setArcanaProeficiency(boolean arcanaProeficiency) {
        this.arcanaProeficiency = arcanaProeficiency;
    }

    public int getAthletics() {
        return athletics;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    public boolean isAthleticsProeficiency() {
        return athleticsProeficiency;
    }

    public void setAthleticsProeficiency(boolean athleticsProeficiency) {
        this.athleticsProeficiency = athleticsProeficiency;
    }

    public int getDeception() {
        return deception;
    }

    public void setDeception(int deception) {
        this.deception = deception;
    }

    public boolean isDeceptionProeficiency() {
        return deceptionProeficiency;
    }

    public void setDeceptionProeficiency(boolean deceptionProeficiency) {
        this.deceptionProeficiency = deceptionProeficiency;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public boolean isHistoryProeficiency() {
        return historyProeficiency;
    }

    public void setHistoryProeficiency(boolean historyProeficiency) {
        this.historyProeficiency = historyProeficiency;
    }

    public int getInsight() {
        return insight;
    }

    public void setInsight(int insight) {
        this.insight = insight;
    }

    public boolean isInsightProeficiency() {
        return insightProeficiency;
    }

    public void setInsightProeficiency(boolean insightProeficiency) {
        this.insightProeficiency = insightProeficiency;
    }

    public int getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(int intimidation) {
        this.intimidation = intimidation;
    }

    public boolean isIntimidationProeficiency() {
        return intimidationProeficiency;
    }

    public void setIntimidationProeficiency(boolean intimidationProeficiency) {
        this.intimidationProeficiency = intimidationProeficiency;
    }

    public int getInvestigation() {
        return investigation;
    }

    public void setInvestigation(int investigation) {
        this.investigation = investigation;
    }

    public boolean isInvestigationProeficiency() {
        return investigationProeficiency;
    }

    public void setInvestigationProeficiency(boolean investigationProeficiency) {
        this.investigationProeficiency = investigationProeficiency;
    }

    public int getMedicine() {
        return medicine;
    }

    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }

    public boolean isMedicineProeficiency() {
        return medicineProeficiency;
    }

    public void setMedicineProeficiency(boolean medicineProeficiency) {
        this.medicineProeficiency = medicineProeficiency;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public boolean isPerceptionProeficiency() {
        return perceptionProeficiency;
    }

    public void setPerceptionProeficiency(boolean perceptionProeficiency) {
        this.perceptionProeficiency = perceptionProeficiency;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public boolean isPerformanceProeficiency() {
        return performanceProeficiency;
    }

    public void setPerformanceProeficiency(boolean performanceProeficiency) {
        this.performanceProeficiency = performanceProeficiency;
    }

    public int getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    public boolean isPersuasionProeficiency() {
        return persuasionProeficiency;
    }

    public void setPersuasionProeficiency(boolean persuasionProeficiency) {
        this.persuasionProeficiency = persuasionProeficiency;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public boolean isReligionProeficiency() {
        return religionProeficiency;
    }

    public void setReligionProeficiency(boolean religionProeficiency) {
        this.religionProeficiency = religionProeficiency;
    }

    public int getSleightOf() {
        return sleightOf;
    }

    public void setSleightOf(int sleightOf) {
        this.sleightOf = sleightOf;
    }

    public boolean isSleightOfProeficiency() {
        return sleightOfProeficiency;
    }

    public void setSleightOfProeficiency(boolean sleightOfProeficiency) {
        this.sleightOfProeficiency = sleightOfProeficiency;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public boolean isStealthProeficiency() {
        return stealthProeficiency;
    }

    public void setStealthProeficiency(boolean stealthProeficiency) {
        this.stealthProeficiency = stealthProeficiency;
    }

    public int getSurvival() {
        return survival;
    }

    public void setSurvival(int survival) {
        this.survival = survival;
    }

    public boolean isSurvivalProeficiency() {
        return survivalProeficiency;
    }

    public void setSurvivalProeficiency(boolean survivalProeficiency) {
        this.survivalProeficiency = survivalProeficiency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
