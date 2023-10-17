package br.com.walkito.fichaOnline.model.entities.dndsheet;

import br.com.walkito.fichaOnline.model.entities.SheetDnD;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "dnd_spells_five")
public class SpellsLevelFive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 1)
    private int level5TotalSlots;

    @Column(precision = 1)
    private int level5SlotsExpended;

    @Column(length = 20)
    private String level5Slot1;

    @Column
    private boolean level5Prepared1;

    @Column(length = 20)
    private String level5Slot2;

    @Column
    private boolean level5Prepared2;

    @Column(length = 20)
    private String level5Slot3;

    @Column
    private boolean level5Prepared3;

    @Column(length = 20)
    private String level5Slot4;

    @Column
    private boolean level5Prepared4;

    @Column(length = 20)
    private String level5Slot5;

    @Column
    private boolean level5Prepared5;

    @Column(length = 20)
    private String level5Slot6;

    @Column
    private boolean level5Prepared6;

    @Column(length = 20)
    private String level5Slot7;

    @Column
    private boolean level5Prepared7;

    @Column(length = 20)
    private String level5Slot8;

    @Column
    private boolean level5Prepared8;

    @Column(length = 20)
    private String level5Slot9;

    @Column
    private boolean level5Prepared9;

    @OneToOne
    @JsonBackReference
    private SheetDnD sheetDnD;

    public SpellsLevelFive() {
    }

    public SpellsLevelFive(int level5TotalSlots, int level5SlotsExpended, String level5Slot1, boolean level5Prepared1, String level5Slot2, boolean level5Prepared2, String level5Slot3, boolean level5Prepared3, String level5Slot4, boolean level5Prepared4, String level5Slot5, boolean level5Prepared5, String level5Slot6, boolean level5Prepared6, String level5Slot7, boolean level5Prepared7, String level5Slot8, boolean level5Prepared8, String level5Slot9, boolean level5Prepared9) {
        this.level5TotalSlots = level5TotalSlots;
        this.level5SlotsExpended = level5SlotsExpended;
        this.level5Slot1 = level5Slot1;
        this.level5Prepared1 = level5Prepared1;
        this.level5Slot2 = level5Slot2;
        this.level5Prepared2 = level5Prepared2;
        this.level5Slot3 = level5Slot3;
        this.level5Prepared3 = level5Prepared3;
        this.level5Slot4 = level5Slot4;
        this.level5Prepared4 = level5Prepared4;
        this.level5Slot5 = level5Slot5;
        this.level5Prepared5 = level5Prepared5;
        this.level5Slot6 = level5Slot6;
        this.level5Prepared6 = level5Prepared6;
        this.level5Slot7 = level5Slot7;
        this.level5Prepared7 = level5Prepared7;
        this.level5Slot8 = level5Slot8;
        this.level5Prepared8 = level5Prepared8;
        this.level5Slot9 = level5Slot9;
        this.level5Prepared9 = level5Prepared9;
    }

    public int getLevel5TotalSlots() {
        return level5TotalSlots;
    }

    public void setLevel5TotalSlots(int level5TotalSlots) {
        this.level5TotalSlots = level5TotalSlots;
    }

    public int getLevel5SlotsExpended() {
        return level5SlotsExpended;
    }

    public void setLevel5SlotsExpended(int level5SlotsExpended) {
        this.level5SlotsExpended = level5SlotsExpended;
    }

    public String getLevel5Slot1() {
        return level5Slot1;
    }

    public void setLevel5Slot1(String level5Slot1) {
        this.level5Slot1 = level5Slot1;
    }

    public boolean isLevel5Prepared1() {
        return level5Prepared1;
    }

    public void setLevel5Prepared1(boolean level5Prepared1) {
        this.level5Prepared1 = level5Prepared1;
    }

    public String getLevel5Slot2() {
        return level5Slot2;
    }

    public void setLevel5Slot2(String level5Slot2) {
        this.level5Slot2 = level5Slot2;
    }

    public boolean isLevel5Prepared2() {
        return level5Prepared2;
    }

    public void setLevel5Prepared2(boolean level5Prepared2) {
        this.level5Prepared2 = level5Prepared2;
    }

    public String getLevel5Slot3() {
        return level5Slot3;
    }

    public void setLevel5Slot3(String level5Slot3) {
        this.level5Slot3 = level5Slot3;
    }

    public boolean isLevel5Prepared3() {
        return level5Prepared3;
    }

    public void setLevel5Prepared3(boolean level5Prepared3) {
        this.level5Prepared3 = level5Prepared3;
    }

    public String getLevel5Slot4() {
        return level5Slot4;
    }

    public void setLevel5Slot4(String level5Slot4) {
        this.level5Slot4 = level5Slot4;
    }

    public boolean isLevel5Prepared4() {
        return level5Prepared4;
    }

    public void setLevel5Prepared4(boolean level5Prepared4) {
        this.level5Prepared4 = level5Prepared4;
    }

    public String getLevel5Slot5() {
        return level5Slot5;
    }

    public void setLevel5Slot5(String level5Slot5) {
        this.level5Slot5 = level5Slot5;
    }

    public boolean isLevel5Prepared5() {
        return level5Prepared5;
    }

    public void setLevel5Prepared5(boolean level5Prepared5) {
        this.level5Prepared5 = level5Prepared5;
    }

    public String getLevel5Slot6() {
        return level5Slot6;
    }

    public void setLevel5Slot6(String level5Slot6) {
        this.level5Slot6 = level5Slot6;
    }

    public boolean isLevel5Prepared6() {
        return level5Prepared6;
    }

    public void setLevel5Prepared6(boolean level5Prepared6) {
        this.level5Prepared6 = level5Prepared6;
    }

    public String getLevel5Slot7() {
        return level5Slot7;
    }

    public void setLevel5Slot7(String level5Slot7) {
        this.level5Slot7 = level5Slot7;
    }

    public boolean isLevel5Prepared7() {
        return level5Prepared7;
    }

    public void setLevel5Prepared7(boolean level5Prepared7) {
        this.level5Prepared7 = level5Prepared7;
    }

    public String getLevel5Slot8() {
        return level5Slot8;
    }

    public void setLevel5Slot8(String level5Slot8) {
        this.level5Slot8 = level5Slot8;
    }

    public boolean isLevel5Prepared8() {
        return level5Prepared8;
    }

    public void setLevel5Prepared8(boolean level5Prepared8) {
        this.level5Prepared8 = level5Prepared8;
    }

    public String getLevel5Slot9() {
        return level5Slot9;
    }

    public void setLevel5Slot9(String level5Slot9) {
        this.level5Slot9 = level5Slot9;
    }

    public boolean isLevel5Prepared9() {
        return level5Prepared9;
    }

    public void setLevel5Prepared9(boolean level5Prepared9) {
        this.level5Prepared9 = level5Prepared9;
    }

    public SheetDnD getSheetDnD() {
        return sheetDnD;
    }

    public void setSheetDnD(SheetDnD sheetDnD) {
        this.sheetDnD = sheetDnD;
    }
}
