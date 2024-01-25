package br.com.walkito.fichaOnline.model.dtos;

public class RunDTO {
    private String masterName;

    public RunDTO() {
    }

    public RunDTO(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }
}
