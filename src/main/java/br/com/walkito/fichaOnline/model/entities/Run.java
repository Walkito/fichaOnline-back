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

    @Column(length = 20)
    @Size(max = 50)
    private String status;

    @Column(nullable = false)
    @NotNull
    private int masterId;

    @Column
    @NotNull
    private int sessionNumber;

    @Column(columnDefinition = "TEXT")
    private String annotationOne;

    @Column(columnDefinition = "TEXT")
    private String annotationTwo;

    @Column(columnDefinition = "TEXT")
    private String annotationThree;

    @Column(columnDefinition = "TEXT")
    private String annotationFour;

    @Column(columnDefinition = "TEXT")
    private String annotationFive;

    @Column(columnDefinition = "TEXT")
    private String annotationSix;

    @Column(length = 10)
    @Size(max = 10)
    private String discordBotCommand;

    @ManyToMany
    @JsonProperty
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "run", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PlayerSheet> sheets = new ArrayList<>();

    @OneToMany(mappedBy = "run", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Npc> npcs = new ArrayList<>();

    @OneToMany(mappedBy = "run", cascade = CascadeType.ALL)
    private List<Music> musics = new ArrayList<>();

    public Run(){

    }

    public Run(int id){

    }

    public Run(String campaign, System system, String inicio, String fim, int masterId, int sessionNumber) {
        this.campaign = campaign;
        this.sessionNumber = sessionNumber;
        setSystem(system);


        LocalDate datainicio = inicio.isEmpty() ? LocalDate.now() : LocalDate.parse(inicio);
        LocalDate dataFim = fim.isEmpty() ? null : LocalDate.parse(fim);
        setDateBeginning(datainicio);
        setDateEnding(dataFim);

        setMasterId(masterId);
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public String getAnnotationOne() {
        return annotationOne;
    }

    public void setAnnotationOne(String annotationOne) {
        this.annotationOne = annotationOne;
    }

    public String getAnnotationTwo() {
        return annotationTwo;
    }

    public void setAnnotationTwo(String annotationTwo) {
        this.annotationTwo = annotationTwo;
    }

    public String getAnnotationThree() {
        return annotationThree;
    }

    public void setAnnotationThree(String annotationThree) {
        this.annotationThree = annotationThree;
    }

    public String getAnnotationFour() {
        return annotationFour;
    }

    public void setAnnotationFour(String annotationFour) {
        this.annotationFour = annotationFour;
    }

    public String getAnnotationFive() {
        return annotationFive;
    }

    public void setAnnotationFive(String annotationFive) {
        this.annotationFive = annotationFive;
    }

    public String getAnnotationSix() {
        return annotationSix;
    }

    public void setAnnotationSix(String annotationSix) {
        this.annotationSix = annotationSix;
    }

    public List<Npc> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<Npc> npcs) {
        this.npcs = npcs;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
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

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setLinkAccount(Account account) {
        account.getRuns().add(this);
        this.accounts.add(account);
    }

    public void unlinkAccount(Account account){
        account.getRuns().remove(this);
        this.accounts.remove(account);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    public String getDiscordBotCommand() {
        return discordBotCommand;
    }

    public void setDiscordBotCommand(String discordBotCommand) {
        this.discordBotCommand = discordBotCommand;
    }
}
