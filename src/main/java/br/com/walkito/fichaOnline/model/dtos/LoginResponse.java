package br.com.walkito.fichaOnline.model.dtos;

import br.com.walkito.fichaOnline.model.entities.Account;

public class LoginResponse {
    private String token;

    private AccountDTO accountDTO;

    public LoginResponse() {
    }

    public LoginResponse(String token, AccountDTO accountDTO) {
        this.token = token;
        this.accountDTO = accountDTO;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AccountDTO getAccountDTO() {
        return accountDTO;
    }

    public void setAccountDTO(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }
}
