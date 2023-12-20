package br.com.walkito.fichaOnline.model.entities.dndsheet;

import br.com.walkito.fichaOnline.model.entities.SheetDnD;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dnd_personality")
public class Personality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String personalityTraits;

    @Column(length = 100)
    @Size(max = 100)
    private String ideals;

    @Column(length = 100)
    @Size(max = 100)
    private String bonds;

    @Column(length = 100)
    @Size(max = 100)
    private String flaws;

    @OneToOne
    @JsonIgnore
    private SheetDnD sheetDnD;

    public Personality() {
    }

    public Personality(String personalityTraits, String ideals, String bonds, String flaws) {
        this.personalityTraits = personalityTraits;
        this.ideals = ideals;
        this.bonds = bonds;
        this.flaws = flaws;
    }

    public String getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(String personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public String getIdeals() {
        return ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getBonds() {
        return bonds;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public String getFlaws() {
        return flaws;
    }

    public void setFlaws(String flaws) {
        this.flaws = flaws;
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
