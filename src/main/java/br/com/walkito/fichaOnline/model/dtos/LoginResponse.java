package br.com.walkito.fichaOnline.model.dtos;

import br.com.walkito.fichaOnline.model.entities.Account;

public class LoginResponse {
    private String token;

    private Account account;

    public LoginResponse() {
    }

    public LoginResponse(String token, Account account) {
        this.token = token;
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
