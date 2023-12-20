package br.com.walkito.fichaOnline.model.entities;

import com.fasterxml.jackson.annotation.*;
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

    @Column(nullable = false, length = 1, columnDefinition = "VARCHAR(1) DEFAULT 'J'")
    private String type;

    @Column(nullable = false, length = 1, columnDefinition = "VARCHAR(1) DEFAULT 'A'")
    private String situation;

    @ManyToMany(mappedBy = "accounts")
    @JsonIgnore
    private List<Run> runs = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<PlayerSheet> sheets = new ArrayList<>();

    public Account() {
    }

    public Account(int id){

    }

    public Account(String name, String lastName, String user, String email, String password, String type, String situation) {
        this.name = name;
        this.lastName = lastName;
        this.user = user;
        this.email = email;
        this.password = password;
        this.type = type;
        this.situation = situation;
    }

    public List<Run> getRuns() {
        return runs;
    }

    public void setRuns(List<Run> runs) {
        this.runs = runs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public List<PlayerSheet> getSheets() {
        return sheets;
    }

    public void setSheets(List<PlayerSheet> sheets) {
        this.sheets = sheets;
    }
}
