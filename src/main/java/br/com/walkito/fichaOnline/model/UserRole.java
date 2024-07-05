package br.com.walkito.fichaOnline.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserRole {

    MASTER("master"),

    PLAYER("player");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
