package br.com.walkito.fichaOnline.model.entities.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "dnd_spells_three")
public class SpellsLevelThree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 1)
    private int level3TotalSlots;

    @Column(precision = 1)
    private int level3SlotsExpended;

    @Column(length = 20)
    private String level3Slot1;

    @Column
    private boolean level3Prepared1;

    @Column(length = 20)
    private String level3Slot2;

    @Column
    private boolean level3Prepared2;

    @Column(length = 20)
    private String level3Slot3;

    @Column
    private boolean level3Prepared3;

    @Column(length = 20)
    private String level3Slot4;

    @Column
    private boolean level3Prepared4;

    @Column(length = 20)
    private String level3Slot5;

    @Column
    private boolean level3Prepared5;

    @Column(length = 20)
    private String level3Slot6;

    @Column
    private boolean level3Prepared6;

    @Column(length = 20)
    private String level3Slot7;

    @Column
    private boolean level3Prepared7;

    @Column(length = 20)
    private String level3Slot8;

    @Column
    private boolean level3Prepared8;

    @Column(length = 20)
    private String level3Slot9;

    @Column
    private boolean level3Prepared9;

    @Column(length = 20)
    private String level3Slot10;

    @Column
    private boolean level3Prepared10;

    @Column(length = 20)
    private String level3Slot11;

    @Column
    private boolean level3Prepared11;

    @Column(length = 20)
    private String level3Slot12;

    @Column
    private boolean level3Prepared12;

    @Column(length = 20)
    private String level3Slot13;

    @Column
    private boolean level3Prepared13;

    @OneToOne
    @JsonIgnore
    private SheetDnD sheetDnD;

    public SpellsLevelThree(){

    }

    public SpellsLevelThree(int level3TotalSlots, int level3SlotsExpended, String level3Slot1, boolean level3Prepared1, String level3Slot2, boolean level3Prepared2, String level3Slot3, boolean level3Prepared3, String level3Slot4, boolean level3Prepared4, String level3Slot5, boolean level3Prepared5, String level3Slot6, boolean level3Prepared6, String level3Slot7, boolean level3Prepared7, String level3Slot8, boolean level3Prepared8, String level3Slot9, boolean level3Prepared9, String level3Slot10, boolean level3Prepared10, String level3Slot11, boolean level3Prepared11, String level3Slot12, boolean level3Prepared12, String level3Slot13, boolean level3Prepared13) {
        this.level3TotalSlots = level3TotalSlots;
        this.level3SlotsExpended = level3SlotsExpended;
        this.level3Slot1 = level3Slot1;
        this.level3Prepared1 = level3Prepared1;
        this.level3Slot2 = level3Slot2;
        this.level3Prepared2 = level3Prepared2;
        this.level3Slot3 = level3Slot3;
        this.level3Prepared3 = level3Prepared3;
        this.level3Slot4 = level3Slot4;
        this.level3Prepared4 = level3Prepared4;
        this.level3Slot5 = level3Slot5;
        this.level3Prepared5 = level3Prepared5;
        this.level3Slot6 = level3Slot6;
        this.level3Prepared6 = level3Prepared6;
        this.level3Slot7 = level3Slot7;
        this.level3Prepared7 = level3Prepared7;
        this.level3Slot8 = level3Slot8;
        this.level3Prepared8 = level3Prepared8;
        this.level3Slot9 = level3Slot9;
        this.level3Prepared9 = level3Prepared9;
        this.level3Slot10 = level3Slot10;
        this.level3Prepared10 = level3Prepared10;
        this.level3Slot11 = level3Slot11;
        this.level3Prepared11 = level3Prepared11;
        this.level3Slot12 = level3Slot12;
        this.level3Prepared12 = level3Prepared12;
        this.level3Slot13 = level3Slot13;
        this.level3Prepared13 = level3Prepared13;
    }

    public int getLevel3TotalSlots() {
        return level3TotalSlots;
    }

    public void setLevel3TotalSlots(int level3TotalSlots) {
        this.level3TotalSlots = level3TotalSlots;
    }

    public int getLevel3SlotsExpended() {
        return level3SlotsExpended;
    }

    public void setLevel3SlotsExpended(int level3SlotsExpended) {
        this.level3SlotsExpended = level3SlotsExpended;
    }

    public String getLevel3Slot1() {
        return level3Slot1;
    }

    public void setLevel3Slot1(String level3Slot1) {
        this.level3Slot1 = level3Slot1;
    }

    public boolean isLevel3Prepared1() {
        return level3Prepared1;
    }

    public void setLevel3Prepared1(boolean level3Prepared1) {
        this.level3Prepared1 = level3Prepared1;
    }

    public String getLevel3Slot2() {
        return level3Slot2;
    }

    public void setLevel3Slot2(String level3Slot2) {
        this.level3Slot2 = level3Slot2;
    }

    public boolean isLevel3Prepared2() {
        return level3Prepared2;
    }

    public void setLevel3Prepared2(boolean level3Prepared2) {
        this.level3Prepared2 = level3Prepared2;
    }

    public String getLevel3Slot3() {
        return level3Slot3;
    }

    public void setLevel3Slot3(String level3Slot3) {
        this.level3Slot3 = level3Slot3;
    }

    public boolean isLevel3Prepared3() {
        return level3Prepared3;
    }

    public void setLevel3Prepared3(boolean level3Prepared3) {
        this.level3Prepared3 = level3Prepared3;
    }

    public String getLevel3Slot4() {
        return level3Slot4;
    }

    public void setLevel3Slot4(String level3Slot4) {
        this.level3Slot4 = level3Slot4;
    }

    public boolean isLevel3Prepared4() {
        return level3Prepared4;
    }

    public void setLevel3Prepared4(boolean level3Prepared4) {
        this.level3Prepared4 = level3Prepared4;
    }

    public String getLevel3Slot5() {
        return level3Slot5;
    }

    public void setLevel3Slot5(String level3Slot5) {
        this.level3Slot5 = level3Slot5;
    }

    public boolean isLevel3Prepared5() {
        return level3Prepared5;
    }

    public void setLevel3Prepared5(boolean level3Prepared5) {
        this.level3Prepared5 = level3Prepared5;
    }

    public String getLevel3Slot6() {
        return level3Slot6;
    }

    public void setLevel3Slot6(String level3Slot6) {
        this.level3Slot6 = level3Slot6;
    }

    public boolean isLevel3Prepared6() {
        return level3Prepared6;
    }

    public void setLevel3Prepared6(boolean level3Prepared6) {
        this.level3Prepared6 = level3Prepared6;
    }

    public String getLevel3Slot7() {
        return level3Slot7;
    }

    public void setLevel3Slot7(String level3Slot7) {
        this.level3Slot7 = level3Slot7;
    }

    public boolean isLevel3Prepared7() {
        return level3Prepared7;
    }

    public void setLevel3Prepared7(boolean level3Prepared7) {
        this.level3Prepared7 = level3Prepared7;
    }

    public String getLevel3Slot8() {
        return level3Slot8;
    }

    public void setLevel3Slot8(String level3Slot8) {
        this.level3Slot8 = level3Slot8;
    }

    public boolean isLevel3Prepared8() {
        return level3Prepared8;
    }

    public void setLevel3Prepared8(boolean level3Prepared8) {
        this.level3Prepared8 = level3Prepared8;
    }

    public String getLevel3Slot9() {
        return level3Slot9;
    }

    public void setLevel3Slot9(String level3Slot9) {
        this.level3Slot9 = level3Slot9;
    }

    public boolean isLevel3Prepared9() {
        return level3Prepared9;
    }

    public void setLevel3Prepared9(boolean level3Prepared9) {
        this.level3Prepared9 = level3Prepared9;
    }

    public String getLevel3Slot10() {
        return level3Slot10;
    }

    public void setLevel3Slot10(String level3Slot10) {
        this.level3Slot10 = level3Slot10;
    }

    public boolean isLevel3Prepared10() {
        return level3Prepared10;
    }

    public void setLevel3Prepared10(boolean level3Prepared10) {
        this.level3Prepared10 = level3Prepared10;
    }

    public String getLevel3Slot11() {
        return level3Slot11;
    }

    public void setLevel3Slot11(String level3Slot11) {
        this.level3Slot11 = level3Slot11;
    }

    public boolean isLevel3Prepared11() {
        return level3Prepared11;
    }

    public void setLevel3Prepared11(boolean level3Prepared11) {
        this.level3Prepared11 = level3Prepared11;
    }

    public String getLevel3Slot12() {
        return level3Slot12;
    }

    public void setLevel3Slot12(String level3Slot12) {
        this.level3Slot12 = level3Slot12;
    }

    public boolean isLevel3Prepared12() {
        return level3Prepared12;
    }

    public void setLevel3Prepared12(boolean level3Prepared12) {
        this.level3Prepared12 = level3Prepared12;
    }

    public String getLevel3Slot13() {
        return level3Slot13;
    }

    public void setLevel3Slot13(String level3Slot13) {
        this.level3Slot13 = level3Slot13;
    }

    public boolean isLevel3Prepared13() {
        return level3Prepared13;
    }

    public void setLevel3Prepared13(boolean level3Prepared13) {
        this.level3Prepared13 = level3Prepared13;
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
