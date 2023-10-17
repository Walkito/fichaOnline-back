package br.com.walkito.fichaOnline.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 15)
    @Size(max = 15)
    @NotBlank
    private String name;

    @Column(length = 20)
    @Size(max = 20)
    @NotBlank
    private String lastName;

    @Column(nullable = false, unique = true, length = 20)
    @Size(max = 20)
    @NotBlank
    private String user;

    @Column(nullable = false, unique = true, length = 50)
    @Size(max = 50)
    @NotBlank
    private String email;

    @Column(nullable = false, length = 30)
    @Size(max = 30)
    @NotBlank
    private String password;

    @Column(nullable = false, length = 2)
    @Size(max = 2)
    @NotBlank
    private String type;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<AccountRun> accountRuns = new ArrayList<>();

    public Account(){

    }

    public Account(String name, String lastName, String user, String email, String password, String type) {
        this.name = name;
        this.lastName = lastName;
        this.user = user;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AccountRun> getAccountRuns() {
        return accountRuns;
    }

    public void setAccountRuns(List<AccountRun> accountRuns) {
        this.accountRuns = accountRuns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
