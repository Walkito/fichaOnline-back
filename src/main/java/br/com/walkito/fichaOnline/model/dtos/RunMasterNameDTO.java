package br.com.walkito.fichaOnline.model.dtos;

public class RunMasterNameDTO {
    private String masterName;

    public RunMasterNameDTO() {
    }

    public RunMasterNameDTO(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }
}
