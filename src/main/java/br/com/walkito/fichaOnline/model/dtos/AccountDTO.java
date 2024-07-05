package br.com.walkito.fichaOnline.model.dtos;

public class AccountDTO {

    private int id;

    private String name;

    private String lastName;

    private String user;

    private String role;

    private String profilePictureName;

    public AccountDTO() {
    }

    public AccountDTO(int id, String name, String lastName, String user, String role, String profilePictureName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.user = user;
        this.role = role;
        this.profilePictureName = profilePictureName;
    }

    public String getProfilePictureName() {
        return profilePictureName;
    }

    public void setProfilePictureName(String profilePictureName) {
        this.profilePictureName = profilePictureName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
