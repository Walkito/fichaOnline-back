package br.com.walkito.fichaOnline.model.entities.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "dnd_spells_two")
public class SpellsLevelTwo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 2)
    private int level2TotalSlots;

    @Column(precision = 2)
    private int level2SlotsExpended;

    @Column(length = 60)
    private String level2Slot1;

    @Column
    private boolean level2Prepared1;

    @Column(length = 60)
    private String level2Slot2;

    @Column
    private boolean level2Prepared2;

    @Column(length = 60)
    private String level2Slot3;

    @Column
    private boolean level2Prepared3;

    @Column(length = 60)
    private String level2Slot4;

    @Column
    private boolean level2Prepared4;

    @Column(length = 60)
    private String level2Slot5;

    @Column
    private boolean level2Prepared5;

    @Column(length = 60)
    private String level2Slot6;

    @Column
    private boolean level2Prepared6;

    @Column(length = 60)
    private String level2Slot7;

    @Column
    private boolean level2Prepared7;

    @Column(length = 60)
    private String level2Slot8;

    @Column
    private boolean level2Prepared8;

    @Column(length = 60)
    private String level2Slot9;

    @Column
    private boolean level2Prepared9;

    @Column(length = 60)
    private String level2Slot10;

    @Column
    private boolean level2Prepared10;

    @Column(length = 60)
    private String level2Slot11;

    @Column
    private boolean level2Prepared11;

    @Column(length = 60)
    private String level2Slot12;

    @Column
    private boolean level2Prepared12;

    @Column(length = 60)
    private String level2Slot13;

    @Column
    private boolean level2Prepared13;

    public SpellsLevelTwo() {
    }

    public SpellsLevelTwo(int level2TotalSlots, int level2SlotsExpended, String level2Slot1, boolean level2Prepared1, String level2Slot2, boolean level2Prepared2, String level2Slot3, boolean level2Prepared3, String level2Slot4, boolean level2Prepared4, String level2Slot5, boolean level2Prepared5, String level2Slot6, boolean level2Prepared6, String level2Slot7, boolean level2Prepared7, String level2Slot8, boolean level2Prepared8, String level2Slot9, boolean level2Prepared9, String level2Slot10, boolean level2Prepared10, String level2Slot11, boolean level2Prepared11, String level2Slot12, boolean level2Prepared12, String level2Slot13, boolean level2Prepared13) {
        this.level2TotalSlots = level2TotalSlots;
        this.level2SlotsExpended = level2SlotsExpended;
        this.level2Slot1 = level2Slot1;
        this.level2Prepared1 = level2Prepared1;
        this.level2Slot2 = level2Slot2;
        this.level2Prepared2 = level2Prepared2;
        this.level2Slot3 = level2Slot3;
        this.level2Prepared3 = level2Prepared3;
        this.level2Slot4 = level2Slot4;
        this.level2Prepared4 = level2Prepared4;
        this.level2Slot5 = level2Slot5;
        this.level2Prepared5 = level2Prepared5;
        this.level2Slot6 = level2Slot6;
        this.level2Prepared6 = level2Prepared6;
        this.level2Slot7 = level2Slot7;
        this.level2Prepared7 = level2Prepared7;
        this.level2Slot8 = level2Slot8;
        this.level2Prepared8 = level2Prepared8;
        this.level2Slot9 = level2Slot9;
        this.level2Prepared9 = level2Prepared9;
        this.level2Slot10 = level2Slot10;
        this.level2Prepared10 = level2Prepared10;
        this.level2Slot11 = level2Slot11;
        this.level2Prepared11 = level2Prepared11;
        this.level2Slot12 = level2Slot12;
        this.level2Prepared12 = level2Prepared12;
        this.level2Slot13 = level2Slot13;
        this.level2Prepared13 = level2Prepared13;
    }

    public int getLevel2TotalSlots() {
        return level2TotalSlots;
    }

    public void setLevel2TotalSlots(int level2TotalSlots) {
        this.level2TotalSlots = level2TotalSlots;
    }

    public int getLevel2SlotsExpended() {
        return level2SlotsExpended;
    }

    public void setLevel2SlotsExpended(int level2SlotsExpended) {
        this.level2SlotsExpended = level2SlotsExpended;
    }

    public String getLevel2Slot1() {
        return level2Slot1;
    }

    public void setLevel2Slot1(String level2Slot1) {
        this.level2Slot1 = level2Slot1;
    }

    public boolean isLevel2Prepared1() {
        return level2Prepared1;
    }

    public void setLevel2Prepared1(boolean level2Prepared1) {
        this.level2Prepared1 = level2Prepared1;
    }

    public String getLevel2Slot2() {
        return level2Slot2;
    }

    public void setLevel2Slot2(String level2Slot2) {
        this.level2Slot2 = level2Slot2;
    }

    public boolean isLevel2Prepared2() {
        return level2Prepared2;
    }

    public void setLevel2Prepared2(boolean level2Prepared2) {
        this.level2Prepared2 = level2Prepared2;
    }

    public String getLevel2Slot3() {
        return level2Slot3;
    }

    public void setLevel2Slot3(String level2Slot3) {
        this.level2Slot3 = level2Slot3;
    }

    public boolean isLevel2Prepared3() {
        return level2Prepared3;
    }

    public void setLevel2Prepared3(boolean level2Prepared3) {
        this.level2Prepared3 = level2Prepared3;
    }

    public String getLevel2Slot4() {
        return level2Slot4;
    }

    public void setLevel2Slot4(String level2Slot4) {
        this.level2Slot4 = level2Slot4;
    }

    public boolean isLevel2Prepared4() {
        return level2Prepared4;
    }

    public void setLevel2Prepared4(boolean level2Prepared4) {
        this.level2Prepared4 = level2Prepared4;
    }

    public String getLevel2Slot5() {
        return level2Slot5;
    }

    public void setLevel2Slot5(String level2Slot5) {
        this.level2Slot5 = level2Slot5;
    }

    public boolean isLevel2Prepared5() {
        return level2Prepared5;
    }

    public void setLevel2Prepared5(boolean level2Prepared5) {
        this.level2Prepared5 = level2Prepared5;
    }

    public String getLevel2Slot6() {
        return level2Slot6;
    }

    public void setLevel2Slot6(String level2Slot6) {
        this.level2Slot6 = level2Slot6;
    }

    public boolean isLevel2Prepared6() {
        return level2Prepared6;
    }

    public void setLevel2Prepared6(boolean level2Prepared6) {
        this.level2Prepared6 = level2Prepared6;
    }

    public String getLevel2Slot7() {
        return level2Slot7;
    }

    public void setLevel2Slot7(String level2Slot7) {
        this.level2Slot7 = level2Slot7;
    }

    public boolean isLevel2Prepared7() {
        return level2Prepared7;
    }

    public void setLevel2Prepared7(boolean level2Prepared7) {
        this.level2Prepared7 = level2Prepared7;
    }

    public String getLevel2Slot8() {
        return level2Slot8;
    }

    public void setLevel2Slot8(String level2Slot8) {
        this.level2Slot8 = level2Slot8;
    }

    public boolean isLevel2Prepared8() {
        return level2Prepared8;
    }

    public void setLevel2Prepared8(boolean level2Prepared8) {
        this.level2Prepared8 = level2Prepared8;
    }

    public String getLevel2Slot9() {
        return level2Slot9;
    }

    public void setLevel2Slot9(String level2Slot9) {
        this.level2Slot9 = level2Slot9;
    }

    public boolean isLevel2Prepared9() {
        return level2Prepared9;
    }

    public void setLevel2Prepared9(boolean level2Prepared9) {
        this.level2Prepared9 = level2Prepared9;
    }

    public String getLevel2Slot10() {
        return level2Slot10;
    }

    public void setLevel2Slot10(String level2Slot10) {
        this.level2Slot10 = level2Slot10;
    }

    public boolean isLevel2Prepared10() {
        return level2Prepared10;
    }

    public void setLevel2Prepared10(boolean level2Prepared10) {
        this.level2Prepared10 = level2Prepared10;
    }

    public String getLevel2Slot11() {
        return level2Slot11;
    }

    public void setLevel2Slot11(String level2Slot11) {
        this.level2Slot11 = level2Slot11;
    }

    public boolean isLevel2Prepared11() {
        return level2Prepared11;
    }

    public void setLevel2Prepared11(boolean level2Prepared11) {
        this.level2Prepared11 = level2Prepared11;
    }

    public String getLevel2Slot12() {
        return level2Slot12;
    }

    public void setLevel2Slot12(String level2Slot12) {
        this.level2Slot12 = level2Slot12;
    }

    public boolean isLevel2Prepared12() {
        return level2Prepared12;
    }

    public void setLevel2Prepared12(boolean level2Prepared12) {
        this.level2Prepared12 = level2Prepared12;
    }

    public String getLevel2Slot13() {
        return level2Slot13;
    }

    public void setLevel2Slot13(String level2Slot13) {
        this.level2Slot13 = level2Slot13;
    }

    public boolean isLevel2Prepared13() {
        return level2Prepared13;
    }

    public void setLevel2Prepared13(boolean level2Prepared13) {
        this.level2Prepared13 = level2Prepared13;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
