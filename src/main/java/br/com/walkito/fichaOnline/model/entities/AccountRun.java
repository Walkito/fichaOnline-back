package br.com.walkito.fichaOnline.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "accounts_runs")
public class AccountRun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonManagedReference
    private Account account;

    @ManyToOne
    @JoinColumn(name = "run_id")
    @JsonManagedReference
    private Run run;

    public AccountRun(){

    }

    public AccountRun(Account account, Run run) {
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
