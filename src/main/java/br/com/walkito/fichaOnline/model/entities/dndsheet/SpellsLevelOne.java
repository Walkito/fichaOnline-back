package br.com.walkito.fichaOnline.model.entities.dndsheet;


import br.com.walkito.fichaOnline.model.entities.SheetDnD;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "dnd_spells_one")
public class SpellsLevelOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 1)
    private int level1TotalSlots;

    @Column(precision = 1)
    private int level1SlotsExpended;

    @Column(length = 20)
    private String level1Slot1;

    @Column
    private boolean level1Prepared1;

    @Column(length = 20)
    private String level1Slot2;

    @Column
    private boolean level1Prepared2;

    @Column(length = 20)
    private String level1Slot3;

    @Column
    private boolean level1Prepared3;

    @Column(length = 20)
    private String level1Slot4;

    @Column
    private boolean level1Prepared4;

    @Column(length = 20)
    private String level1Slot5;

    @Column
    private boolean level1Prepared5;

    @Column(length = 20)
    private String level1Slot6;

    @Column
    private boolean level1Prepared6;

    @Column(length = 20)
    private String level1Slot7;

    @Column
    private boolean level1Prepared7;

    @Column(length = 20)
    private String level1Slot8;

    @Column
    private boolean level1Prepared8;

    @Column(length = 20)
    private String level1Slot9;

    @Column
    private boolean level1Prepared9;

    @Column(length = 20)
    private String level1Slot10;

    @Column
    private boolean level1Prepared10;

    @Column(length = 20)
    private String level1Slot11;

    @Column
    private boolean level1Prepared11;

    @Column(length = 20)
    private String level1Slot12;

    @Column
    private boolean level1Prepared12;

    @OneToOne
    @JsonIgnore
    private SheetDnD sheetDnD;

    public SpellsLevelOne() {
    }

    public SpellsLevelOne(int level1TotalSlots, int level1SlotsExpended, String level1Slot1, boolean level1Prepared1, String level1Slot2, boolean level1Prepared2, String level1Slot3, boolean level1Prepared3, String level1Slot4, boolean level1Prepared4, String level1Slot5, boolean level1Prepared5, String level1Slot6, boolean level1Prepared6, String level1Slot7, boolean level1Prepared7, String level1Slot8, boolean level1Prepared8, String level1Slot9, boolean level1Prepared9, String level1Slot10, boolean level1Prepared10, String level1Slot11, boolean level1Prepared11, String level1Slot12, boolean level1Prepared12) {
        this.level1TotalSlots = level1TotalSlots;
        this.level1SlotsExpended = level1SlotsExpended;
        this.level1Slot1 = level1Slot1;
        this.level1Prepared1 = level1Prepared1;
        this.level1Slot2 = level1Slot2;
        this.level1Prepared2 = level1Prepared2;
        this.level1Slot3 = level1Slot3;
        this.level1Prepared3 = level1Prepared3;
        this.level1Slot4 = level1Slot4;
        this.level1Prepared4 = level1Prepared4;
        this.level1Slot5 = level1Slot5;
        this.level1Prepared5 = level1Prepared5;
        this.level1Slot6 = level1Slot6;
        this.level1Prepared6 = level1Prepared6;
        this.level1Slot7 = level1Slot7;
        this.level1Prepared7 = level1Prepared7;
        this.level1Slot8 = level1Slot8;
        this.level1Prepared8 = level1Prepared8;
        this.level1Slot9 = level1Slot9;
        this.level1Prepared9 = level1Prepared9;
        this.level1Slot10 = level1Slot10;
        this.level1Prepared10 = level1Prepared10;
        this.level1Slot11 = level1Slot11;
        this.level1Prepared11 = level1Prepared11;
        this.level1Slot12 = level1Slot12;
        this.level1Prepared12 = level1Prepared12;
    }

    public int getLevel1TotalSlots() {
        return level1TotalSlots;
    }

    public void setLevel1TotalSlots(int level1TotalSlots) {
        this.level1TotalSlots = level1TotalSlots;
    }

    public int getLevel1SlotsExpended() {
        return level1SlotsExpended;
    }

    public void setLevel1SlotsExpended(int level1SlotsExpended) {
        this.level1SlotsExpended = level1SlotsExpended;
    }

    public String getLevel1Slot1() {
        return level1Slot1;
    }

    public void setLevel1Slot1(String level1Slot1) {
        this.level1Slot1 = level1Slot1;
    }

    public boolean isLevel1Prepared1() {
        return level1Prepared1;
    }

    public void setLevel1Prepared1(boolean level1Prepared1) {
        this.level1Prepared1 = level1Prepared1;
    }

    public String getLevel1Slot2() {
        return level1Slot2;
    }

    public void setLevel1Slot2(String level1Slot2) {
        this.level1Slot2 = level1Slot2;
    }

    public boolean isLevel1Prepared2() {
        return level1Prepared2;
    }

    public void setLevel1Prepared2(boolean level1Prepared2) {
        this.level1Prepared2 = level1Prepared2;
    }

    public String getLevel1Slot3() {
        return level1Slot3;
    }

    public void setLevel1Slot3(String level1Slot3) {
        this.level1Slot3 = level1Slot3;
    }

    public boolean isLevel1Prepared3() {
        return level1Prepared3;
    }

    public void setLevel1Prepared3(boolean level1Prepared3) {
        this.level1Prepared3 = level1Prepared3;
    }

    public String getLevel1Slot4() {
        return level1Slot4;
    }

    public void setLevel1Slot4(String level1Slot4) {
        this.level1Slot4 = level1Slot4;
    }

    public boolean isLevel1Prepared4() {
        return level1Prepared4;
    }

    public void setLevel1Prepared4(boolean level1Prepared4) {
        this.level1Prepared4 = level1Prepared4;
    }

    public String getLevel1Slot5() {
        return level1Slot5;
    }

    public void setLevel1Slot5(String level1Slot5) {
        this.level1Slot5 = level1Slot5;
    }

    public boolean isLevel1Prepared5() {
        return level1Prepared5;
    }

    public void setLevel1Prepared5(boolean level1Prepared5) {
        this.level1Prepared5 = level1Prepared5;
    }

    public String getLevel1Slot6() {
        return level1Slot6;
    }

    public void setLevel1Slot6(String level1Slot6) {
        this.level1Slot6 = level1Slot6;
    }

    public boolean isLevel1Prepared6() {
        return level1Prepared6;
    }

    public void setLevel1Prepared6(boolean level1Prepared6) {
        this.level1Prepared6 = level1Prepared6;
    }

    public String getLevel1Slot7() {
        return level1Slot7;
    }

    public void setLevel1Slot7(String level1Slot7) {
        this.level1Slot7 = level1Slot7;
    }

    public boolean isLevel1Prepared7() {
        return level1Prepared7;
    }

    public void setLevel1Prepared7(boolean level1Prepared7) {
        this.level1Prepared7 = level1Prepared7;
    }

    public String getLevel1Slot8() {
        return level1Slot8;
    }

    public void setLevel1Slot8(String level1Slot8) {
        this.level1Slot8 = level1Slot8;
    }

    public boolean isLevel1Prepared8() {
        return level1Prepared8;
    }

    public void setLevel1Prepared8(boolean level1Prepared8) {
        this.level1Prepared8 = level1Prepared8;
    }

    public String getLevel1Slot9() {
        return level1Slot9;
    }

    public void setLevel1Slot9(String level1Slot9) {
        this.level1Slot9 = level1Slot9;
    }

    public boolean isLevel1Prepared9() {
        return level1Prepared9;
    }

    public void setLevel1Prepared9(boolean level1Prepared9) {
        this.level1Prepared9 = level1Prepared9;
    }

    public String getLevel1Slot10() {
        return level1Slot10;
    }

    public void setLevel1Slot10(String level1Slot10) {
        this.level1Slot10 = level1Slot10;
    }

    public boolean isLevel1Prepared10() {
        return level1Prepared10;
    }

    public void setLevel1Prepared10(boolean level1Prepared10) {
        this.level1Prepared10 = level1Prepared10;
    }

    public String getLevel1Slot11() {
        return level1Slot11;
    }

    public void setLevel1Slot11(String level1Slot11) {
        this.level1Slot11 = level1Slot11;
    }

    public boolean isLevel1Prepared11() {
        return level1Prepared11;
    }

    public void setLevel1Prepared11(boolean level1Prepared11) {
        this.level1Prepared11 = level1Prepared11;
    }

    public String getLevel1Slot12() {
        return level1Slot12;
    }

    public void setLevel1Slot12(String level1Slot12) {
        this.level1Slot12 = level1Slot12;
    }

    public boolean isLevel1Prepared12() {
        return level1Prepared12;
    }

    public void setLevel1Prepared12(boolean level1Prepared12) {
        this.level1Prepared12 = level1Prepared12;
    }

    public SheetDnD getSheetDnD() {
        return sheetDnD;
    }

    public void setSheetDnD(SheetDnD sheetDnD) {
        this.sheetDnD = sheetDnD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
