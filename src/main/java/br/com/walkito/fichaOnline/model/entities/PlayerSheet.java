package br.com.walkito.fichaOnline.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "players_sheets")
public class PlayerSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @NotNull
    private Account account;

    @ManyToOne
    @JoinColumn(name = "run_id")
    private Run run;

    @OneToMany(mappedBy = "playerSheet",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<SheetDnD> sheetsDnd = new ArrayList<>();

    @Column
    private LocalDate dateCreation;

    public PlayerSheet(){

    }

    public PlayerSheet(Account account, Run run, LocalDate dateCreation){
        setAccount(account);
        setRun(run);
        setDateCreation(dateCreation);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        account.getSheets().add(this);
        this.account = account;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        run.getSheets().add(this);
        this.run = run;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SheetDnD> getSheetsDnd() {
        return sheetsDnd;
    }

    public void setSheetsDnd(SheetDnD sheetsDnd) {
        this.sheetsDnd.add(sheetsDnd);
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation == null ? LocalDate.now() : dateCreation;
    }
}
