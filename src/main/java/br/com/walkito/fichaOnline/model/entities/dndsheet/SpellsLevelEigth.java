package br.com.walkito.fichaOnline.model.entities.dndsheet;

import br.com.walkito.fichaOnline.model.entities.SheetDnD;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity(name = "dnd_spells_eigth")
public class SpellsLevelEigth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 1)
    private int level8TotalSlots;

    @Column(precision = 1)
    private int level8SlotsExpended;

    @Column(length = 20)
    private String level8Slot1;

    @Column
    private boolean level8Prepared1;

    @Column(length = 20)
    private String level8Slot2;

    @Column
    private boolean level8Prepared2;

    @Column(length = 20)
    private String level8Slot3;

    @Column
    private boolean level8Prepared3;

    @Column(length = 20)
    private String level8Slot4;

    @Column
    private boolean level8Prepared4;

    @Column(length = 20)
    private String level8Slot5;

    @Column
    private boolean level8Prepared5;

    @Column(length = 20)
    private String level8Slot6;

    @Column
    private boolean level8Prepared6;

    @Column(length = 20)
    private String level8Slot7;

    @Column
    private boolean level8Prepared7;

    @OneToOne
    @JsonBackReference
    private SheetDnD sheetDnD;

    public SpellsLevelEigth() {
    }

    public SpellsLevelEigth(int level8TotalSlots, int level8SlotsExpended, String level8Slot1, boolean level8Prepared1, String level8Slot2, boolean level8Prepared2, String level8Slot3, boolean level8Prepared3, String level8Slot4, boolean level8Prepared4, String level8Slot5, boolean level8Prepared5, String level8Slot6, boolean level8Prepared6, String level8Slot7, boolean level8Prepared7) {
        this.level8TotalSlots = level8TotalSlots;
        this.level8SlotsExpended = level8SlotsExpended;
        this.level8Slot1 = level8Slot1;
        this.level8Prepared1 = level8Prepared1;
        this.level8Slot2 = level8Slot2;
        this.level8Prepared2 = level8Prepared2;
        this.level8Slot3 = level8Slot3;
        this.level8Prepared3 = level8Prepared3;
        this.level8Slot4 = level8Slot4;
        this.level8Prepared4 = level8Prepared4;
        this.level8Slot5 = level8Slot5;
        this.level8Prepared5 = level8Prepared5;
        this.level8Slot6 = level8Slot6;
        this.level8Prepared6 = level8Prepared6;
        this.level8Slot7 = level8Slot7;
        this.level8Prepared7 = level8Prepared7;
    }

    public int getLevel8TotalSlots() {
        return level8TotalSlots;
    }

    public void setLevel8TotalSlots(int level8TotalSlots) {
        this.level8TotalSlots = level8TotalSlots;
    }

    public int getLevel8SlotsExpended() {
        return level8SlotsExpended;
    }

    public void setLevel8SlotsExpended(int level8SlotsExpended) {
        this.level8SlotsExpended = level8SlotsExpended;
    }

    public String getLevel8Slot1() {
        return level8Slot1;
    }

    public void setLevel8Slot1(String level8Slot1) {
        this.level8Slot1 = level8Slot1;
    }

    public boolean isLevel8Prepared1() {
        return level8Prepared1;
    }

    public void setLevel8Prepared1(boolean level8Prepared1) {
        this.level8Prepared1 = level8Prepared1;
    }

    public String getLevel8Slot2() {
        return level8Slot2;
    }

    public void setLevel8Slot2(String level8Slot2) {
        this.level8Slot2 = level8Slot2;
    }

    public boolean isLevel8Prepared2() {
        return level8Prepared2;
    }

    public void setLevel8Prepared2(boolean level8Prepared2) {
        this.level8Prepared2 = level8Prepared2;
    }

    public String getLevel8Slot3() {
        return level8Slot3;
    }

    public void setLevel8Slot3(String level8Slot3) {
        this.level8Slot3 = level8Slot3;
    }

    public boolean isLevel8Prepared3() {
        return level8Prepared3;
    }

    public void setLevel8Prepared3(boolean level8Prepared3) {
        this.level8Prepared3 = level8Prepared3;
    }

    public String getLevel8Slot4() {
        return level8Slot4;
    }

    public void setLevel8Slot4(String level8Slot4) {
        this.level8Slot4 = level8Slot4;
    }

    public boolean isLevel8Prepared4() {
        return level8Prepared4;
    }

    public void setLevel8Prepared4(boolean level8Prepared4) {
        this.level8Prepared4 = level8Prepared4;
    }

    public String getLevel8Slot5() {
        return level8Slot5;
    }

    public void setLevel8Slot5(String level8Slot5) {
        this.level8Slot5 = level8Slot5;
    }

    public boolean isLevel8Prepared5() {
        return level8Prepared5;
    }

    public void setLevel8Prepared5(boolean level8Prepared5) {
        this.level8Prepared5 = level8Prepared5;
    }

    public String getLevel8Slot6() {
        return level8Slot6;
    }

    public void setLevel8Slot6(String level8Slot6) {
        this.level8Slot6 = level8Slot6;
    }

    public boolean isLevel8Prepared6() {
        return level8Prepared6;
    }

    public void setLevel8Prepared6(boolean level8Prepared6) {
        this.level8Prepared6 = level8Prepared6;
    }

    public String getLevel8Slot7() {
        return level8Slot7;
    }

    public void setLevel8Slot7(String level8Slot7) {
        this.level8Slot7 = level8Slot7;
    }

    public boolean isLevel8Prepared7() {
        return level8Prepared7;
    }

    public void setLevel8Prepared7(boolean level8Prepared7) {
        this.level8Prepared7 = level8Prepared7;
    }

    public SheetDnD getSheetDnD() {
        return sheetDnD;
    }

    public void setSheetDnD(SheetDnD sheetDnD) {
        this.sheetDnD = sheetDnD;
    }
}
