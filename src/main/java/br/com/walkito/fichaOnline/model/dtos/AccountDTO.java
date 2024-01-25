package br.com.walkito.fichaOnline.model.dtos;

public class AccountDTO {

    private int id;

    private String name;

    private String lastName;

    private String user;

    private String type;

    public AccountDTO() {
    }

    public AccountDTO(int id, String name, String lastName, String user, String type) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.user = user;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
