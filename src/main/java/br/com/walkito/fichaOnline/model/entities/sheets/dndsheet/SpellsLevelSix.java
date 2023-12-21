package br.com.walkito.fichaOnline.model.entities.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "dnd_spells_six")
public class SpellsLevelSix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 1)
    private int level6TotalSlots;

    @Column(precision = 1)
    private int level6SlotsExpended;

    @Column(length = 20)
    private String level6Slot1;

    @Column
    private boolean level6Prepared1;

    @Column(length = 20)
    private String level6Slot2;

    @Column
    private boolean level6Prepared2;

    @Column(length = 20)
    private String level6Slot3;

    @Column
    private boolean level6Prepared3;

    @Column(length = 20)
    private String level6Slot4;

    @Column
    private boolean level6Prepared4;

    @Column(length = 20)
    private String level6Slot5;

    @Column
    private boolean level6Prepared5;

    @Column(length = 20)
    private String level6Slot6;

    @Column
    private boolean level6Prepared6;

    @Column(length = 20)
    private String level6Slot7;

    @Column
    private boolean level6Prepared7;

    @Column(length = 20)
    private String level6Slot8;

    @Column
    private boolean level6Prepared8;

    @Column(length = 20)
    private String level6Slot9;

    @Column
    private boolean level6Prepared9;

    @OneToOne
    @JsonIgnore
    private SheetDnD sheetDnD;

    public SpellsLevelSix() {
    }

    public SpellsLevelSix(int level6TotalSlots, int level6SlotsExpended, String level6Slot1, boolean level6Prepared1, String level6Slot2, boolean level6Prepared2, String level6Slot3, boolean level6Prepared3, String level6Slot4, boolean level6Prepared4, String level6Slot5, boolean level6Prepared5, String level6Slot6, boolean level6Prepared6, String level6Slot7, boolean level6Prepared7, String level6Slot8, boolean level6Prepared8, String level6Slot9, boolean level6Prepared9) {
        this.level6TotalSlots = level6TotalSlots;
        this.level6SlotsExpended = level6SlotsExpended;
        this.level6Slot1 = level6Slot1;
        this.level6Prepared1 = level6Prepared1;
        this.level6Slot2 = level6Slot2;
        this.level6Prepared2 = level6Prepared2;
        this.level6Slot3 = level6Slot3;
        this.level6Prepared3 = level6Prepared3;
        this.level6Slot4 = level6Slot4;
        this.level6Prepared4 = level6Prepared4;
        this.level6Slot5 = level6Slot5;
        this.level6Prepared5 = level6Prepared5;
        this.level6Slot6 = level6Slot6;
        this.level6Prepared6 = level6Prepared6;
        this.level6Slot7 = level6Slot7;
        this.level6Prepared7 = level6Prepared7;
        this.level6Slot8 = level6Slot8;
        this.level6Prepared8 = level6Prepared8;
        this.level6Slot9 = level6Slot9;
        this.level6Prepared9 = level6Prepared9;
    }

    public int getLevel6TotalSlots() {
        return level6TotalSlots;
    }

    public void setLevel6TotalSlots(int level6TotalSlots) {
        this.level6TotalSlots = level6TotalSlots;
    }

    public int getLevel6SlotsExpended() {
        return level6SlotsExpended;
    }

    public void setLevel6SlotsExpended(int level6SlotsExpended) {
        this.level6SlotsExpended = level6SlotsExpended;
    }

    public String getLevel6Slot1() {
        return level6Slot1;
    }

    public void setLevel6Slot1(String level6Slot1) {
        this.level6Slot1 = level6Slot1;
    }

    public boolean isLevel6Prepared1() {
        return level6Prepared1;
    }

    public void setLevel6Prepared1(boolean level6Prepared1) {
        this.level6Prepared1 = level6Prepared1;
    }

    public String getLevel6Slot2() {
        return level6Slot2;
    }

    public void setLevel6Slot2(String level6Slot2) {
        this.level6Slot2 = level6Slot2;
    }

    public boolean isLevel6Prepared2() {
        return level6Prepared2;
    }

    public void setLevel6Prepared2(boolean level6Prepared2) {
        this.level6Prepared2 = level6Prepared2;
    }

    public String getLevel6Slot3() {
        return level6Slot3;
    }

    public void setLevel6Slot3(String level6Slot3) {
        this.level6Slot3 = level6Slot3;
    }

    public boolean isLevel6Prepared3() {
        return level6Prepared3;
    }

    public void setLevel6Prepared3(boolean level6Prepared3) {
        this.level6Prepared3 = level6Prepared3;
    }

    public String getLevel6Slot4() {
        return level6Slot4;
    }

    public void setLevel6Slot4(String level6Slot4) {
        this.level6Slot4 = level6Slot4;
    }

    public boolean isLevel6Prepared4() {
        return level6Prepared4;
    }

    public void setLevel6Prepared4(boolean level6Prepared4) {
        this.level6Prepared4 = level6Prepared4;
    }

    public String getLevel6Slot5() {
        return level6Slot5;
    }

    public void setLevel6Slot5(String level6Slot5) {
        this.level6Slot5 = level6Slot5;
    }

    public boolean isLevel6Prepared5() {
        return level6Prepared5;
    }

    public void setLevel6Prepared5(boolean level6Prepared5) {
        this.level6Prepared5 = level6Prepared5;
    }

    public String getLevel6Slot6() {
        return level6Slot6;
    }

    public void setLevel6Slot6(String level6Slot6) {
        this.level6Slot6 = level6Slot6;
    }

    public boolean isLevel6Prepared6() {
        return level6Prepared6;
    }

    public void setLevel6Prepared6(boolean level6Prepared6) {
        this.level6Prepared6 = level6Prepared6;
    }

    public String getLevel6Slot7() {
        return level6Slot7;
    }

    public void setLevel6Slot7(String level6Slot7) {
        this.level6Slot7 = level6Slot7;
    }

    public boolean isLevel6Prepared7() {
        return level6Prepared7;
    }

    public void setLevel6Prepared7(boolean level6Prepared7) {
        this.level6Prepared7 = level6Prepared7;
    }

    public String getLevel6Slot8() {
        return level6Slot8;
    }

    public void setLevel6Slot8(String level6Slot8) {
        this.level6Slot8 = level6Slot8;
    }

    public boolean isLevel6Prepared8() {
        return level6Prepared8;
    }

    public void setLevel6Prepared8(boolean level6Prepared8) {
        this.level6Prepared8 = level6Prepared8;
    }

    public String getLevel6Slot9() {
        return level6Slot9;
    }

    public void setLevel6Slot9(String level6Slot9) {
        this.level6Slot9 = level6Slot9;
    }

    public boolean isLevel6Prepared9() {
        return level6Prepared9;
    }

    public void setLevel6Prepared9(boolean level6Prepared9) {
        this.level6Prepared9 = level6Prepared9;
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
