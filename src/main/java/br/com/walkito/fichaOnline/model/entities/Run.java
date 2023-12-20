package br.com.walkito.fichaOnline.model.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "runs")
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    @NotBlank
    private String campaign;

    @ManyToOne
    @JoinColumn(name = "system_id")
    @NotNull
    private System system;

    @Column(nullable = false)
    private LocalDate dateBeginning;

    @Column
    private LocalDate dateEnding;

    @ManyToMany()
    @JsonIgnore
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "run", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PlayerSheet> sheets = new ArrayList<>();

    public Run(){

    }

    public Run(int id){

    }

    public Run(String campaign, System system, String inicio, String fim) {
        this.campaign = campaign;
        setSystem(system);

        LocalDate datainicio = inicio.isEmpty() ? LocalDate.now() : LocalDate.parse(inicio);
        LocalDate dataFim = fim.isEmpty() ? null : LocalDate.parse(fim);
        setDateBeginning(datainicio);
        setDateEnding(dataFim);
    }

    public List<PlayerSheet> getSheets() {
        return sheets;
    }

    public void setSheets(List<PlayerSheet> sheets) {
        this.sheets = sheets;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Account account) {
        account.getRuns().add(this);
        this.accounts.add(account);
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
        this.system.setRuns(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateBeginning() {
        return dateBeginning;
    }

    public void setDateBeginning(LocalDate dateBeginning) {
        this.dateBeginning = dateBeginning;
    }

    public LocalDate getDateEnding() {
        return dateEnding;
    }

    public void setDateEnding(LocalDate dateEnding) {
        this.dateEnding = dateEnding;
    }
}
