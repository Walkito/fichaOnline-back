package br.com.walkito.fichaOnline.model.entities.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "dnd_spells_four")
public class SpellsLevelFour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 1)
    private int level4TotalSlots;

    @Column(precision = 1)
    private int level4SlotsExpended;

    @Column(length = 20)
    private String level4Slot1;

    @Column
    private boolean level4Prepared1;

    @Column(length = 20)
    private String level4Slot2;

    @Column
    private boolean level4Prepared2;

    @Column(length = 20)
    private String level4Slot3;

    @Column
    private boolean level4Prepared3;

    @Column(length = 20)
    private String level4Slot4;

    @Column
    private boolean level4Prepared4;

    @Column(length = 20)
    private String level4Slot5;

    @Column
    private boolean level4Prepared5;

    @Column(length = 20)
    private String level4Slot6;

    @Column
    private boolean level4Prepared6;

    @Column(length = 20)
    private String level4Slot7;

    @Column
    private boolean level4Prepared7;

    @Column(length = 20)
    private String level4Slot8;

    @Column
    private boolean level4Prepared8;

    @Column(length = 20)
    private String level4Slot9;

    @Column
    private boolean level4Prepared9;

    @Column(length = 20)
    private String level4Slot10;

    @Column
    private boolean level4Prepared10;

    @Column(length = 20)
    private String level4Slot11;

    @Column
    private boolean level4Prepared11;

    @Column(length = 20)
    private String level4Slot12;

    @Column
    private boolean level4Prepared12;

    @Column(length = 20)
    private String level4Slot13;

    @Column
    private boolean level4Prepared13;

    @OneToOne
    @JsonIgnore
    private SheetDnD sheetDnD;

    public SpellsLevelFour() {
    }

    public SpellsLevelFour(int level4TotalSlots, int level4SlotsExpended, String level4Slot1, boolean level4Prepared1, String level4Slot2, boolean level4Prepared2, String level4Slot3, boolean level4Prepared3, String level4Slot4, boolean level4Prepared4, String level4Slot5, boolean level4Prepared5, String level4Slot6, boolean level4Prepared6, String level4Slot7, boolean level4Prepared7, String level4Slot8, boolean level4Prepared8, String level4Slot9, boolean level4Prepared9, String level4Slot10, boolean level4Prepared10, String level4Slot11, boolean level4Prepared11, String level4Slot12, boolean level4Prepared12, String level4Slot13, boolean level4Prepared13) {
        this.level4TotalSlots = level4TotalSlots;
        this.level4SlotsExpended = level4SlotsExpended;
        this.level4Slot1 = level4Slot1;
        this.level4Prepared1 = level4Prepared1;
        this.level4Slot2 = level4Slot2;
        this.level4Prepared2 = level4Prepared2;
        this.level4Slot3 = level4Slot3;
        this.level4Prepared3 = level4Prepared3;
        this.level4Slot4 = level4Slot4;
        this.level4Prepared4 = level4Prepared4;
        this.level4Slot5 = level4Slot5;
        this.level4Prepared5 = level4Prepared5;
        this.level4Slot6 = level4Slot6;
        this.level4Prepared6 = level4Prepared6;
        this.level4Slot7 = level4Slot7;
        this.level4Prepared7 = level4Prepared7;
        this.level4Slot8 = level4Slot8;
        this.level4Prepared8 = level4Prepared8;
        this.level4Slot9 = level4Slot9;
        this.level4Prepared9 = level4Prepared9;
        this.level4Slot10 = level4Slot10;
        this.level4Prepared10 = level4Prepared10;
        this.level4Slot11 = level4Slot11;
        this.level4Prepared11 = level4Prepared11;
        this.level4Slot12 = level4Slot12;
        this.level4Prepared12 = level4Prepared12;
        this.level4Slot13 = level4Slot13;
        this.level4Prepared13 = level4Prepared13;
    }

    public int getLevel4TotalSlots() {
        return level4TotalSlots;
    }

    public void setLevel4TotalSlots(int level4TotalSlots) {
        this.level4TotalSlots = level4TotalSlots;
    }

    public int getLevel4SlotsExpended() {
        return level4SlotsExpended;
    }

    public void setLevel4SlotsExpended(int level4SlotsExpended) {
        this.level4SlotsExpended = level4SlotsExpended;
    }

    public String getLevel4Slot1() {
        return level4Slot1;
    }

    public void setLevel4Slot1(String level4Slot1) {
        this.level4Slot1 = level4Slot1;
    }

    public boolean isLevel4Prepared1() {
        return level4Prepared1;
    }

    public void setLevel4Prepared1(boolean level4Prepared1) {
        this.level4Prepared1 = level4Prepared1;
    }

    public String getLevel4Slot2() {
        return level4Slot2;
    }

    public void setLevel4Slot2(String level4Slot2) {
        this.level4Slot2 = level4Slot2;
    }

    public boolean isLevel4Prepared2() {
        return level4Prepared2;
    }

    public void setLevel4Prepared2(boolean level4Prepared2) {
        this.level4Prepared2 = level4Prepared2;
    }

    public String getLevel4Slot3() {
        return level4Slot3;
    }

    public void setLevel4Slot3(String level4Slot3) {
        this.level4Slot3 = level4Slot3;
    }

    public boolean isLevel4Prepared3() {
        return level4Prepared3;
    }

    public void setLevel4Prepared3(boolean level4Prepared3) {
        this.level4Prepared3 = level4Prepared3;
    }

    public String getLevel4Slot4() {
        return level4Slot4;
    }

    public void setLevel4Slot4(String level4Slot4) {
        this.level4Slot4 = level4Slot4;
    }

    public boolean isLevel4Prepared4() {
        return level4Prepared4;
    }

    public void setLevel4Prepared4(boolean level4Prepared4) {
        this.level4Prepared4 = level4Prepared4;
    }

    public String getLevel4Slot5() {
        return level4Slot5;
    }

    public void setLevel4Slot5(String level4Slot5) {
        this.level4Slot5 = level4Slot5;
    }

    public boolean isLevel4Prepared5() {
        return level4Prepared5;
    }

    public void setLevel4Prepared5(boolean level4Prepared5) {
        this.level4Prepared5 = level4Prepared5;
    }

    public String getLevel4Slot6() {
        return level4Slot6;
    }

    public void setLevel4Slot6(String level4Slot6) {
        this.level4Slot6 = level4Slot6;
    }

    public boolean isLevel4Prepared6() {
        return level4Prepared6;
    }

    public void setLevel4Prepared6(boolean level4Prepared6) {
        this.level4Prepared6 = level4Prepared6;
    }

    public String getLevel4Slot7() {
        return level4Slot7;
    }

    public void setLevel4Slot7(String level4Slot7) {
        this.level4Slot7 = level4Slot7;
    }

    public boolean isLevel4Prepared7() {
        return level4Prepared7;
    }

    public void setLevel4Prepared7(boolean level4Prepared7) {
        this.level4Prepared7 = level4Prepared7;
    }

    public String getLevel4Slot8() {
        return level4Slot8;
    }

    public void setLevel4Slot8(String level4Slot8) {
        this.level4Slot8 = level4Slot8;
    }

    public boolean isLevel4Prepared8() {
        return level4Prepared8;
    }

    public void setLevel4Prepared8(boolean level4Prepared8) {
        this.level4Prepared8 = level4Prepared8;
    }

    public String getLevel4Slot9() {
        return level4Slot9;
    }

    public void setLevel4Slot9(String level4Slot9) {
        this.level4Slot9 = level4Slot9;
    }

    public boolean isLevel4Prepared9() {
        return level4Prepared9;
    }

    public void setLevel4Prepared9(boolean level4Prepared9) {
        this.level4Prepared9 = level4Prepared9;
    }

    public String getLevel4Slot10() {
        return level4Slot10;
    }

    public void setLevel4Slot10(String level4Slot10) {
        this.level4Slot10 = level4Slot10;
    }

    public boolean isLevel4Prepared10() {
        return level4Prepared10;
    }

    public void setLevel4Prepared10(boolean level4Prepared10) {
        this.level4Prepared10 = level4Prepared10;
    }

    public String getLevel4Slot11() {
        return level4Slot11;
    }

    public void setLevel4Slot11(String level4Slot11) {
        this.level4Slot11 = level4Slot11;
    }

    public boolean isLevel4Prepared11() {
        return level4Prepared11;
    }

    public void setLevel4Prepared11(boolean level4Prepared11) {
        this.level4Prepared11 = level4Prepared11;
    }

    public String getLevel4Slot12() {
        return level4Slot12;
    }

    public void setLevel4Slot12(String level4Slot12) {
        this.level4Slot12 = level4Slot12;
    }

    public boolean isLevel4Prepared12() {
        return level4Prepared12;
    }

    public void setLevel4Prepared12(boolean level4Prepared12) {
        this.level4Prepared12 = level4Prepared12;
    }

    public String getLevel4Slot13() {
        return level4Slot13;
    }

    public void setLevel4Slot13(String level4Slot13) {
        this.level4Slot13 = level4Slot13;
    }

    public boolean isLevel4Prepared13() {
        return level4Prepared13;
    }

    public void setLevel4Prepared13(boolean level4Prepared13) {
        this.level4Prepared13 = level4Prepared13;
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
