package br.com.walkito.fichaOnline.model.dtos;

import br.com.walkito.fichaOnline.model.entities.Run;

public class MusicDTO {

    private String name;

    private String link;

    private Run run;

    public MusicDTO() {
    }

    public MusicDTO(String name, String link, Run run) {
        this.name = name;
        this.link = link;
        this.run = run;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }
}
