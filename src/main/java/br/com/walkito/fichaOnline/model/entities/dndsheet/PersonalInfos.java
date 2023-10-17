package br.com.walkito.fichaOnline.model.entities.dndsheet;

import br.com.walkito.fichaOnline.model.entities.SheetDnD;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "dnd_personal_infos")
public class PersonalInfos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 35)
    @Size(max = 35)
    @NotBlank
    private String characterName;

    @Column(nullable = false, length = 35, name = "class")
    @Size(max = 35)
    @NotBlank
    private String _class;

    @Column(nullable = false, precision = 2)
    @Min(1)
    @Max(20)
    private int level;

    @Column(nullable = false, length = 30)
    @Size(max = 30)
    private String antecedent;

    @Column(nullable = false, length = 35)
    @Size(max = 35)
    @NotBlank
    private String playerName;

    @Column(nullable = false, length = 25)
    @Size(max = 25)
    @NotBlank
    private String race;

    @Column(nullable = false, length = 30)
    @Size(max = 30)
    @NotBlank
    private String trend;

    @Column(nullable = false, precision = 7)
    @Max(9999999)
    @Min(0)
    @NotNull
    private int experience;

    @Column(precision = 4)
    @Max(9999)
    @Min(0)
    private int age;

    @Column(precision = 3)
    @Min(0)
    private double height;

    @Column(precision = 5)
    @Min(0)
    private double weight;

    @Column(length = 15)
    @Size(max = 15)
    private String eyes;

    @Column(length = 15)
    @Size(max = 15)
    private String skin;

    @Column(length = 15)
    @Size(max = 15)
    private String hair;

    @OneToOne
    @JsonBackReference
    private SheetDnD sheetDnD;

    public PersonalInfos() {
    }

    public PersonalInfos(String characterName, String _class, int level, String antecedent, String playerName, String race, String trend, int experience, int age, double heigth, double weigth, String eyes, String skin, String hair) {
        this.characterName = characterName;
        this._class = _class;
        this.level = level;
        this.antecedent = antecedent;
        this.playerName = playerName;
        this.race = race;
        this.trend = trend;
        this.experience = experience;
        this.age = age;
        this.height = heigth;
        this.weight = weigth;
        this.eyes = eyes;
        this.skin = skin;
        this.hair = hair;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(String antecedent) {
        this.antecedent = antecedent;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getTrend() {
        return trend;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public SheetDnD getSheetDnD() {
        return sheetDnD;
    }

    public void setSheetDnD(SheetDnD sheetDnD) {
        this.sheetDnD = sheetDnD;
    }
}
