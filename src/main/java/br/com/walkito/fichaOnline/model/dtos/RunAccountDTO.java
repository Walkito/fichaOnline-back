package br.com.walkito.fichaOnline.model.dtos;

public class RunAccountDTO {
    private int idRun;
    private int idAccount;

    private String dateCreation;

    public int getIdRun() {
        return idRun;
    }

    public void setIdRun(int idRun) {
        this.idRun = idRun;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
