package br.com.walkito.fichaOnline.model.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "systems")
public class System {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 20)
    @Size(max = 20)
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "system")
    @JsonIgnore
    private List<Run> runs = new ArrayList<>();

    public System(){

    }

    public System(int id) {
        this.id = id;
    }

    public System(String name) {
        this.name = name;
    }

    public List<Run> getRuns() {
        return runs;
    }

    public void setRuns(Run run) {
        this.runs.add(run);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
