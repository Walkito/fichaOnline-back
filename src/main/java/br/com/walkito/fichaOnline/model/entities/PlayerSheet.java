package br.com.walkito.fichaOnline.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "players_sheets")
public class PlayerSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "accounts_id")
    @JsonManagedReference
    private Account account;

    @ManyToOne
    @JoinColumn(name = "runs_id")
    @JsonManagedReference
    private Run run;

    @OneToMany(mappedBy = "playerSheet",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonBackReference
    private List<SheetDnD> sheetDnd = new ArrayList<>();

    public PlayerSheet(){

    }

    public PlayerSheet(Account account, Run run) {
        this.account = account;
        this.run = run;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }
}
