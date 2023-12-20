package br.com.walkito.fichaOnline.model.entities.dndsheet;

import br.com.walkito.fichaOnline.model.entities.SheetDnD;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "dnd_spells_seven")
public class SpellsLevelSeven {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 1)
    private int level7TotalSlots;

    @Column(precision = 1)
    private int level7SlotsExpended;

    @Column(length = 20)
    private String level7Slot1;

    @Column
    private boolean level7Prepared1;

    @Column(length = 20)
    private String level7Slot2;

    @Column
    private boolean level7Prepared2;

    @Column(length = 20)
    private String level7Slot3;

    @Column
    private boolean level7Prepared3;

    @Column(length = 20)
    private String level7Slot4;

    @Column
    private boolean level7Prepared4;

    @Column(length = 20)
    private String level7Slot5;

    @Column
    private boolean level7Prepared5;

    @Column(length = 20)
    private String level7Slot6;

    @Column
    private boolean level7Prepared6;

    @Column(length = 20)
    private String level7Slot7;

    @Column
    private boolean level7Prepared7;

    @Column(length = 20)
    private String level7Slot8;

    @Column
    private boolean level7Prepared8;

    @Column(length = 20)
    private String level7Slot9;

    @Column
    private boolean level7Prepared9;

    @OneToOne
    @JsonIgnore
    private SheetDnD sheetDnD;

    public SpellsLevelSeven() {
    }

    public SpellsLevelSeven(int level7TotalSlots, int level7SlotsExpended, String level7Slot1, boolean level7Prepared1, String level7Slot2, boolean level7Prepared2, String level7Slot3, boolean level7Prepared3, String level7Slot4, boolean level7Prepared4, String level7Slot5, boolean level7Prepared5, String level7Slot6, boolean level7Prepared6, String level7Slot7, boolean level7Prepared7, String level7Slot8, boolean level7Prepared8, String level7Slot9, boolean level7Prepared9) {
        this.level7TotalSlots = level7TotalSlots;
        this.level7SlotsExpended = level7SlotsExpended;
        this.level7Slot1 = level7Slot1;
        this.level7Prepared1 = level7Prepared1;
        this.level7Slot2 = level7Slot2;
        this.level7Prepared2 = level7Prepared2;
        this.level7Slot3 = level7Slot3;
        this.level7Prepared3 = level7Prepared3;
        this.level7Slot4 = level7Slot4;
        this.level7Prepared4 = level7Prepared4;
        this.level7Slot5 = level7Slot5;
        this.level7Prepared5 = level7Prepared5;
        this.level7Slot6 = level7Slot6;
        this.level7Prepared6 = level7Prepared6;
        this.level7Slot7 = level7Slot7;
        this.level7Prepared7 = level7Prepared7;
        this.level7Slot8 = level7Slot8;
        this.level7Prepared8 = level7Prepared8;
        this.level7Slot9 = level7Slot9;
        this.level7Prepared9 = level7Prepared9;
    }

    public int getLevel7TotalSlots() {
        return level7TotalSlots;
    }

    public void setLevel7TotalSlots(int level7TotalSlots) {
        this.level7TotalSlots = level7TotalSlots;
    }

    public int getLevel7SlotsExpended() {
        return level7SlotsExpended;
    }

    public void setLevel7SlotsExpended(int level7SlotsExpended) {
        this.level7SlotsExpended = level7SlotsExpended;
    }

    public String getLevel7Slot1() {
        return level7Slot1;
    }

    public void setLevel7Slot1(String level7Slot1) {
        this.level7Slot1 = level7Slot1;
    }

    public boolean isLevel7Prepared1() {
        return level7Prepared1;
    }

    public void setLevel7Prepared1(boolean level7Prepared1) {
        this.level7Prepared1 = level7Prepared1;
    }

    public String getLevel7Slot2() {
        return level7Slot2;
    }

    public void setLevel7Slot2(String level7Slot2) {
        this.level7Slot2 = level7Slot2;
    }

    public boolean isLevel7Prepared2() {
        return level7Prepared2;
    }

    public void setLevel7Prepared2(boolean level7Prepared2) {
        this.level7Prepared2 = level7Prepared2;
    }

    public String getLevel7Slot3() {
        return level7Slot3;
    }

    public void setLevel7Slot3(String level7Slot3) {
        this.level7Slot3 = level7Slot3;
    }

    public boolean isLevel7Prepared3() {
        return level7Prepared3;
    }

    public void setLevel7Prepared3(boolean level7Prepared3) {
        this.level7Prepared3 = level7Prepared3;
    }

    public String getLevel7Slot4() {
        return level7Slot4;
    }

    public void setLevel7Slot4(String level7Slot4) {
        this.level7Slot4 = level7Slot4;
    }

    public boolean isLevel7Prepared4() {
        return level7Prepared4;
    }

    public void setLevel7Prepared4(boolean level7Prepared4) {
        this.level7Prepared4 = level7Prepared4;
    }

    public String getLevel7Slot5() {
        return level7Slot5;
    }

    public void setLevel7Slot5(String level7Slot5) {
        this.level7Slot5 = level7Slot5;
    }

    public boolean isLevel7Prepared5() {
        return level7Prepared5;
    }

    public void setLevel7Prepared5(boolean level7Prepared5) {
        this.level7Prepared5 = level7Prepared5;
    }

    public String getLevel7Slot6() {
        return level7Slot6;
    }

    public void setLevel7Slot6(String level7Slot6) {
        this.level7Slot6 = level7Slot6;
    }

    public boolean isLevel7Prepared6() {
        return level7Prepared6;
    }

    public void setLevel7Prepared6(boolean level7Prepared6) {
        this.level7Prepared6 = level7Prepared6;
    }

    public String getLevel7Slot7() {
        return level7Slot7;
    }

    public void setLevel7Slot7(String level7Slot7) {
        this.level7Slot7 = level7Slot7;
    }

    public boolean isLevel7Prepared7() {
        return level7Prepared7;
    }

    public void setLevel7Prepared7(boolean level7Prepared7) {
        this.level7Prepared7 = level7Prepared7;
    }

    public String getLevel7Slot8() {
        return level7Slot8;
    }

    public void setLevel7Slot8(String level7Slot8) {
        this.level7Slot8 = level7Slot8;
    }

    public boolean isLevel7Prepared8() {
        return level7Prepared8;
    }

    public void setLevel7Prepared8(boolean level7Prepared8) {
        this.level7Prepared8 = level7Prepared8;
    }

    public String getLevel7Slot9() {
        return level7Slot9;
    }

    public void setLevel7Slot9(String level7Slot9) {
        this.level7Slot9 = level7Slot9;
    }

    public boolean isLevel7Prepared9() {
        return level7Prepared9;
    }

    public void setLevel7Prepared9(boolean level7Prepared9) {
        this.level7Prepared9 = level7Prepared9;
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
