package br.com.walkito.fichaOnline.model.entities;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

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
    @NotNull
    private Run run;

    @OneToOne
    @JoinColumn(name = "sheetsDnD_id", unique = true)
    private SheetDnD sheetDnD;

    @Column
    private LocalDate dateCreation;

    public PlayerSheet(){

    }

    public PlayerSheet(Account account, Run run, LocalDate dateCreation){
        setAccount(account);
        setRun(run);
        setDateCreation(dateCreation);
    }

    public PlayerSheet(int id){

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

    public SheetDnD getSheetDnD() {
        return sheetDnD;
    }

    public void setSheetDnD(SheetDnD sheetDnD) {
        this.sheetDnD = sheetDnD;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation == null ? LocalDate.now() : dateCreation;
    }
}
