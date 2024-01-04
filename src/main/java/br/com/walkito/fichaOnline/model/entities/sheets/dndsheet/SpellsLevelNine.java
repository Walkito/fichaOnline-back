package br.com.walkito.fichaOnline.model.entities.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "dnd_spells_nine")
public class SpellsLevelNine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 2)
    private int level9TotalSlots;

    @Column(precision = 2)
    private int level9SlotsExpended;

    @Column(length = 60)
    private String level9Slot1;

    @Column
    private boolean level9Prepared1;

    @Column(length = 60)
    private String level9Slot2;

    @Column
    private boolean level9Prepared2;

    @Column(length = 60)
    private String level9Slot3;

    @Column
    private boolean level9Prepared3;

    @Column(length = 60)
    private String level9Slot4;

    @Column
    private boolean level9Prepared4;

    @Column(length = 60)
    private String level9Slot5;

    @Column
    private boolean level9Prepared5;

    @Column(length = 60)
    private String level9Slot6;

    @Column
    private boolean level9Prepared6;

    @Column(length = 60)
    private String level9Slot7;

    @Column
    private boolean level9Prepared7;

    public SpellsLevelNine() {
    }

    public SpellsLevelNine(int level9TotalSlots, int level9SlotsExpended, String level9Slot1, boolean level9Prepared1, String level9Slot2, boolean level9Prepared2, String level9Slot3, boolean level9Prepared3, String level9Slot4, boolean level9Prepared4, String level9Slot5, boolean level9Prepared5, String level9Slot6, boolean level9Prepared6, String level9Slot7, boolean level9Prepared7) {
        this.level9TotalSlots = level9TotalSlots;
        this.level9SlotsExpended = level9SlotsExpended;
        this.level9Slot1 = level9Slot1;
        this.level9Prepared1 = level9Prepared1;
        this.level9Slot2 = level9Slot2;
        this.level9Prepared2 = level9Prepared2;
        this.level9Slot3 = level9Slot3;
        this.level9Prepared3 = level9Prepared3;
        this.level9Slot4 = level9Slot4;
        this.level9Prepared4 = level9Prepared4;
        this.level9Slot5 = level9Slot5;
        this.level9Prepared5 = level9Prepared5;
        this.level9Slot6 = level9Slot6;
        this.level9Prepared6 = level9Prepared6;
        this.level9Slot7 = level9Slot7;
        this.level9Prepared7 = level9Prepared7;
    }

    public int getLevel9TotalSlots() {
        return level9TotalSlots;
    }

    public void setLevel9TotalSlots(int level9TotalSlots) {
        this.level9TotalSlots = level9TotalSlots;
    }

    public int getLevel9SlotsExpended() {
        return level9SlotsExpended;
    }

    public void setLevel9SlotsExpended(int level9SlotsExpended) {
        this.level9SlotsExpended = level9SlotsExpended;
    }

    public String getLevel9Slot1() {
        return level9Slot1;
    }

    public void setLevel9Slot1(String level9Slot1) {
        this.level9Slot1 = level9Slot1;
    }

    public boolean isLevel9Prepared1() {
        return level9Prepared1;
    }

    public void setLevel9Prepared1(boolean level9Prepared1) {
        this.level9Prepared1 = level9Prepared1;
    }

    public String getLevel9Slot2() {
        return level9Slot2;
    }

    public void setLevel9Slot2(String level9Slot2) {
        this.level9Slot2 = level9Slot2;
    }

    public boolean isLevel9Prepared2() {
        return level9Prepared2;
    }

    public void setLevel9Prepared2(boolean level9Prepared2) {
        this.level9Prepared2 = level9Prepared2;
    }

    public String getLevel9Slot3() {
        return level9Slot3;
    }

    public void setLevel9Slot3(String level9Slot3) {
        this.level9Slot3 = level9Slot3;
    }

    public boolean isLevel9Prepared3() {
        return level9Prepared3;
    }

    public void setLevel9Prepared3(boolean level9Prepared3) {
        this.level9Prepared3 = level9Prepared3;
    }

    public String getLevel9Slot4() {
        return level9Slot4;
    }

    public void setLevel9Slot4(String level9Slot4) {
        this.level9Slot4 = level9Slot4;
    }

    public boolean isLevel9Prepared4() {
        return level9Prepared4;
    }

    public void setLevel9Prepared4(boolean level9Prepared4) {
        this.level9Prepared4 = level9Prepared4;
    }

    public String getLevel9Slot5() {
        return level9Slot5;
    }

    public void setLevel9Slot5(String level9Slot5) {
        this.level9Slot5 = level9Slot5;
    }

    public boolean isLevel9Prepared5() {
        return level9Prepared5;
    }

    public void setLevel9Prepared5(boolean level9Prepared5) {
        this.level9Prepared5 = level9Prepared5;
    }

    public String getLevel9Slot6() {
        return level9Slot6;
    }

    public void setLevel9Slot6(String level9Slot6) {
        this.level9Slot6 = level9Slot6;
    }

    public boolean isLevel9Prepared6() {
        return level9Prepared6;
    }

    public void setLevel9Prepared6(boolean level9Prepared6) {
        this.level9Prepared6 = level9Prepared6;
    }

    public String getLevel9Slot7() {
        return level9Slot7;
    }

    public void setLevel9Slot7(String level9Slot7) {
        this.level9Slot7 = level9Slot7;
    }

    public boolean isLevel9Prepared7() {
        return level9Prepared7;
    }

    public void setLevel9Prepared7(boolean level9Prepared7) {
        this.level9Prepared7 = level9Prepared7;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
