package br.com.walkito.fichaOnline.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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
    @JsonManagedReference
    private System system;

    @OneToMany(mappedBy = "run", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<AccountRun> accountsRuns = new ArrayList<>();

    public Run(){

    }

    public Run(String campaign, System system) {
        this.campaign = campaign;
        this.system = system;
    }

    public List<AccountRun> getAccountsRuns() {
        return accountsRuns;
    }

    public void setAccountsRuns(List<AccountRun> accountsRuns) {
        this.accountsRuns = accountsRuns;
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
    }
}
