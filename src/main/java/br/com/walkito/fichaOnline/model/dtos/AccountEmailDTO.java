package br.com.walkito.fichaOnline.model.dtos;

public class AccountEmailDTO extends AccountDTO {
    private String email;

    public AccountEmailDTO() {
    }

    public AccountEmailDTO(String email) {
        this.email = email;
    }

    public AccountEmailDTO(int id, String name, String lastName, String user, String type, String email) {
        super(id, name, lastName, user, type);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
