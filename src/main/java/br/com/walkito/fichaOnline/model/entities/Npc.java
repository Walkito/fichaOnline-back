package br.com.walkito.fichaOnline.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "npcs")
public class Npc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    @Size(max = 50)
    private String name;

    @Column(length = 50)
    @Size(max = 50)
    private String race;

    @Column(length = 50)
    @Size(max = 50)
    private String whatDo;

    @Column(length = 50)
    @Size(max = 50)
    private String location;

    @Column(length = 50)
    @Size(max = 50)
    private String session;

    @ManyToOne
    @JoinColumn(name = "run_id", referencedColumnName = "id")
    @NotNull
    private Run run;

    public Npc() {
    }

    public Npc(String name, String race, String whatDo, String location, String session, Run run) {
        this.name = name;
        this.race = race;
        this.whatDo = whatDo;
        this.location = location;
        this.session = session;
        this.run = run;
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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }

    public String getWhatDo() {
        return whatDo;
    }

    public void setWhatDo(String whatDo) {
        this.whatDo = whatDo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
