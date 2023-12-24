package br.com.walkito.fichaOnline.model.entities.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dnd_attacks")
public class Attacks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 15)
    @Size(max = 15)
    private String atkName1;

    @Column(precision = 2)
    private int atkBonus1;

    @Column(length = 20)
    private String atkDamageType1;

    @Column(length = 15)
    @Size(max = 15)
    private String atkName2;

    @Column(precision = 2)
    private int atkBonus2;

    @Column(length = 20)
    private String atkDamageType2;

    @Column(length = 15)
    @Size(max = 15)
    private String atkName3;

    @Column(precision = 2)
    private int atkBonus3;

    @Column(length = 20)
    private String atkDamageType3;

    @Column(length = 15)
    @Size(max = 15)
    private String atkName4;

    @Column(precision = 2)
    private int atkBonus4;

    @Column(length = 20)
    private String atkDamageType4;

    @Column(length = 15)
    @Size(max = 15)
    private String atkName5;

    @Column(precision = 2)
    private int atkBonus5;

    @Column(length = 20)
    private String atkDamageType5;

    @Column(length = 15)
    @Size(max = 15)
    private String atkName6;

    @Column(precision = 2)
    private int atkBonus6;

    @Column(length = 20)
    private String atkDamageType6;

    @Column(length = 15)
    @Size(max = 15)
    private String atkName7;

    @Column(precision = 2)
    private int atkBonus7;

    @Column(length = 20)
    private String atkDamageType7;

    @Column(length = 15)
    @Size(max = 15)
    private String atkName8;

    @Column(precision = 2)
    private int atkBonus8;

    @Column(length = 20)
    private String atkDamageType8;

    @Column(length = 15)
    @Size(max = 15)
    private String atkName9;

    @Column(precision = 2)
    private int atkBonus9;

    @Column(length = 20)
    private String atkDamageType9;

    @Column(length = 15)
    @Size(max = 15)
    private String atkName10;

    @Column(precision = 2)
    private int atkBonus10;

    @Column(length = 20)
    private String atkDamageType10;

    public Attacks() {
    }

    public Attacks(String atkName1, int atkBonus1, String atkDamageType1, String atkName2, int atkBonus2, String atkDamageType2, String atkName3, int atkBonus3, String atkDamageType3, String atkName4, int atkBonus4, String atkDamageType4, String atkName5, int atkBonus5, String atkDamageType5, String atkName6, int atkBonus6, String atkDamageType6, String atkName7, int atkBonus7, String atkDamageType7, String atkName8, int atkBonus8, String atkDamageType8, String atkName9, int atkBonus9, String atkDamageType9, String atkName10, int atkBonus10, String atkDamageType10) {
        this.atkName1 = atkName1;
        this.atkBonus1 = atkBonus1;
        this.atkDamageType1 = atkDamageType1;
        this.atkName2 = atkName2;
        this.atkBonus2 = atkBonus2;
        this.atkDamageType2 = atkDamageType2;
        this.atkName3 = atkName3;
        this.atkBonus3 = atkBonus3;
        this.atkDamageType3 = atkDamageType3;
        this.atkName4 = atkName4;
        this.atkBonus4 = atkBonus4;
        this.atkDamageType4 = atkDamageType4;
        this.atkName5 = atkName5;
        this.atkBonus5 = atkBonus5;
        this.atkDamageType5 = atkDamageType5;
        this.atkName6 = atkName6;
        this.atkBonus6 = atkBonus6;
        this.atkDamageType6 = atkDamageType6;
        this.atkName7 = atkName7;
        this.atkBonus7 = atkBonus7;
        this.atkDamageType7 = atkDamageType7;
        this.atkName8 = atkName8;
        this.atkBonus8 = atkBonus8;
        this.atkDamageType8 = atkDamageType8;
        this.atkName9 = atkName9;
        this.atkBonus9 = atkBonus9;
        this.atkDamageType9 = atkDamageType9;
        this.atkName10 = atkName10;
        this.atkBonus10 = atkBonus10;
        this.atkDamageType10 = atkDamageType10;
    }

    public String getAtkName1() {
        return atkName1;
    }

    public void setAtkName1(String atkName1) {
        this.atkName1 = atkName1;
    }

    public int getAtkBonus1() {
        return atkBonus1;
    }

    public void setAtkBonus1(int atkBonus1) {
        this.atkBonus1 = atkBonus1;
    }

    public String getAtkDamageType1() {
        return atkDamageType1;
    }

    public void setAtkDamageType1(String atkDamageType1) {
        this.atkDamageType1 = atkDamageType1;
    }

    public String getAtkName2() {
        return atkName2;
    }

    public void setAtkName2(String atkName2) {
        this.atkName2 = atkName2;
    }

    public int getAtkBonus2() {
        return atkBonus2;
    }

    public void setAtkBonus2(int atkBonus2) {
        this.atkBonus2 = atkBonus2;
    }

    public String getAtkDamageType2() {
        return atkDamageType2;
    }

    public void setAtkDamageType2(String atkDamageType2) {
        this.atkDamageType2 = atkDamageType2;
    }

    public String getAtkName3() {
        return atkName3;
    }

    public void setAtkName3(String atkName3) {
        this.atkName3 = atkName3;
    }

    public int getAtkBonus3() {
        return atkBonus3;
    }

    public void setAtkBonus3(int atkBonus3) {
        this.atkBonus3 = atkBonus3;
    }

    public String getAtkDamageType3() {
        return atkDamageType3;
    }

    public void setAtkDamageType3(String atkDamageType3) {
        this.atkDamageType3 = atkDamageType3;
    }

    public String getAtkName4() {
        return atkName4;
    }

    public void setAtkName4(String atkName4) {
        this.atkName4 = atkName4;
    }

    public int getAtkBonus4() {
        return atkBonus4;
    }

    public void setAtkBonus4(int atkBonus4) {
        this.atkBonus4 = atkBonus4;
    }

    public String getAtkDamageType4() {
        return atkDamageType4;
    }

    public void setAtkDamageType4(String atkDamageType4) {
        this.atkDamageType4 = atkDamageType4;
    }

    public String getAtkName5() {
        return atkName5;
    }

    public void setAtkName5(String atkName5) {
        this.atkName5 = atkName5;
    }

    public int getAtkBonus5() {
        return atkBonus5;
    }

    public void setAtkBonus5(int atkBonus5) {
        this.atkBonus5 = atkBonus5;
    }

    public String getAtkDamageType5() {
        return atkDamageType5;
    }

    public void setAtkDamageType5(String atkDamageType5) {
        this.atkDamageType5 = atkDamageType5;
    }

    public String getAtkName6() {
        return atkName6;
    }

    public void setAtkName6(String atkName6) {
        this.atkName6 = atkName6;
    }

    public int getAtkBonus6() {
        return atkBonus6;
    }

    public void setAtkBonus6(int atkBonus6) {
        this.atkBonus6 = atkBonus6;
    }

    public String getAtkDamageType6() {
        return atkDamageType6;
    }

    public void setAtkDamageType6(String atkDamageType6) {
        this.atkDamageType6 = atkDamageType6;
    }

    public String getAtkName7() {
        return atkName7;
    }

    public void setAtkName7(String atkName7) {
        this.atkName7 = atkName7;
    }

    public int getAtkBonus7() {
        return atkBonus7;
    }

    public void setAtkBonus7(int atkBonus7) {
        this.atkBonus7 = atkBonus7;
    }

    public String getAtkDamageType7() {
        return atkDamageType7;
    }

    public void setAtkDamageType7(String atkDamageType7) {
        this.atkDamageType7 = atkDamageType7;
    }

    public String getAtkName8() {
        return atkName8;
    }

    public void setAtkName8(String atkName8) {
        this.atkName8 = atkName8;
    }

    public int getAtkBonus8() {
        return atkBonus8;
    }

    public void setAtkBonus8(int atkBonus8) {
        this.atkBonus8 = atkBonus8;
    }

    public String getAtkDamageType8() {
        return atkDamageType8;
    }

    public void setAtkDamageType8(String atkDamageType8) {
        this.atkDamageType8 = atkDamageType8;
    }

    public String getAtkName9() {
        return atkName9;
    }

    public void setAtkName9(String atkName9) {
        this.atkName9 = atkName9;
    }

    public int getAtkBonus9() {
        return atkBonus9;
    }

    public void setAtkBonus9(int atkBonus9) {
        this.atkBonus9 = atkBonus9;
    }

    public String getAtkDamageType9() {
        return atkDamageType9;
    }

    public void setAtkDamageType9(String atkDamageType9) {
        this.atkDamageType9 = atkDamageType9;
    }

    public String getAtkName10() {
        return atkName10;
    }

    public void setAtkName10(String atkName10) {
        this.atkName10 = atkName10;
    }

    public int getAtkBonus10() {
        return atkBonus10;
    }

    public void setAtkBonus10(int atkBonus10) {
        this.atkBonus10 = atkBonus10;
    }

    public String getAtkDamageType10() {
        return atkDamageType10;
    }

    public void setAtkDamageType10(String atkDamageType10) {
        this.atkDamageType10 = atkDamageType10;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
